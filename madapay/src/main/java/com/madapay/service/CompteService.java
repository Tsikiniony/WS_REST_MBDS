package com.madapay.service;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.madapay.model.Compte;
import com.madapay.model.Seed;

import tools.jackson.databind.json.JsonMapper;

/**
 * Charge les comptes de seed.json au démarrage et les garde en mémoire.
 */
@Service
public class CompteService {

    /** Les comptes, indexés par leur UUID (LinkedHashMap garde l'ordre du seed). */
    private final Map<UUID, Compte> comptes = new LinkedHashMap<>();

    public CompteService(JsonMapper mapper) throws IOException {
        try (InputStream in = new ClassPathResource("seed.json").getInputStream()) {
            Seed seed = mapper.readValue(in, Seed.class);
            Instant maintenant = Instant.now();
            for (Seed.SeedCompte s : seed.getComptes()) {
                Compte c = new Compte(
                        UUID.randomUUID(),       // UUID généré au chargement
                        s.getTelephone(),
                        s.getTitulaire(),
                        s.getSolde(),
                        seed.getPlafondJournalier(),
                        maintenant);
                comptes.put(c.getId(), c);
            }
        }
        System.out.println(">>> " + comptes.size() + " comptes chargés depuis seed.json");
    }

    /** Tous les comptes, ou seulement celui du téléphone donné (si telephone != null). */
    public List<Compte> rechercher(String telephone) {
        List<Compte> resultat = new ArrayList<>();
        for (Compte c : comptes.values()) {
            if (telephone == null || c.getTelephone().equals(telephone)) {
                resultat.add(c);
            }
        }
        return resultat;
    }

    /** Le compte de cet id, ou Optional.empty() s'il n'existe pas. */
    public Optional<Compte> parId(UUID id) {
        return Optional.ofNullable(comptes.get(id));
    }
}
