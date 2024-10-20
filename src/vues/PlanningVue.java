/**
 * La classe PlanningVue représente l'interface graphique permettant d'afficher le planning des épreuves.
 * @author Meryem (et Yijia)
 */
package vues;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controleurs.PlanningControleur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modeles.Session;

public class PlanningVue extends JFrame {
    private JPanel planningPanel;
    private JTable planningTable;
    private DefaultTableModel modelTable;
    private JButton afficherPlanningButton;
    private JButton retourButton;
    private PlanningControleur controleur;

    /**
     * Constructeur de la classe PlanningVue.
     * Initialise les composants graphiques de l'interface.
     */
    public PlanningVue() {
        planningPanel = new JPanel();
        planningPanel.setLayout(new BoxLayout(planningPanel, BoxLayout.Y_AXIS));
        planningPanel.setBackground(new Color(60, 63, 65)); // Couleur de fond du panneau principal

        afficherPlanningButton = createStyledButton("Afficher Planning");
        retourButton = createStyledButton("Retour");

        // Création de l'action du bouton retour
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermeture de la fenêtre actuelle
                dispose();
            }
        });

        modelTable = new DefaultTableModel(new Object[]{"Session", "Date de début", "Date de fin", "Epreuves"}, 0);
        planningTable = new JTable(modelTable);
        planningTable.setBackground(new Color(43, 43, 43)); // Couleur de fond de la table
        planningTable.setForeground(Color.WHITE); // Couleur du texte de la table
        planningTable.setSelectionBackground(new Color(0, 122, 204)); // Couleur de sélection
        planningTable.setSelectionForeground(Color.WHITE); // Couleur du texte de la sélection

        graphique();
    }

    /**
     * Méthode pour définir la structure graphique de l'interface.
     */
    private void graphique() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(60, 63, 65)); // Couleur de fond du panneau des boutons
        buttonPanel.add(afficherPlanningButton);
        buttonPanel.add(retourButton);

        setTitle("Planning des épreuves");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        getContentPane().add(new JScrollPane(planningTable), BorderLayout.CENTER);
    }

    /**
     * Méthode pour créer un bouton stylisé.
     * 
     * @param text Le texte du bouton.
     * @return Le bouton créé.
     */
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(0, 122, 204)); // Couleur de fond des boutons
        button.setForeground(Color.WHITE); // Couleur du texte des boutons
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Bordure sans contour
        button.setFocusPainted(false); // Désactiver le focus paint
        return button;
    }

    /**
     * Méthode pour définir l'action à effectuer lors du clic sur le bouton "Afficher Planning".
     * 
     * @param listener L'écouteur d'événement.
     */
    public void setAfficherPlanningListener(ActionListener listener) {
        afficherPlanningButton.addActionListener(listener);
    }

    /**
     * Méthode pour mettre à jour le tableau du planning des épreuves avec les données fournies.
     * 
     * @param sessions La liste des sessions à afficher dans le planning.
     */
    public void updatePlanningTable(ArrayList<Session> sessions) {
        modelTable.setRowCount(0); // Clear existing data
        for (Session session : sessions) {
            String epreuves = String.join(", ", session.getSesEpreuves().stream().map(e -> e.getNomEpreuve()).toArray(String[]::new));
            modelTable.addRow(new Object[]{session.getNomSession(), session.getDateDebutSession(), session.getDateFinSession(), epreuves});
        }
    }

    /**
     * Méthode pour définir le contrôleur de la vue du planning.
     * 
     * @param planningControleur Le contrôleur associé à la vue.
     */
    public void setControleur(PlanningControleur planningControleur) {
        this.controleur = planningControleur;
    }
}
