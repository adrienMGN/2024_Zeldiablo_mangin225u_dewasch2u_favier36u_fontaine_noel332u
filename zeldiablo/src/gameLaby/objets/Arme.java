package gameLaby.objets;

import gameLaby.laby.Labyrinthe;

/**
 * Classe abstraite Arme qui hérite de la classe Item
 */
public abstract class Arme extends Item{
    private int degats;

    /**
     * Constructeur pour les armes
     * @param x
     * @param y
     * @param degats
     */
    public Arme(int x, int y, int degats) {
        super(x, y);
        this.degats = degats;
    }


    /**
     * recupere le nombre de degats de l'arme
     * @return degats
     */
    public int getDegats() {
        return degats;
    }
}
