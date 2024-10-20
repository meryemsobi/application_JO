package controleurs;

import modeles.Epreuve;
import modeles.Site;
import modeles.Sport;
import vues.EpreuveVue;

import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.sql.Date;

/**
 * La classe EpreuveControleur gère les interactions entre la vue (EpreuveVue) et les données 
 * des épreuves (Epreuve). Elle permet d'ajouter, de supprimer et de modifier des épreuves.
 * 
 * @version 1.0
 * @since 2024-06-08
 * 
 * @author Jakub (et Yijia)
 */
public class EpreuveControleur {
    private EpreuveVue epreuveVue;
    private ArrayList<Epreuve> epreuves;

    /**
     * Constructeur de la classe EpreuveControleur.
     * 
     * @param epreuveVue La vue associée aux épreuves.
     * @param epreuves La liste des épreuves.
     */
    public EpreuveControleur(EpreuveVue epreuveVue, ArrayList<Epreuve> epreuves) {
        this.epreuveVue = epreuveVue;
        this.epreuves = epreuves;
        this.initListeners();
    }

    /**
     * Initialise les écouteurs pour les actions de la vue.
     */
    private void initListeners() {
        epreuveVue.setAjouterEpreuveListener(e -> ajouterEpreuve());
        epreuveVue.setSupprimerEpreuveListener(e -> supprimerEpreuve());
        epreuveVue.setModifierEpreuveListener(e -> modifierEpreuve());
    }

    /**
     * Ajoute une nouvelle épreuve à la liste et met à jour la vue.
     */
    private void ajouterEpreuve() {
        String nom = epreuveVue.getNomEpreuve();
        String description = epreuveVue.getDescriptionEpreuve();
        Date date = Date.valueOf(epreuveVue.getDateEpreuve());
        LocalTime debut = LocalTime.parse(epreuveVue.getDebutEpreuve());
        LocalTime fin = LocalTime.parse(epreuveVue.getFinEpreuve());
        Site site = createSiteFromString(epreuveVue.getSiteEpreuve());
        Sport sport = createSportFromString(epreuveVue.getSportEpreuve());

        Epreuve epreuve = new Epreuve(nom, description, date, debut, fin, site, sport);
        epreuves.add(epreuve);
        epreuveVue.addEpreuveToTable(epreuve);
    }

    /**
     * Supprime l'épreuve sélectionnée de la liste et met à jour la vue.
     */
    private void supprimerEpreuve() {
        int selectedIndex = epreuveVue.getSelectedEpreuveIndex();
        if (selectedIndex != -1) {
            epreuveVue.removeEpreuveFromTable(selectedIndex);
            epreuves.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une épreuve à supprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Modifie l'épreuve sélectionnée avec les nouvelles informations fournies par la vue.
     */
    private void modifierEpreuve() {
        int selectedIndex = epreuveVue.getSelectedEpreuveIndex();
        if (selectedIndex != -1) {
            Epreuve epreuve = epreuves.get(selectedIndex);

            String nom = epreuveVue.getNomEpreuve();
            String description = epreuveVue.getDescriptionEpreuve();
            String dateStr = epreuveVue.getDateEpreuve();
            String debutStr = epreuveVue.getDebutEpreuve();
            String finStr = epreuveVue.getFinEpreuve();
            Site site = createSiteFromString(epreuveVue.getSiteEpreuve());
            Sport sport = createSportFromString(epreuveVue.getSportEpreuve());

            if (!nom.equals("")) {
                epreuve.setNomEpreuve(nom);
            }
            if (!description.equals("")) {
                epreuve.setDescriptionEpreuve(description);
            }
            if (!dateStr.equals("")) {
                try {
                    Date date = Date.valueOf(dateStr);
                    epreuve.setDateEpreuve(date);
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(epreuveVue, "Format de date invalide", "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (!debutStr.equals("")) {
                try {
                    LocalTime debut = LocalTime.parse(debutStr, DateTimeFormatter.ofPattern("HH:mm"));
                    epreuve.setDebutEpreuve(debut);
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(epreuveVue, "Format d'heure de début invalide", "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (!finStr.equals("")) {
                try {
                    LocalTime fin = LocalTime.parse(finStr, DateTimeFormatter.ofPattern("HH:mm"));
                    epreuve.setFinEpreuve(fin);
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(epreuveVue, "Format d'heure de fin invalide", "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (site != null) {
                epreuve.setSiteEpreuve(site);
            }
            if (sport != null) {
                epreuve.setSportEpreuve(sport);
            }

            epreuveVue.updateEpreuveInTable(selectedIndex, epreuve);
        } else {
            JOptionPane.showMessageDialog(epreuveVue, "Veuillez sélectionner une épreuve à modifier", "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Méthode temporaire pour ajouter une équipe. (Fonctionnalité à implémenter)
     */
    public void ajouterEquipe() {
        JOptionPane.showMessageDialog(epreuveVue, "Ajouter une équipe (fonctionnalité à implémenter)");
    }

    /**
     * Crée un objet Site à partir d'un nom de site.
     * 
     * @param siteName Le nom du site.
     * @return Un objet Site.
     */
    private Site createSiteFromString(String siteName) {
        return new Site(siteName); 
    }

    /**
     * Crée un objet Sport à partir d'un nom de sport.
     * 
     * @param sportName Le nom du sport.
     * @return Un objet Sport.
     */
    private Sport createSportFromString(String sportName) {
        return new Sport(sportName); 
    }
}
