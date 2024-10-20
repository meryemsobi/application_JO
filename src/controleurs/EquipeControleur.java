package controleurs;

import modeles.Athlete;
import modeles.Equipe;
import vues.AthleteVue;
import vues.EquipeVue;

import javax.swing.JOptionPane;

/**
 * Contrôleur pour la gestion des équipes.
 */
public class EquipeControleur {
    private EquipeVue equipeVue;
    private Equipe equipe;

    /**
     * Constructeur du contrôleur d'équipe.
     *
     * @param equipeVue la vue de l'équipe
     * @param equipe    l'objet Equipe
     */
    public EquipeControleur(EquipeVue equipeVue, Equipe equipe) {
        this.equipeVue = equipeVue;
        this.equipe = equipe;
    }

    /**
     * Méthode pour créer une nouvelle équipe.
     */
    public void creerEquipe() {
        String nomEquipe = equipeVue.saisirNomEquipe();
        if (nomEquipe != null && !nomEquipe.isEmpty()) {
            equipe.setNomEquipe(nomEquipe);
            JOptionPane.showMessageDialog(equipeVue, "L'équipe a été créée avec succès !");
        } else {
            JOptionPane.showMessageDialog(equipeVue, "Le nom de l'équipe est vide !");
        }
    }

    /**
     * Méthode pour ajouter un athlète à l'équipe.
     *
     * @param athlete l'athlète à ajouter
     */
    public void ajouterAthlete(Athlete athlete) {
        equipe.ajouterAthlete(athlete);
        JOptionPane.showMessageDialog(equipeVue, "Athlète ajouté à l'équipe !");
    }

    /**
     * Méthode pour supprimer un athlète de l'équipe.
     *
     * @param athlete l'athlète à supprimer
     */
    public void supprimerAthlete(Athlete athlete) {
        equipe.supprimerAthlete(athlete);
        JOptionPane.showMessageDialog(equipeVue, "Athlète supprimé de l'équipe !");
    }

    /**
     * Méthode pour ouvrir la vue de l'athlète.
     */
    public void ouvrirAthleteVue() {
        AthleteVue athleteVue = new AthleteVue();
        athleteVue.setVisible(true);
    }
}
