package gameLaby;
import moteurJeu.Clavier;
import moteurJeu.Jeu;
import moteurJeu.MoteurJeu;


public class LabyJeu implements Jeu {

    private final Labyrinthe laby;

    public static String DERNIER_MOUVEMENT = "";

    private double timer = 0;

    public LabyJeu (Labyrinthe labyrinthe) {
        laby = labyrinthe;
    }

    public void update(double secondes, Clavier clavier) {
        if (clavier.droite){
            laby.deplacerPerso(Labyrinthe.DROITE);
            DERNIER_MOUVEMENT = Labyrinthe.DROITE;
        }

        else if (clavier.gauche){
            laby.deplacerPerso(Labyrinthe.GAUCHE);
            DERNIER_MOUVEMENT = Labyrinthe.GAUCHE;
        }

        else if (clavier.haut){
            laby.deplacerPerso(Labyrinthe.HAUT);
            DERNIER_MOUVEMENT = Labyrinthe.HAUT;
        }

        else if (clavier.bas){
            laby.deplacerPerso(Labyrinthe.BAS);
            DERNIER_MOUVEMENT = Labyrinthe.BAS;
        }

        else if (clavier.i){
            //A COMPELTER
        }

        // Gestion des cases declenchables
        for (int i = 0; i < laby.declenchables.size(); i++) {
            Declenchable declenchable = laby.declenchables.get(i);
            declenchable.entitePresent(laby);
        }

        // update le mouvement des monstres toutes les 0.5 secondes
        timer+=secondes;
        if (timer >= 0.5){
            laby.mouvementsMonstres();
            timer = 0;

        }

        laby.gestionEntite();
        laby.majLaby();

        // Gestion attaque du personnage
        if (clavier.space){
            laby.attaqueDirectionnel(DERNIER_MOUVEMENT);
        }

        // Fin du jeu si le personnage est mort ou si le labyrinthe est fini
        if (laby.etreFini()){
            System.exit(0);
        }
    }

    public void init() {
    }

    public boolean etreFini(){
        return laby.etreFini();
    }

    public Labyrinthe getLaby() {
        return laby;
    }
}
