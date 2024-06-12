package gameLaby.objets;

import gameLaby.laby.Labyrinthe;

/**
 * Classe Cle qui hérite de la classe Item
 */
public class Cle extends Item {

    /**
     * @param dx
     * @param dy
     * @param laby
     */
    public Cle(int dx, int dy, Labyrinthe laby){
        super(dx, dy, laby);
    }

}
