/*
 * @author Sanaâ (et Yijia)
 */

package modeles;

import java.util.ArrayList;

/**
 * Classe représentant un pays.
 */
public class Pays {

    private ArrayList<Medaille> medaillesParPays;
    private ArrayList<Equipe> sesEquipes;
    private String nomPays;
    private String continentPays;

    /**
     * Constructeur de la classe Pays.
     *
     * @param nomPays      le nom du pays
     * @param continentPays le continent du pays
     */
    public Pays(String nomPays, String continentPays) {
        this.nomPays = nomPays;
        this.continentPays = continentPays;
        this.sesEquipes = new ArrayList<>();
        this.medaillesParPays = new ArrayList<>();
    }

    /**
     * Affiche les résultats par pays.
     */
    public void afficherResultatParPays() {
        // Implémentation pour afficher les résultats par pays
        System.out.println("Résultats pour le pays " + nomPays + " (" + continentPays + "):");
        // Implémentez votre logique ici
    }

    /**
     * Affiche les informations sur le pays.
     */
    public void afficherInfoPays() {
        // Implémentation pour afficher les informations sur le pays
        System.out.println("Informations sur le pays:");
        System.out.println("Nom du pays: " + nomPays);
        System.out.println("Continent: " + continentPays);
        // Ajoutez plus de détails si nécessaire
    }

    /**
     * Affiche les athlètes du pays.
     */
    public void afficherAthlete() {
        // Implémentation pour afficher les athlètes pour ce pays
        System.out.println("Athlètes du pays " + nomPays + " (" + continentPays + "):");
        // Implémentez votre logique ici
    }

    /**
     * Obtient le nom du pays.
     *
     * @return le nom du pays
     */
    public String getNomPays() {
        return nomPays;
    }

    /**
     * Obtient le continent du pays.
     *
     * @return le continent du pays
     */
    public String getContinentPays() {
        return continentPays;
    }
}
