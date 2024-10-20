/*
 * @author Sanaâ (et Yijia)
 */

package vues;

import modeles.Athlete;
import controleurs.AthleteControleur;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

/**
 * La classe AthleteVue représente l'interface graphique pour la gestion des
 * athlètes.
 */
public class AthleteVue extends JFrame {
	private JPanel athletePanel;
	private JTextField nomAthleteField;
	private JTextField prenomAthleteField;
	private JTextField dateNaissanceAthleteField;
	private JTextField genreAthleteField;
	private JTextField descriptionAthleteField;
	private JButton ajouterAthleteButton;
	private JButton supprimerAthleteButton;
	private JButton modifierAthleteButton;
	private JButton retourButton;
	private JTable athleteTable;
	private DefaultTableModel modelTable;

	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	/**
	 * Constructeur de la classe AthleteVue.
	 */
	public AthleteVue() {
		athletePanel = new JPanel();
		athletePanel.setLayout(new BoxLayout(athletePanel, BoxLayout.Y_AXIS));
		athletePanel.setBackground(new Color(60, 63, 65));

		nomAthleteField = createStyledTextField(30);
		prenomAthleteField = createStyledTextField(30);
		dateNaissanceAthleteField = createStyledTextField(30);
		genreAthleteField = createStyledTextField(30);
		descriptionAthleteField = createStyledTextField(30);

		ajouterAthleteButton = createStyledButton("Ajouter Athlète");
		supprimerAthleteButton = createStyledButton("Supprimer Athlète");
		modifierAthleteButton = createStyledButton("Modifier Athlète");

		modelTable = new DefaultTableModel(
				new Object[] { "Nom", "Prénom", "Date de naissance", "Genre", "Description" }, 0);
		athleteTable = new JTable(modelTable);
		styleTable(athleteTable);

		retourButton = createStyledButton("Retour");
		retourButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		graphique();
	}

	private AthleteControleur controleur;

	/**
	 * Définit le contrôleur pour cette vue.
	 * 
	 * @param controleur Le contrôleur AthleteControleur
	 */
	public void setControleur(AthleteControleur controleur) {
		this.controleur = controleur;
	}

	private void graphique() {
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridBagLayout());
		inputPanel.setBackground(new Color(60, 63, 65));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);

		gbc.gridx = 0;
		gbc.gridy = 0;
		inputPanel.add(createStyledLabel("Nom de l'athlète: "), gbc);
		gbc.gridx = 1;
		inputPanel.add(nomAthleteField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		inputPanel.add(createStyledLabel("Prénom de l'athlète: "), gbc);
		gbc.gridx = 1;
		inputPanel.add(prenomAthleteField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		inputPanel.add(createStyledLabel("Date de naissance de l'athlète: (jj-mm-aaaa) "), gbc);
		gbc.gridx = 1;
		inputPanel.add(dateNaissanceAthleteField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		inputPanel.add(createStyledLabel("Genre de l'athlète: (F/M) "), gbc);
		gbc.gridx = 1;
		inputPanel.add(genreAthleteField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		inputPanel.add(createStyledLabel("Description de l'athlète: "), gbc);
		gbc.gridx = 1;
		inputPanel.add(descriptionAthleteField, gbc);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.setBackground(new Color(60, 63, 65));
		buttonPanel.add(ajouterAthleteButton);
		buttonPanel.add(supprimerAthleteButton);
		buttonPanel.add(modifierAthleteButton);
		buttonPanel.add(retourButton);

		setTitle("Gestion des athlètes");
		setSize(700, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(inputPanel, BorderLayout.NORTH);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		getContentPane().add(new JScrollPane(athleteTable), BorderLayout.CENTER);
	}

	/**
	 * Définit un ActionListener pour le bouton "Ajouter Athlète".
	 * 
	 * @param listener L'ActionListener à définir
	 */
	public void setAjouterAthleteListener(ActionListener listener) {
		ajouterAthleteButton.addActionListener(listener);
	}

	/**
	 * Définit un ActionListener pour le bouton "Supprimer Athlète".
	 * 
	 * @param listener L'ActionListener à définir
	 */
	public void setSupprimerAthleteListener(ActionListener listener) {
		supprimerAthleteButton.addActionListener(listener);
	}

	/**
	 * Définit un ActionListener pour le bouton "Modifier Athlète".
	 * 
	 * @param listener L'ActionListener à définir
	 */
	public void setModifierAthleteListener(ActionListener listener) {
		modifierAthleteButton.addActionListener(listener);
	}

	/**
	 * Obtient le nom de l'athlète à partir du champ de texte.
	 * 
	 * @return Le nom de l'athlète
	 */
	public String getNomAthlete() {
		return nomAthleteField.getText();
	}

	/**
	 * Obtient le prénom de l'athlète à partir du champ de texte.
	 * 
	 * @return Le prénom de l'athlète
	 */
	public String getPrenomAthlete() {
		return prenomAthleteField.getText();
	}

	/**
	 * Obtient la date de naissance de l'athlète à partir du champ de texte.
	 * 
	 * @return La date de naissance de l'athlète
	 */
	public Date getDateNaissanceAthlete() {
		try {
			return formatter.parse(dateNaissanceAthleteField.getText());
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this,
					"Le format de la date de naissance est incorrect. Utilisez le format jj-mm-aaaa.");
			return null;
		}
	}

	/**
	 * Obtient le genre de l'athlète à partir du champ de texte.
	 * 
	 * @return Le genre de l'athlète
	 */
	public String getGenreAthlete() {
		return genreAthleteField.getText();
	}

	/**
     * Obtient la description de l'athlète à partir du champ de texte.
     * @return La description de l'athlète
*/
	public String getDescriptionAthlete() {
		return descriptionAthleteField.getText();
	}
	/**
	 * Obtient l'index de l'athlète sélectionné dans le tableau.
	 * @return L'index de l'athlète sélectionné
	 */
	public int getSelectedAthleteIndex() {
	    return athleteTable.getSelectedRow();
	}

	/**
	 * Ajoute un athlète au tableau.
	 * @param athlete L'objet Athlete à ajouter
	 */
	public void addAthleteToTable(Athlete athlete) {
	    modelTable.addRow(new Object[]{athlete.getNomAthlete(), athlete.getPrenomAthlete(), formatter.format(athlete.getDateNaissanceAthlete()), athlete.getGenreAthlete(), athlete.getDescriptionAthlete()});
	}

	/**
	 * Supprime un athlète du tableau à l'index spécifié.
	 * @param index L'index de l'athlète à supprimer
	 */
	public void removeAthleteFromTable(int index) {
	    modelTable.removeRow(index);
	}

	/**
	 * Met à jour les informations de l'athlète dans le tableau à l'index spécifié.
	 * @param index L'index de l'athlète à mettre à jour
	 * @param athlete L'objet Athlete contenant les nouvelles informations
	 */
	public void updateAthleteInTable(int index, Athlete athlete) {
	    modelTable.setValueAt(athlete.getNomAthlete(), index, 0);
	    modelTable.setValueAt(athlete.getPrenomAthlete(), index, 1);
	    modelTable.setValueAt(formatter.format(athlete.getDateNaissanceAthlete()), index, 2);
	    modelTable.setValueAt(athlete.getGenreAthlete(), index, 3);
	    modelTable.setValueAt(athlete.getDescriptionAthlete(), index, 4);
	}

	private JButton createStyledButton(String text) {
	    JButton button = new JButton(text);
	    button.setFont(new Font("Arial", Font.BOLD, 14));
	    button.setBackground(new Color(0, 122, 204));
	    button.setForeground(Color.WHITE);
	    button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
	    button.setFocusPainted(false);
	    return button;
	}

	private JTextField createStyledTextField(int columns) {
	    JTextField textField = new JTextField(columns);
	    textField.setBackground(new Color(69, 73, 74));
	    textField.setForeground(Color.WHITE);
	    return textField;
	}

	private JLabel createStyledLabel(String text) {
	    JLabel label = new JLabel(text);
	    label.setForeground(Color.WHITE);
	    return label;
	}

	private void styleTable(JTable table) {
	    table.setBackground(new Color(43, 43, 43));
	    table.setForeground(Color.WHITE);
	    table.setSelectionBackground(new Color(0, 122, 204));
	    table.setSelectionForeground(Color.WHITE);
	    table.setGridColor(new Color(60, 63, 65));

	    JTableHeader tableHeader = table.getTableHeader();
	    tableHeader.setBackground(new Color(69, 73, 74));
	    tableHeader.setForeground(Color.WHITE);
	}
}
