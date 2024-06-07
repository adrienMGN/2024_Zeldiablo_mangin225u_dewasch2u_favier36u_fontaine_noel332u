package gameLaby;
import moteurJeu.Clavier;
import moteurJeu.Jeu;
import moteurJeu.MoteurJeu;


public class LabyJeu implements Jeu {

    private final Labyrinthe laby;

    private double timer = 0;

    public LabyJeu (Labyrinthe labyrinthe) {
        laby = labyrinthe;
    }

    public void update(double secondes, Clavier clavier) {
        if (clavier.droite){
            laby.deplacerPerso(Labyrinthe.DROITE);
        }

        else if (clavier.gauche){
            laby.deplacerPerso(Labyrinthe.GAUCHE);
        }

        else if (clavier.haut){
            laby.deplacerPerso(Labyrinthe.HAUT);
        }

        else if (clavier.bas){
            laby.deplacerPerso(Labyrinthe.BAS);
        }

        else if (clavier.)

        // Gestion des cases declenchables
        for (int i = 0; i < laby.declenchables.size(); i++) {
            Declenchable declenchable = laby.declenchables.get(i);
            declenchable.entitePresent(laby);
        }

        timer+=secondes;
        if (timer >= 0.5){
            laby.mouvementsMonstres();
            timer = 0;








        }
        laby.gestionEntite();
        laby.majLaby();

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
