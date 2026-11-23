package com.madapay.model;

import java.time.Instant;
import java.util.UUID;

/**
 * Un compte MadaPay, tel que l'API le renvoie en JSON.
 * Jackson utilise les getters pour fabriquer le JSON, et SNAKE_CASE
 * (application.properties) transforme getPlafondJournalier() en "plafond_journalier".
 */
public class Compte {

    private UUID id;
    private String telephone;
    private String titulaire;
    private long solde;
    private long plafondJournalier;
    private Instant creeLe;

    public Compte(UUID id, String telephone, String titulaire, long solde,
                  long plafondJournalier, Instant creeLe) {
        this.id = id;
        this.telephone = telephone;
        this.titulaire = titulaire;
        this.solde = solde;
        this.plafondJournalier = plafondJournalier;
        this.creeLe = creeLe;
    }

    public UUID getId() {
        return id;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getTitulaire() {
        return titulaire;
    }

    public long getSolde() {
        return solde;
    }

    public void setSolde(long solde) {
        this.solde = solde;
    }

    public long getPlafondJournalier() {
        return plafondJournalier;
    }

    public Instant getCreeLe() {
        return creeLe;
    }
}
