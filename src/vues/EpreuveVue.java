package vues;

import modeles.Epreuve;
import controleurs.EpreuveControleur;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalTime;

/**
 * La classe EpreuveVue représente l'interface graphique pour la gestion des épreuves.
 * Elle permet à l'utilisateur d'ajouter, de supprimer et de modifier des épreuves.
 * 
 * @version 1.0
 * @since 2024-06-08
 * 
 * Auteur: Jakub (et Yijia)
 */
public class EpreuveVue extends JFrame {
    private JPanel epreuvePanel;
    private JTextField nomEpreuveField;
    private JTextArea descriptionEpreuveField;
    private JTextField dateEpreuveField;
    private JTextField debutEpreuveField;
    private JTextField finEpreuveField;
    private JTextField siteEpreuveField;
    private JTextField sportEpreuveField;
    private JButton ajouterEpreuveButton;
    private JButton supprimerEpreuveButton;
    private JButton modifierEpreuveButton;
    private JTable epreuveTable;
    private DefaultTableModel modelTable;

    private EpreuveControleur controleur;

    /**
     * Définit le contrôleur pour cette vue.
     * 
     * @param controleur Le contrôleur des épreuves.
     */
    public void setControleur(EpreuveControleur controleur) {
        this.controleur = controleur;
    }

    /**
     * Crée un label stylisé avec le texte spécifié.
     * 
     * @param text Le texte du label.
     * @return Le label stylisé.
     */
    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE); // Couleur du texte des labels
        return label;
    }

    /**
     * Constructeur de la classe EpreuveVue.
     */
    public EpreuveVue() {
        epreuvePanel = new JPanel();
        epreuvePanel.setLayout(new BoxLayout(epreuvePanel, BoxLayout.Y_AXIS));

        nomEpreuveField = new JTextField(30);
        descriptionEpreuveField = new JTextArea(5, 30);
        dateEpreuveField = new JTextField(30);
        debutEpreuveField = new JTextField(30);
        finEpreuveField = new JTextField(30);
        siteEpreuveField = new JTextField(30);
        sportEpreuveField = new JTextField(30);

        ajouterEpreuveButton = new JButton("Ajouter Epreuve");
        supprimerEpreuveButton = new JButton("Supprimer Epreuve");
        modifierEpreuveButton = new JButton("Modifier Epreuve");

        modelTable = new DefaultTableModel(new Object[]{"Nom", "Description", "Date", "Début", "Fin", "Site", "Sport"}, 0);
        epreuveTable = new JTable(modelTable);

        graphique();
    }

    /**
     * Initialise et configure l'interface graphique.
     */
    private void graphique() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        inputPanel.setBackground(new Color(60, 63, 65)); // Couleur de fond du panneau des champs de texte

        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(createStyledLabel("Nom de l'épreuve: "), gbc);
        gbc.gridx = 1;
        inputPanel.add(nomEpreuveField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(createStyledLabel("Description de l'épreuve: "), gbc);
        gbc.gridx = 1;
        inputPanel.add(new JScrollPane(descriptionEpreuveField), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(createStyledLabel("Date de l'épreuve: (yyyy-mm-dd) "), gbc);
        gbc.gridx = 1;
        inputPanel.add(dateEpreuveField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(createStyledLabel("Début de l'épreuve: (HH:mm) "), gbc);
        gbc.gridx = 1;
        inputPanel.add(debutEpreuveField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(createStyledLabel("Fin de l'épreuve: (HH:mm) "), gbc);
        gbc.gridx = 1;
        inputPanel.add(finEpreuveField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        inputPanel.add(createStyledLabel("Site de l'épreuve: "), gbc);
        gbc.gridx = 1;
        inputPanel.add(siteEpreuveField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        inputPanel.add(createStyledLabel("Sport de l'épreuve: "), gbc);
        gbc.gridx = 1;
        inputPanel.add(sportEpreuveField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(ajouterEpreuveButton);
        buttonPanel.add(supprimerEpreuveButton);
        buttonPanel.add(modifierEpreuveButton);

        setTitle("Gestion des épreuves");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        getContentPane().add(new JScrollPane(epreuveTable), BorderLayout.CENTER);
    }

    /**
     * Ajoute un écouteur pour le bouton "Ajouter Epreuve".
     * 
     * @param listener L'écouteur à ajouter.
     */
    public void setAjouterEpreuveListener(ActionListener listener) {
        ajouterEpreuveButton.addActionListener(listener);
    }

    /**
     * Ajoute un écouteur pour le bouton "Supprimer Epreuve".
     * 
     * @param listener L'écouteur à ajouter.
     */
    public void setSupprimerEpreuveListener(ActionListener listener) {
        supprimerEpreuveButton.addActionListener(listener);
    }

    /**
     * Ajoute un écouteur pour le bouton "Modifier Epreuve".
     * 
     * @param listener L'écouteur à ajouter.
     */
    public void setModifierEpreuveListener(ActionListener listener) {
        modifierEpreuveButton.addActionListener(listener);
    }

    /**
     * Obtient le nom de l'épreuve saisi par l'utilisateur.
     * 
     * @return Le nom de l'épreuve.
     */
    public String getNomEpreuve() {
        return nomEpreuveField.getText();
    }

    /**
     * Obtient la description de l'épreuve saisie par l'utilisateur.
     * 
     * @return La description de l'épreuve.
     */
    public String getDescriptionEpreuve() {
        return descriptionEpreuveField.getText();
    }

    /**
     * Obtient la date de l'épreuve saisie par l'utilisateur.
     * 
     * @return La date de l'épreuve.
     */
    public String getDateEpreuve() {
        return dateEpreuveField.getText();
    }

    /**
     * Obtient l'heure de début de l'épreuve saisie par l'utilisateur.
     * 
     * @return L'heure de début de l'épreuve.
     */
    public String getDebutEpreuve() {
        return debutEpreuveField.getText();
    }

    /**
     * Obtient l'heure de fin de l'épreuve saisie par l'utilisateur.
     * 
     * @return L'heure de fin de l'épreuve.
     */
    public String getFinEpreuve() {
        return finEpreuveField.getText();
    }

    /**
     * Obtient le site de l'épreuve saisi par l'utilisateur.
     * 
     * @return Le site de l'épreuve.
     */
    public String getSiteEpreuve() {
        return siteEpreuveField.getText();
    }

    /**
     * Obtient le sport de l'épreuve saisi par l'utilisateur.
     * 
     * @return Le sport de l'épreuve.
     */
    public String getSportEpreuve() {
        return sportEpreuveField.getText();
    }

    /**
     * Obtient l'index de l'épreuve sélectionnée dans le tableau.
     * 
     * @return L'index de l'épreuve sélectionnée.
     */
    public int getSelectedEpreuveIndex() {
        return epreuveTable.getSelectedRow();
    }

    /**
     * Ajoute une épreuve au tableau des épreuves.
     * 
     * @param epreuve L'épreuve à ajouter.
     */
    public void addEpreuveToTable(Epreuve epreuve) {
        modelTable.addRow(new Object[]{epreuve.getNomEpreuve(), epreuve.getDescriptionEpreuve(), epreuve.getDateEpreuve(), epreuve.getDebutEpreuve(), epreuve.getFinEpreuve(), epreuve.getSiteEpreuve(), epreuve.getSportEpreuve()});
    }

    /**
     * Supprime une épreuve du tableau des épreuves.
     * 
     * @param index L'index de l'épreuve à supprimer.
     */
    public void removeEpreuveFromTable(int index) {
        modelTable.removeRow(index);
    }

    /**
     * Met à jour une épreuve dans le tableau des épreuves.
     * 
     * @param index L'index de l'épreuve à mettre à jour.
     * @param epreuve L'épreuve mise à jour.
     */
    public void updateEpreuveInTable(int index, Epreuve epreuve) {
        modelTable.setValueAt(epreuve.getNomEpreuve(), index, 0);
        modelTable.setValueAt(epreuve.getDescriptionEpreuve(), index, 1);
        modelTable.setValueAt(epreuve.getDateEpreuve(), index, 2);
        modelTable.setValueAt(epreuve.getDebutEpreuve(), index, 3);
        modelTable.setValueAt(epreuve.getFinEpreuve(), index, 4);
        modelTable.setValueAt(epreuve.getSiteEpreuve(), index, 5);
        modelTable.setValueAt(epreuve.getSportEpreuve(), index, 6);
    }
}
