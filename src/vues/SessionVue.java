/*
 * @author Jakub (et Yijia)
 */

package vues;

import modeles.Session;
import controleurs.SessionControleur;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La classe SessionVue représente l'interface graphique permettant de gérer les sessions.
 */
public class SessionVue extends JFrame {
    private JPanel sessionPanel;
    private JTextField nomSessionField;
    private JTextField dateDebutSessionField;
    private JTextField dateFinSessionField;
    private JButton ajouterSessionButton;
    private JButton supprimerSessionButton;
    private JButton modifierSessionButton;
    private JButton retourButton;
    private JTable sessionTable;
    private DefaultTableModel modelTable;

    private SessionControleur controleur;

    /**
     * Méthode pour définir le contrôleur de la vue de session.
     * 
     * @param controleur Le contrôleur associé à la vue.
     */
    public void setControleur(SessionControleur controleur) {
        this.controleur = controleur;
    }

    /**
     * Constructeur de la classe SessionVue.
     * Initialise les composants graphiques de l'interface.
     */
    public SessionVue() {
        sessionPanel = new JPanel();
        sessionPanel.setLayout(new BoxLayout(sessionPanel, BoxLayout.Y_AXIS));
        sessionPanel.setBackground(new Color(60, 63, 65)); // Couleur de fond du panneau principal

        nomSessionField = createStyledTextField(30);
        dateDebutSessionField = createStyledTextField(30);
        dateFinSessionField = createStyledTextField(30);

        ajouterSessionButton = createStyledButton("Ajouter Session");
        supprimerSessionButton = createStyledButton("Supprimer Session");
        modifierSessionButton = createStyledButton("Modifier Session");

        modelTable = new DefaultTableModel(new Object[]{"Nom", "Date de début", "Date de fin"}, 0);
        sessionTable = new JTable(modelTable);
        sessionTable.setBackground(new Color(43, 43, 43)); // Couleur de fond de la table
        sessionTable.setForeground(Color.WHITE); // Couleur du texte de la table
        sessionTable.setSelectionBackground(new Color(0, 122, 204)); // Couleur de sélection
        sessionTable.setSelectionForeground(Color.WHITE); // Couleur du texte de la sélection

        retourButton = createStyledButton("Retour");
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        graphique();
    }

    /**
     * Méthode pour définir la structure graphique de l'interface.
     */
    private void graphique() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setBackground(new Color(60, 63, 65)); // Couleur de fond du panneau des champs de texte
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(createStyledLabel("Nom de la session: "), gbc);
        gbc.gridx = 1;
        inputPanel.add(nomSessionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(createStyledLabel("Date de début: (yyyy-mm-dd) "), gbc);
        gbc.gridx = 1;
        inputPanel.add(dateDebutSessionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(createStyledLabel("Date de fin: (yyyy-mm-dd) "), gbc);
        gbc.gridx = 1;
        inputPanel.add(dateFinSessionField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(60, 63, 65)); // Couleur de fond du panneau des boutons
        buttonPanel.add(ajouterSessionButton);
        buttonPanel.add(supprimerSessionButton);
        buttonPanel.add(modifierSessionButton);
        buttonPanel.add(retourButton);

        setTitle("Gestion des sessions");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        getContentPane().add(new JScrollPane(sessionTable), BorderLayout.CENTER);
    }

    /**
     * Méthode pour définir l'action à effectuer lors du clic sur le bouton "Ajouter Session".
     * 
     * @param listener L'écouteur d'événement.
     */
    public void setAjouterSessionListener(ActionListener listener) {
        ajouterSessionButton.addActionListener(listener);
    }

    /**
     * Méthode pour définir l'action à effectuer lors du clic sur le bouton "Supprimer Session".
     * 
     * @param listener L'écouteur d'événement.
     */
    public void setSupprimerSessionListener(ActionListener listener) {
        supprimerSessionButton.addActionListener(listener);
    }

    /**
     * Méthode pour définir l'action à effectuer lors du clic sur le bouton "Modifier Session".
     * 
     * @param listener L'écouteur d'événement.
     */
    public void setModifierSessionListener(ActionListener listener) {
        modifierSessionButton.addActionListener(listener);
    }

    /**
     * Méthode pour obtenir le nom de la session saisi dans le champ de texte.
     * 
     * @return Le nom de la session.
     */
    public String getNomSession() {
        return nomSessionField.getText();
    }

    /**
     * Méthode pour obtenir la date de début de la session saisi dans le champ de texte.
     * 
     * @return La date de début de la session.
     */
    public String getDateDebutSession() {
        return dateDebutSessionField.getText();
    }

    /**
     * Méthode pour obtenir la date de fin de la session saisi dans le champ de texte.
     * 
     * @return La date de fin de la session.
     */
    public String getDateFinSession() {
        return dateFinSessionField.getText();
    }

    /**
     * Méthode pour obtenir l'indice de la session sélectionnée dans la table.
     * 
     * @return L'indice de la session sélectionnée.
     */
    public int getSelectedSessionIndex() {
        return sessionTable.getSelectedRow();
    }

    /**
     * Méthode pour ajouter une session à la table.
     * 
     * @param session La session à ajouter.
     */
    public void addSessionToTable(Session session) {
        modelTable.addRow(new Object[]{session.getNomSession(), session.getDateDebutSession(), session.getDateFinSession()});
    }

    /**
     * Méthode pour supprimer une session de la table.
     * 
     * @param index L'indice de la session à supprimer.
     */
    public void removeSessionFromTable(int index) {
        modelTable.removeRow(index);
    }

    /**
     * Méthode pour mettre à jour une session dans la table.
	 *
	 */
    
    public void updateSessionInTable(int index, Session session) {
    modelTable.setValueAt(session.getNomSession(), index, 0);
    modelTable.setValueAt(session.getDateDebutSession(), index, 1);
    modelTable.setValueAt(session.getDateFinSession(), index, 2);
}

/**
 * Méthode pour créer et styliser un bouton avec le texte spécifié.
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
 * Méthode pour créer et styliser un champ de texte avec le nombre de colonnes spécifié.
 * 
 * @param columns Le nombre de colonnes du champ de texte.
 * @return Le champ de texte créé.
 */
private JTextField createStyledTextField(int columns) {
    JTextField textField = new JTextField(columns);
    textField.setBackground(new Color(69, 73, 74)); // Couleur de fond des champs de texte
    textField.setForeground(Color.WHITE); // Couleur du texte des champs de texte
    return textField;
}

/**
 * Méthode pour créer et styliser un label avec le texte spécifié.
 * 
 * @param text Le texte du label.
 * @return Le label créé.
 */
private JLabel createStyledLabel(String text) {
    JLabel label = new JLabel(text);
    label.setForeground(Color.WHITE); // Couleur du texte des labels
    return label;
}
}
