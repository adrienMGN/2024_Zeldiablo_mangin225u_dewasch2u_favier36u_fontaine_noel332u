package gameLaby.objets;

import gameLaby.laby.Labyrinthe;

public abstract class Arme extends Item{
    private int degats;

    public Arme(int x, int y, int degats, Labyrinthe laby) {
        super(x, y, laby);
        this.degats = degats;
    }


    public int getDegats() {
        return degats;
    }
}
