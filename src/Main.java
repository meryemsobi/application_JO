import controleurs.*;
import modeles.*;
import vues.*;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe principale de l'application.
 */
public class Main {

    /**
     * Méthode principale de l'application.
     * @param args les arguments de la ligne de commande (non utilisés ici)
     */
    public static void main(String[] args) {
        // Données initiales
        ArrayList<Athlete> athletes = new ArrayList<>();
        Pays pays = new Pays("Nom du pays", "Continent du pays");
        Equipe equipe = new Equipe(pays, athletes, "Nom de l'équipe", 0);
        ArrayList<Epreuve> epreuves = new ArrayList<>();
        ArrayList<Session> sessions = new ArrayList<>();

        // Création et configuration des vues
        AthleteVue athleteVue = new AthleteVue();
        EquipeVue equipeVue = new EquipeVue();
        EpreuveVue epreuveVue = new EpreuveVue();
        SessionVue sessionVue = new SessionVue();
        PlanningVue planningVue = new PlanningVue();

        Athlete athlete = new Athlete("Nom de l'athlète", "Prénom de l'athlète", new Date(), "Genre de l'athlète", "Description de l'athlète");

        // Création et configuration des contrôleurs
        EquipeControleur equipeControleur = new EquipeControleur(equipeVue, equipe);
        AthleteControleur athleteControleur = new AthleteControleur(athleteVue, athlete, equipeControleur);
        EpreuveControleur epreuveControleur = new EpreuveControleur(epreuveVue, epreuves);
        SessionControleur sessionControleur = new SessionControleur(sessionVue, sessions);
        PlanningControleur planningControleur = new PlanningControleur(planningVue, sessions, epreuves);

        equipeVue.setControleur(equipeControleur);
        athleteVue.setControleur(athleteControleur);
        epreuveVue.setControleur(epreuveControleur);
        sessionVue.setControleur(sessionControleur);
        planningVue.setControleur(planningControleur);

        // Création de la fenêtre principale
        JFrame frame = new JFrame("Menu principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(60, 63, 65)); // Couleur de fond

        // Création des boutons
        JButton equipesButton = new JButton("Gérer les équipes");
        JButton athletesButton = new JButton("Gérer les athlètes");
        JButton epreuvesButton = new JButton("Gérer les épreuves");
        JButton sessionsButton = new JButton("Gérer les sessions");
        JButton planningButton = new JButton("Afficher le planning des épreuves");

        // Style des boutons
        JButton[] buttons = { equipesButton, athletesButton, epreuvesButton, sessionsButton, planningButton };
        for (JButton button : buttons) {
            button.setFont(new Font("Arial", Font.BOLD, 14));
            button.setBackground(new Color(0, 122, 204));
            button.setForeground(Color.WHITE);
            button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            button.setFocusPainted(false);
        }

        // Ajout des actions aux boutons
        equipesButton.addActionListener(e -> equipeVue.setVisible(true));
        athletesButton.addActionListener(e -> athleteVue.setVisible(true));
        epreuvesButton.addActionListener(e -> epreuveVue.setVisible(true));
        sessionsButton.addActionListener(e -> sessionVue.setVisible(true));
        planningButton.addActionListener(e -> planningVue.setVisible(true));

        // Création du panel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(60, 63, 65));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Ajout des boutons au panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(equipesButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(athletesButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(epreuvesButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(sessionsButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.PAGE_END;
        panel.add(planningButton, gbc);

        // Ajout du panel à la fenêtre
        frame.getContentPane().add(panel);

        // Affichage de la fenêtre
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
