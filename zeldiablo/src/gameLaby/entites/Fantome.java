package gameLaby.entites;

import gameLaby.laby.Labyrinthe;

/**
 * gere une entite de type fantome
 */
public class Fantome extends Monstre{
    /**
     * @param x
     * @param y
     * @param pv
     * @param laby
     */
    public Fantome(int x, int y, int pv, Labyrinthe laby) {
        super(x, y, pv, laby);
    }
}
