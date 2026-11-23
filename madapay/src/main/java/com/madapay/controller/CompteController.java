package com.madapay.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.madapay.model.Compte;
import com.madapay.model.Page;
import com.madapay.service.CompteService;

/**
 * Routes HTTP des comptes : GET /comptes et GET /comptes/{id}.
 */
@RestController
@RequestMapping("/comptes")
public class CompteController {

    private final CompteService service;

    public CompteController(CompteService service) {
        this.service = service;
    }

    /** GET /comptes?page=1&taille=20&telephone=... */
    @GetMapping
    public Page<Compte> lister(@RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "20") int taille,
                               @RequestParam(required = false) String telephone) {
        return Page.de(service.rechercher(telephone), page, taille);
    }

    /** GET /comptes/{id} : 200 avec le compte, ou 404 s'il n'existe pas. */
    @GetMapping("/{id}")
    public ResponseEntity<Compte> lire(@PathVariable UUID id) {
        return ResponseEntity.of(service.parId(id));
    }
}
