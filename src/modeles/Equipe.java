/*
 * @author Sanaâ (et Yijia)
 */


package modeles;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe représentant une équipe.
 */
public class Equipe implements Serializable {
    private static final long serialVersionUID = 1L;
    private Pays sonPays;
    private ArrayList<Athlete> sesAthletes;
    private String nomEquipe;
    private int nbMembresEquipe;

    /**
     * Constructeur de la classe Equipe.
     *
     * @param sonPays         le pays de l'équipe
     * @param sesAthletes     la liste des athlètes de l'équipe
     * @param nomEquipe       le nom de l'équipe
     * @param nbMembresEquipe le nombre de membres de l'équipe
     */
    public Equipe(Pays sonPays, ArrayList<Athlete> sesAthletes, String nomEquipe, int nbMembresEquipe) {
        this.sonPays = sonPays;
        this.nomEquipe = nomEquipe;
        this.sesAthletes = sesAthletes;
        this.nbMembresEquipe = nbMembresEquipe;
    }

    /**
     * Constructeur de la classe Equipe.
     *
     * @param nomEquipe       le nom de l'équipe
     * @param sonPays         le pays de l'équipe
     * @param nbMembresEquipe le nombre de membres de l'équipe
     */
    public Equipe(String nomEquipe, Pays sonPays, int nbMembresEquipe) {
        this.nomEquipe = nomEquipe;
        this.sonPays = sonPays;
        this.nbMembresEquipe = nbMembresEquipe;
        this.sesAthletes = new ArrayList<>();
    }

    /**
     * Affiche les informations de l'équipe.
     */
    public void afficherInfoEquipe() {
        System.out.println("Informations de l'équipe " + nomEquipe + ":");
        System.out.println("Pays: " + sonPays.getNomPays());
        System.out.println("Nombre de membres: " + nbMembresEquipe);
    }

    /**
     * Affiche les athlètes de l'équipe.
     */
    public void afficherAthletesParEquipe() {
        System.out.println("Liste des athlètes de l'équipe " + nomEquipe + ":");
        for (Athlete athlete : sesAthletes) {
            System.out.println(athlete.getPrenomAthlete() + " " + athlete.getNomAthlete());
        }
    }

    // Getters and setters

    public String getNomEquipe() {
        return this.nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public void ajouterAthlete(Athlete athlete) {
        sesAthletes.add(athlete);
    }

    public void supprimerAthlete(Athlete athlete) {
        sesAthletes.remove(athlete);
    }

    public void setNbMembresEquipe(int nbMembresEquipe) {
        this.nbMembresEquipe = nbMembresEquipe;
    }

    public int getNbMembresEquipe() {
        return this.nbMembresEquipe;
    }

    public Pays getPays() {
        return this.sonPays;
    }

    public void saisirNomEquipe() {
        // Méthode à implémenter pour saisir le nom de l'équipe
    }

    public ArrayList<Athlete> getSesAthletes() {
        return this.sesAthletes;
    }
}
