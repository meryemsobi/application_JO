package modeles;

/**
 * Classe représentant le résultat d'un athlète dans une session.
 */
public class Resultat {

    private Athlete sonAthlete;
    private Session saSession;
    private int resultat;
    private int classement;

    /**
     * Constructeur de la classe Resultat.
     *
     * @param resultat   le résultat de l'athlète
     * @param classement le classement de l'athlète
     */
    public Resultat(int resultat, int classement) {
        this.resultat = resultat;
        this.classement = classement;
    }

    /**
     * Affiche les informations sur le résultat.
     */
    public void afficherInfoResultat() {
        System.out.println("Résultat de l'athlète " + sonAthlete.getPrenomAthlete() + " " + sonAthlete.getNomAthlete() +
                " dans la session " + saSession.getNomSession() + ":");
        System.out.println("Résultat: " + resultat);
        System.out.println("Classement: " + classement);
    }
}
