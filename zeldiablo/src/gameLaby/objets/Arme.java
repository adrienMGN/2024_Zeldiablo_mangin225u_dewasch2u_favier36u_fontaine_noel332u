package gameLaby.objets;

import gameLaby.laby.Labyrinthe;

public abstract class Arme extends Item{
    private int degats;

    public Arme(int x, int y, int degats) {
        super(x, y);
        this.degats = degats;
    }


    public int getDegats() {
        return degats;
    }
}
