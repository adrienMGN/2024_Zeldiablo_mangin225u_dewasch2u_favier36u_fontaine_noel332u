package gameLaby.objets;

import gameLaby.laby.Labyrinthe;

/**
 * Classe abstraite Arme qui hérite de la classe Item
 */
public abstract class Arme extends Item{
    private int degats;

    /**
     * @param x
     * @param y
     * @param degats
     */
    public Arme(int x, int y, int degats) {
        super(x, y);
        this.degats = degats;
    }


    /**
     * @return degats
     */
    public int getDegats() {
        return degats;
    }
}
