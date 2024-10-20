/*
 * @author Sanaâ (et Yijia)
 */

package modeles;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe représentant un athlète.
 */
public class Athlete implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nomAthlete;
    private String prenomAthlete;
    private Date dateNaissanceAthlete;
    private String genreAthlete;
    private String descriptionAthlete;

    /**
     * Constructeur de la classe Athlete.
     *
     * @param nomAthlete           le nom de l'athlète
     * @param prenomAthlete        le prénom de l'athlète
     * @param dateNaissanceAthlete la date de naissance de l'athlète
     * @param genreAthlete         le genre de l'athlète
     * @param descriptionAthlete   la description de l'athlète
     */
    public Athlete(String nomAthlete, String prenomAthlete, Date dateNaissanceAthlete, String genreAthlete,
                   String descriptionAthlete) {
        this.nomAthlete = nomAthlete;
        this.prenomAthlete = prenomAthlete;
        this.dateNaissanceAthlete = dateNaissanceAthlete;
        this.genreAthlete = genreAthlete;
        this.descriptionAthlete = descriptionAthlete;
    }

    /**
     * Affiche le palmarès de l'athlète.
     */
    public void afficherPalmaresAthlete() {
        System.out.println("Palmarès de l'athlète " + prenomAthlete + " " + nomAthlete + ":");
        // Afficher le palmarès (supposons que vous ayez une méthode toString dans la classe Medaille)
    }

    /**
     * Affiche les informations sur l'athlète.
     */
    public void afficherInfoAthlete() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Informations sur l'athlète:");
        System.out.println("Nom: " + nomAthlete);
        System.out.println("Prénom: " + prenomAthlete);
        System.out.println("Date de naissance: " + formatter.format(dateNaissanceAthlete));
        System.out.println("Genre: " + genreAthlete);
        System.out.println("Description: " + descriptionAthlete);
    }

    /**
     * Affiche les résultats de l'athlète.
     */
    public void afficherResultatParAthlete() {
        System.out.println("Résultats de l'athlète " + prenomAthlete + " " + nomAthlete + ":");
        // Afficher les résultats
    }

    // Getters et setters

    public String getNomAthlete() {
        return nomAthlete;
    }

    public void setNomAthlete(String nomAthlete) {
        this.nomAthlete = nomAthlete;
    }

    public String getPrenomAthlete() {
        return prenomAthlete;
    }

    public void setPrenomAthlete(String prenomAthlete) {
        this.prenomAthlete = prenomAthlete;
    }

    public Date getDateNaissanceAthlete() {
        return dateNaissanceAthlete;
    }

    public void setDateNaissanceAthlete(Date dateNaissanceAthlete) {
        this.dateNaissanceAthlete = dateNaissanceAthlete;
    }

    public String getGenreAthlete() {
        return genreAthlete;
    }

    public void setGenreAthlete(String genreAthlete) {
        this.genreAthlete = genreAthlete;
    }

    public String getDescriptionAthlete() {
        return descriptionAthlete;
    }

    public void setDescriptionAthlete(String descriptionAthlete) {
        this.descriptionAthlete = descriptionAthlete;
    }

    @Override
    public String toString() {
        return nomAthlete + " " + prenomAthlete;
    }
}
