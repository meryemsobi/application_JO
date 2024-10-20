package modeles;

/**
 * Représente un sport pratiqué lors des épreuves.
 */
public class Sport {

    private String nomSport;

    /**
     * Constructeur de la classe Sport.
     *
     * @param nomSport le nom du sport
     */
    public Sport(String nomSport) {
        this.nomSport = nomSport;
    }

    // Getters et setters

    public String getNomSport() {
        return nomSport;
    }

    public void setNomSport(String nomSport) {
        this.nomSport = nomSport;
    }

    // Méthodes

    /**
     * Affiche les informations sur le sport.
     */
    public void afficherInfoSport() {
        System.out.println("Nom du sport: " + nomSport);
        // Implémentez ici l'affichage d'autres informations si nécessaire
    }

    /**
     * Affiche les résultats pour ce sport.
     */
    public void afficherResultatParSport() {
        // Implémentez la logique pour afficher les résultats par sport
    }

    /**
     * Affiche les athlètes pratiquant ce sport.
     */
    public void afficherAthletesParSport() {
        // Implémentez la logique pour afficher les athlètes par sport
    }
}
