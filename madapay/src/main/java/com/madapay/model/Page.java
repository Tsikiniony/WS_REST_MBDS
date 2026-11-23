package com.madapay.model;

import java.util.List;

/**
 * Une page de résultats : { "page", "taille", "total", "elements" }.
 * Générique (<T>) pour être réutilisée plus tard (bénéficiaires, transactions...).
 */
public class Page<T> {

    private int page;
    private int taille;
    private int total;
    private List<T> elements;

    public Page(int page, int taille, int total, List<T> elements) {
        this.page = page;
        this.taille = taille;
        this.total = total;
        this.elements = elements;
    }

    /** Découpe une liste complète pour n'en garder que la page demandée. */
    public static <T> Page<T> de(List<T> tous, int page, int taille) {
        int debut = Math.min((page - 1) * taille, tous.size());
        int fin = Math.min(debut + taille, tous.size());
        return new Page<>(page, taille, tous.size(), tous.subList(debut, fin));
    }

    public int getPage() {
        return page;
    }

    public int getTaille() {
        return taille;
    }

    public int getTotal() {
        return total;
    }

    public List<T> getElements() {
        return elements;
    }
}
