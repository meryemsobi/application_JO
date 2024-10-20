/*
 * @author Meryem (et Yijia)
 */

package controleurs;

import modeles.Epreuve;
import modeles.Session;
import vues.PlanningVue;

import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 * Contrôleur pour la gestion du planning.
 */
public class PlanningControleur {
    private PlanningVue planningVue;
    private ArrayList<Session> sessions;
    private ArrayList<Epreuve> epreuves;

    /**
     * Constructeur du contrôleur de planning.
     *
     * @param planningVue la vue du planning
     * @param sessions    la liste des sessions
     * @param epreuves    la liste des épreuves
     */
    public PlanningControleur(PlanningVue planningVue, ArrayList<Session> sessions, ArrayList<Epreuve> epreuves) {
        this.planningVue = planningVue;
        this.sessions = sessions;
        this.epreuves = epreuves; // Initialisation des épreuves
        this.initListeners();
    }

    /**
     * Initialise les écouteurs d'événements.
     */
    private void initListeners() {
        planningVue.setAfficherPlanningListener(e -> afficherPlanning());
    }

    /**
     * Affiche le planning des épreuves et des sessions à venir.
     */
    private void afficherPlanning() {
        StringBuilder planning = new StringBuilder();
        planning.append("Sessions prévues:\n");
        for (Session session : sessions) {
            planning.append(session.afficherPlanige()).append("\n"); // Afficher le planning de la session
        }
        planning.append("\nÉpreuves prévues:\n");
        for (Epreuve epreuve : epreuves) {
            planning.append(epreuve.getNomEpreuve()).append(" - ")
                    .append(epreuve.getDateEpreuve()).append(" à ")
                    .append(epreuve.getSiteEpreuve().getNomSite()).append("\n"); // En supposant que Epreuve a ces méthodes
        }
        JOptionPane.showMessageDialog(null, planning.toString(), "Planning des épreuves et sessions à venir", JOptionPane.INFORMATION_MESSAGE);
    }
}
