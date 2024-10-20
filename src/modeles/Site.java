package modeles;

/**
 * Représente un site où se déroulent des épreuves.
 */
public class Site {

    private String nomSite;

    /**
     * Constructeur de la classe Site.
     *
     * @param nomSite le nom du site
     */
    public Site(String nomSite) {
        this.nomSite = nomSite;
    }

    // Getters et setters

    public String getNomSite() {
        return nomSite;
    }

    public void setNomSite(String nomSite) {
        this.nomSite = nomSite;
    }

    // Méthode

    /**
     * Affiche les informations du site.
     */
    public void afficherInfoSite() {
        System.out.println("Nom du site: " + nomSite);
        // Implémentez ici l'affichage d'autres informations si nécessaire
    }
}
