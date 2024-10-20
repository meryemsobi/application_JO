/*
 * @author Jakub (et Yijia)
 */

package modeles;

import java.util.ArrayList;
import java.util.Date;

/**
 * Représente une session d'épreuves.
 */
public class Session {
    private String nomSession;
    private Date dateDebutSession;
    private Date dateFinSession;
    private ArrayList<Epreuve> sesEpreuves;
    private int nbEpreuves;

    /**
     * Constructeur de la classe Session.
     *
     * @param nomSession       le nom de la session
     * @param dateDebutSession la date de début de la session
     * @param dateFinSession   la date de fin de la session
     */
    public Session(String nomSession, Date dateDebutSession, Date dateFinSession) {
        this.nomSession = nomSession;
        this.dateDebutSession = dateDebutSession;
        this.dateFinSession = dateFinSession;
        this.sesEpreuves = new ArrayList<>();
        this.nbEpreuves = 0;
    }

    // Getters et setters

    public String getNomSession() {
        return nomSession;
    }

    public void setNomSession(String nomSession) {
        this.nomSession = nomSession;
    }

    public Date getDateDebutSession() {
        return dateDebutSession;
    }

    public void setDateDebutSession(Date dateDebutSession) {
        this.dateDebutSession = dateDebutSession;
    }

    public Date getDateFinSession() {
        return dateFinSession;
    }

    public void setDateFinSession(Date dateFinSession) {
        this.dateFinSession = dateFinSession;
    }

    public ArrayList<Epreuve> getSesEpreuves() {
        return sesEpreuves;
    }

    public void setSesEpreuves(ArrayList<Epreuve> sesEpreuves) {
        this.sesEpreuves = sesEpreuves;
    }

    public int getNbEpreuves() {
        return nbEpreuves;
    }

    public void setNbEpreuves(int nbEpreuves) {
        this.nbEpreuves = nbEpreuves;
    }

    // Méthodes

    /**
     * Affiche les informations de la session.
     *
     * @return une chaîne de caractères représentant les informations de la session
     */
    public String afficherPlanige() {
        StringBuilder resul = new StringBuilder();
        resul.append("La session de ").append(this.nomSession).append(" aura lieu entre le ")
                .append(this.dateDebutSession).append(" et le ").append(this.dateFinSession).append("\n");
        resul.append("Les épreuves sont :\n");
        for (int i = 0; i < this.nbEpreuves; i++) {
            if (this.sesEpreuves.get(i).getDateEpreuve().after(new Date())) {
                resul.append(this.sesEpreuves.get(i).afficheEpreuve()).append("\n");
            }
        }
        return resul.toString();
    }

    /**
     * Ajoute une épreuve à la session.
     *
     * @param epreuve l'épreuve à ajouter
     */
    public void ajouterEpreuve(Epreuve epreuve) {
        if (this.dateDebutSession.before(epreuve.getDateEpreuve()) &&
                epreuve.getDateEpreuve().before(this.dateFinSession)) {
            this.sesEpreuves.add(epreuve);
            this.nbEpreuves++;
            epreuve.setSessionEpreuve(this);
        }
    }

    /**
     * Supprime une épreuve de la session.
     *
     * @param epreuve l'épreuve à supprimer
     */
    public void supprimerEpreuve(Epreuve epreuve) {
        this.sesEpreuves.remove(epreuve);
        this.nbEpreuves--;
        epreuve.setSessionEpreuve(null);
    }
}
