/*
 * @author Sanaâ (et Yijia)
 */

package controleurs;

import modeles.Athlete;
import vues.AthleteVue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Contrôleur pour la gestion des athlètes.
 */
public class AthleteControleur {
    private AthleteVue athleteVue;
    private Athlete athlete;
    private EquipeControleur equipeControleur;

    /**
     * Constructeur de la classe AthleteControleur.
     * @param athleteVue la vue associée à l'athlète
     * @param athlete l'athlète
     * @param equipeControleur le contrôleur de l'équipe
     */
    public AthleteControleur(AthleteVue athleteVue, Athlete athlete, EquipeControleur equipeControleur) {
        this.athleteVue = athleteVue;
        this.athlete = athlete;
        this.equipeControleur = equipeControleur;
        this.initListeners();
    }

    /**
     * Initialise les écouteurs pour les actions de l'utilisateur.
     */
    private void initListeners() {
        athleteVue.setAjouterAthleteListener(new AjouterAthleteListener());
        athleteVue.setSupprimerAthleteListener(new SupprimerAthleteListener());
        athleteVue.setModifierAthleteListener(new ModifierAthleteListener());
    }

    /**
     * Classe interne pour gérer l'ajout d'un athlète.
     */
    private class AjouterAthleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String prenomAthlete = athleteVue.getPrenomAthlete();
            String nomAthlete = athleteVue.getNomAthlete();
            Date dateNaissance = athleteVue.getDateNaissanceAthlete();
            String genreAthlete = athleteVue.getGenreAthlete();
            String descriptionAthlete = athleteVue.getDescriptionAthlete();

            if (prenomAthlete.isEmpty() || nomAthlete.isEmpty() || dateNaissance == null || genreAthlete.isEmpty() || descriptionAthlete.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Les champs doivent tous être complétés.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Athlete newAthlete = new Athlete(nomAthlete, prenomAthlete, dateNaissance, genreAthlete, descriptionAthlete);
            athleteVue.addAthleteToTable(newAthlete);
        }
    }

    /**
     * Classe interne pour gérer la suppression d'un athlète.
     */
    private class SupprimerAthleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = athleteVue.getSelectedAthleteIndex();
            if (selectedIndex != -1) {
                athleteVue.removeAthleteFromTable(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner un athlète à supprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Classe interne pour gérer la modification d'un athlète.
     */
    private class ModifierAthleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = athleteVue.getSelectedAthleteIndex();
            String prenomAthlete = athleteVue.getPrenomAthlete();
            String nomAthlete = athleteVue.getNomAthlete();
            Date dateNaissance = athleteVue.getDateNaissanceAthlete();
            String genreAthlete = athleteVue.getGenreAthlete();
            String descriptionAthlete = athleteVue.getDescriptionAthlete();

            if (prenomAthlete.isEmpty() || nomAthlete.isEmpty() || dateNaissance == null || genreAthlete.isEmpty() || descriptionAthlete.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Les champs doivent tous être complétés.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (selectedIndex != -1) {
                Athlete updatedAthlete = new Athlete(nomAthlete, prenomAthlete, dateNaissance, genreAthlete, descriptionAthlete);
                athleteVue.updateAthleteInTable(selectedIndex, updatedAthlete);
            } else {
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner un athlète à modifier.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
