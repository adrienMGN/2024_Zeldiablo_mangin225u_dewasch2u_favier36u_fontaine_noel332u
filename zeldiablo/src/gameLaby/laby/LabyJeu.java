package gameLaby.laby;
import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;

public class LabyJeu implements Jeu {

    private final Labyrinthe laby;

    public LabyJeu () throws IOException {
        laby = new Labyrinthe("laby1.txt");
    }

    public void update(double secondes, Clavier clavier){
        if (clavier.droite){
            laby.deplacerPerso(Labyrinthe.DROITE);
        }

        if (clavier.gauche){
            laby.deplacerPerso(Labyrinthe.GAUCHE);
        }

        if (clavier.haut){
            laby.deplacerPerso(Labyrinthe.HAUT);
        }

        if (clavier.bas){
            laby.deplacerPerso(Labyrinthe.BAS);
        }
    }

    public void init() {
    }

    public boolean etreFini(){
        return laby.etreFini();
    }

    public Perso getPerso() {
        return perso;
    }
}
