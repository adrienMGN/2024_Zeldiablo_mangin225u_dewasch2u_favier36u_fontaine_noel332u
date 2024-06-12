package gameLaby.objets;

import gameLaby.laby.Labyrinthe;

/**
 * Classe Amulette qui hérite de la classe Item
 */
public class Amulette extends Item {

    /**
     * @param dx
     * @param dy
     * @param laby
     */
    public Amulette(int dx, int dy, Labyrinthe laby){
        super(dx, dy, laby);
    }

}
