/*
 * @author Sanaâ (et Yijia)
 */

package vues;

import controleurs.*;
import modeles.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe pour la vue de gestion des équipes.
 */
public class EquipeVue extends JFrame {
    private ArrayList<Equipe> equipes;
    private JPanel equipePanel;
    private JTextField nomEquipeField;
    private JTextField nomPaysField;
    private JTextField continentPaysField;
    private JTextField nbMembresField;
    private JButton ouvrirAthleteVueButton;
    private JButton ajouterEquipeButton;
    private JButton ajouterAthleteButton;
    private JButton supprimerEquipeButton;
    private JButton retourButton;
    private JTable equipeTable;
    private DefaultTableModel tableModel;
    private EquipeControleur controleur;

    /**
     * Constructeur par défaut de la vue Equipe.
     */
    public EquipeVue() {
        equipes = new ArrayList<>();
        equipePanel = new JPanel();
        equipePanel.setLayout(new BoxLayout(equipePanel, BoxLayout.Y_AXIS));
        equipePanel.setBackground(new Color(60, 63, 65)); // Couleur de fond du panneau principal

        nomEquipeField = createStyledTextField(20);
        nomPaysField = createStyledTextField(20);
        continentPaysField = createStyledTextField(20);
        nbMembresField = createStyledTextField(5);

        ouvrirAthleteVueButton = createStyledButton("Gérer les Athlètes");
        ouvrirAthleteVueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AthleteVue athleteVue = new AthleteVue();
                new AthleteControleur(athleteVue, new Athlete("", "", new Date(), "", ""), controleur);
                athleteVue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                athleteVue.setVisible(true);
            }
        });

        ajouterEquipeButton = createStyledButton("Ajouter Équipe");
        ajouterEquipeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validerSaisie()) {
                    creerEquipe();
                }
            }
        });

        ajouterAthleteButton = createStyledButton("Ajouter Athlète");
        ajouterAthleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AthleteVue athleteVue = new AthleteVue();
                athleteVue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                athleteVue.setVisible(true);
            }
        });

        supprimerEquipeButton = createStyledButton("Supprimer Équipe");
        supprimerEquipeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supprimerEquipe();
            }
        });

        retourButton = createStyledButton("Retour");
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Créer le modèle de tableau avec les colonnes
        tableModel = new DefaultTableModel(new Object[]{"Nom de l'équipe", "Nom du pays", "Continent du pays", "Nombre de membres"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        equipeTable = new JTable(tableModel);
        equipeTable.setBackground(Color.BLACK); // Couleur de fond de la table
        equipeTable.setForeground(Color.WHITE); // Couleur du texte de la table
        equipeTable.setSelectionBackground(new Color(0, 122, 204)); // Couleur de sélection
        equipeTable.setSelectionForeground(Color.WHITE); // Couleur du texte de la sélection
        equipeTable.setGridColor(Color.WHITE); // Couleur de la grille

        graphique();
    }

    /**
     * Méthode pour créer une nouvelle équipe.
     */
    private void creerEquipe() {
        String nomEquipe = nomEquipeField.getText();
        String nomPays = nomPaysField.getText();
        String continentPays = continentPaysField.getText();
        int nbMembres = Integer.parseInt(nbMembresField.getText());

        Equipe equipe = new Equipe(nomEquipe, new Pays(nomPays, continentPays), nbMembres);
        equipes.add(equipe);

        tableModel.addRow(new Object[]{nomEquipe, nomPays, continentPays, nbMembres});
    }

    /**
     * Méthode pour supprimer une équipe sélectionnée.
     */
    private void supprimerEquipe() {
        int selectedRow = equipeTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
            equipes.remove(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une équipe à supprimer.");
        }
    }

    /**
     * Méthode pour valider la saisie des champs.
     */
    private boolean validerSaisie() {
        String nomEquipe = nomEquipeField.getText();
        String nomPays = nomPaysField.getText();
        String continentPays = continentPaysField.getText();
        String nbMembres = nbMembresField.getText();

        if (nomEquipe.isEmpty() || nomPays.isEmpty() || continentPays.isEmpty() || nbMembres.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tous les champs doivent être remplis.");
            return false;
        }

        try {
            int nombreMembres = Integer.parseInt(nbMembres);
            if (nombreMembres < 0) {
                JOptionPane.showMessageDialog(this, "Le nombre de membres doit être un nombre positif.");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Le nombre de membres doit être un entier.");
            return false;
        }

        return true;
    }

    /**
     * Méthode pour initialiser les composants graphiques.
     */
    private void graphique() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.setBackground(new Color(60, 63, 65)); // Couleur de fond du panneau des champs de texte

        inputPanel.add(createStyledLabel("Nom de l'équipe: "));
        inputPanel.add(nomEquipeField);
        inputPanel.add(createStyledLabel("Nom du pays: "));
        inputPanel.add(nomPaysField);
        inputPanel.add(createStyledLabel("Continent du pays: "));
        inputPanel.add(continentPaysField);
        inputPanel.add(createStyledLabel("Nombre de membres: "));
        inputPanel.add(nbMembresField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(new Color(60, 63, 65)); // Couleur de fond du panneau des boutons

        buttonPanel.add(ajouterEquipeButton);
        buttonPanel.add(supprimerEquipeButton);
        buttonPanel.add(ouvrirAthleteVueButton);
        buttonPanel.add(retourButton);

        setTitle("Gestion des équipes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(equipeTable), BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        	    // setVisible(true);
    }

    /**
     * Méthode pour définir le contrôleur de l'équipe.
     * 
     * @param controleur Le contrôleur de l'équipe.
     */
    public void setControleur(EquipeControleur controleur) {
        this.controleur = controleur;
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
     * Méthode pour créer un champ de texte stylisé.
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
     * Méthode pour créer un label stylisé.
     * 
     * @param text Le texte du label.
     * @return Le label créé.
     */
    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE); // Couleur du texte des labels
        return label;
    }

    /**
     * Méthode pour saisir le nom de l'équipe.
     * 
     * @return Le nom de l'équipe saisi.
     */
    public String saisirNomEquipe() {
        String nomEquipe = JOptionPane.showInputDialog(this, "Entrez le nom de l'équipe:", "Saisir Nom d'Équipe", JOptionPane.PLAIN_MESSAGE);
        if (nomEquipe != null && !nomEquipe.trim().isEmpty()) {
            return nomEquipe.trim();
        } else {
            JOptionPane.showMessageDialog(this, "Le nom de l'équipe ne peut pas être vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}