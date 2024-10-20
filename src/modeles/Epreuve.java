/*
 * @author Jakub (et Yijia)
 */

package modeles;

import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Classe représentant une épreuve.
 */
public class Epreuve {
    private String nomEpreuve;
    private String descriptionEpreuve;
    private Date dateEpreuve;
    private LocalTime debutEpreuve;
    private LocalTime finEpreuve;
    private Site siteEpreuve;
    private Sport sportEpreuve;
    private Session sessionEpreuve;
    private ArrayList<Equipe> listeEquipes;

    /**
     * Constructeur de la classe Epreuve.
     *
     * @param nomEpreuve        le nom de l'épreuve
     * @param descriptionEpreuve la description de l'épreuve
     * @param dateEpreuve       la date de l'épreuve
     * @param debutEpreuve      l'heure de début de l'épreuve
     * @param finEpreuve        l'heure de fin de l'épreuve
     * @param siteEpreuve       le site de l'épreuve
     * @param sportEpreuve      le sport de l'épreuve
     */
    public Epreuve(String nomEpreuve, String descriptionEpreuve, Date dateEpreuve, LocalTime debutEpreuve,
                   LocalTime finEpreuve, Site siteEpreuve, Sport sportEpreuve) {
        this.nomEpreuve = nomEpreuve;
        this.descriptionEpreuve = descriptionEpreuve;
        this.dateEpreuve = dateEpreuve;
        this.debutEpreuve = debutEpreuve;
        this.finEpreuve = finEpreuve;
        this.siteEpreuve = siteEpreuve;
        this.sportEpreuve = sportEpreuve;
        this.listeEquipes = new ArrayList<>();
    }

    /**
     * Affiche les détails de l'épreuve.
     *
     * @return une chaîne de caractères représentant les détails de l'épreuve
     */
    public String afficheEpreuve() {
        return "nomEpreuve: " + nomEpreuve + " descriptionEpreuve: " + descriptionEpreuve +
                " dateEpreuve: " + dateEpreuve + " debutEpreuve: " + debutEpreuve +
                " finEpreuve: " + finEpreuve + " siteEpreuve: " + siteEpreuve.getNomSite() +
                " sportEpreuve: " + sportEpreuve.getNomSport();
    }

    // Getters and setters

    public void setSessionEpreuve(Session sessionEpreuve) {
        this.sessionEpreuve = sessionEpreuve;
    }

    public String getNomEpreuve() {
        return nomEpreuve;
    }

    public void setNomEpreuve(String nomEpreuve) {
        this.nomEpreuve = nomEpreuve;
    }

    public String getDescriptionEpreuve() {
        return descriptionEpreuve;
    }

    public void setDescriptionEpreuve(String descriptionEpreuve) {
        this.descriptionEpreuve = descriptionEpreuve;
    }

    public Date getDateEpreuve() {
        return dateEpreuve;
    }

    public void setDateEpreuve(Date dateEpreuve) {
        this.dateEpreuve = dateEpreuve;
    }

    public LocalTime getDebutEpreuve() {
        return debutEpreuve;
    }

    public void setDebutEpreuve(LocalTime debutEpreuve) {
        this.debutEpreuve = debutEpreuve;
    }

    public LocalTime getFinEpreuve() {
        return finEpreuve;
    }

    public void setFinEpreuve(LocalTime finEpreuve) {
        this.finEpreuve = finEpreuve;
    }

    public Site getSiteEpreuve() {
        return siteEpreuve;
    }

    public void setSiteEpreuve(Site siteEpreuve) {
        this.siteEpreuve = siteEpreuve;
    }

    public Sport getSportEpreuve() {
        return sportEpreuve;
    }

    public void setSportEpreuve(Sport sportEpreuve) {
        this.sportEpreuve = sportEpreuve;
    }

    public ArrayList<Equipe> getListeEquipes() {
        return listeEquipes;
    }

    public void setListeEquipes(ArrayList<Equipe> listeEquipes) {
        this.listeEquipes = listeEquipes;
    }
}
