package com.madapay.model;

import java.util.List;

/**
 * Structure du fichier seed.json (jeu de données chargé au démarrage).
 * Jackson a besoin d'un constructeur vide et des setters pour remplir l'objet
 * à partir du JSON ; SNAKE_CASE fait correspondre "plafond_journalier" à setPlafondJournalier().
 */
public class Seed {

    private int version;
    private long plafondJournalier;
    private List<SeedCompte> comptes;

    public Seed() {
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public long getPlafondJournalier() {
        return plafondJournalier;
    }

    public void setPlafondJournalier(long plafondJournalier) {
        this.plafondJournalier = plafondJournalier;
    }

    public List<SeedCompte> getComptes() {
        return comptes;
    }

    public void setComptes(List<SeedCompte> comptes) {
        this.comptes = comptes;
    }

    /** Un compte tel qu'il est écrit dans seed.json. */
    public static class SeedCompte {

        private String cle;
        private String titulaire;
        private String telephone;
        private String codePin;
        private String role;
        private long solde;

        public SeedCompte() {
        }

        public String getCle() {
            return cle;
        }

        public void setCle(String cle) {
            this.cle = cle;
        }

        public String getTitulaire() {
            return titulaire;
        }

        public void setTitulaire(String titulaire) {
            this.titulaire = titulaire;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getCodePin() {
            return codePin;
        }

        public void setCodePin(String codePin) {
            this.codePin = codePin;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public long getSolde() {
            return solde;
        }

        public void setSolde(long solde) {
            this.solde = solde;
        }
    }
}
