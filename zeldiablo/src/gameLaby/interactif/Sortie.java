package gameLaby.interactif;

import gameLaby.laby.Case;
import gameLaby.entites.Perso;
import gameLaby.laby.Labyrinthe;

/**
 * Classe Sortie : Case de sortie du labyrinthe
 */
public class Sortie extends Case {

    /**
     * Constructeur de la classe Sortie
     * @param x
     * @param y
     * @param laby
     */
    public Sortie(int x, int y, Labyrinthe laby) {
        super(x, y, laby);
    }

    /**
     * retourne si le personnage est sur la case de sortie ou non
     * @return true si le personnage est sur la case de sortie
     */
    public boolean persoPresent() {
        Perso p = getLaby().getPerso();
        return (p.getX() == getX() && p.getY() == getY());
    }

    /**
     * retourne si le personnage peut sortir
     * @return true si le personnage est sur la case de sortie et possède l'amulette
     */
    public boolean sortiePossible(){
        Perso p = getLaby().getPerso();
        return (persoPresent() && p.possedeAmulette());
    }

}
