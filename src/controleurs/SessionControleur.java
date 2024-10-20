/*
 * @author Jakub (et Yijia)
 */

package controleurs;

import modeles.Session;
import vues.SessionVue;

import javax.swing.*;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Contrôleur pour la gestion des sessions.
 */
public class SessionControleur {
    private SessionVue sessionVue;
    private ArrayList<Session> sessions;

    /**
     * Constructeur du contrôleur de session.
     *
     * @param sessionVue la vue de la session
     * @param sessions   la liste des sessions
     */
    public SessionControleur(SessionVue sessionVue, ArrayList<Session> sessions) {
        this.sessionVue = sessionVue;
        this.sessions = sessions;
        this.initListeners();
    }

    /**
     * Initialise les écouteurs d'événements.
     */
    private void initListeners() {
        sessionVue.setAjouterSessionListener(e -> ajouterSession());
        sessionVue.setSupprimerSessionListener(e -> supprimerSession());
        sessionVue.setModifierSessionListener(e -> modifierSession());
    }

    /**
     * Ajoute une nouvelle session.
     */
    private void ajouterSession() {
        String nom = sessionVue.getNomSession();
        Date debut = Date.valueOf(sessionVue.getDateDebutSession());
        Date fin = Date.valueOf(sessionVue.getDateFinSession());

        Session session = new Session(nom, debut, fin);
        sessions.add(session);
        sessionVue.addSessionToTable(session);
    }

    /**
     * Supprime une session.
     */
    private void supprimerSession() {
        int selectedIndex = sessionVue.getSelectedSessionIndex();
        if (selectedIndex != -1) {
            sessionVue.removeSessionFromTable(selectedIndex);
            sessions.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une session à supprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Modifie une session existante.
     */
    private void modifierSession() {
        int selectedIndex = sessionVue.getSelectedSessionIndex();
        if (selectedIndex != -1) {
            String nom = sessionVue.getNomSession();
            Date debut = Date.valueOf(sessionVue.getDateDebutSession());
            Date fin = Date.valueOf(sessionVue.getDateFinSession());

            Session session = sessions.get(selectedIndex);
            session.setNomSession(nom);
            session.setDateDebutSession(debut);
            session.setDateFinSession(fin);

            sessionVue.updateSessionInTable(selectedIndex, session);
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une session à modifier.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
