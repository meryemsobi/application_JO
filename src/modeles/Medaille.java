package modeles;

/**
 * Classe représentant une médaille.
 */
public class Medaille {

    private Athlete sonAthlete;
    private Pays sonPays;
    private String typeMedaille;

    /**
     * Constructeur de la classe Medaille.
     *
     * @param typeMedaille le type de médaille (Or, Argent, Bronze)
     */
    public Medaille(String typeMedaille) {
        this.typeMedaille = typeMedaille;
    }

    /**
     * Calcule le total de médailles.
     *
     * @return le total de médailles
     */
    public int calculerTotalMedailles() {
        // À implémenter
        throw new UnsupportedOperationException();
    }

    /**
     * Affiche les athlètes par médailles.
     */
    public void afficherAthletesParMedailles() {
        // À implémenter
        throw new UnsupportedOperationException();
    }

    /**
     * Affiche les détails de la médaille.
     */
    public void afficherDetailsMedaille() {
        // À implémenter
        throw new UnsupportedOperationException();
    }
}
