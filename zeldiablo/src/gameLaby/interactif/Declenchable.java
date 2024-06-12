package gameLaby.interactif;

import gameLaby.laby.Case;
import gameLaby.entites.Entite;
import gameLaby.laby.Labyrinthe;

public abstract class Declenchable extends Case {
    private int id;

    public Declenchable(int id, int x, int y, Labyrinthe laby) {
        super(x, y, laby);
        this.id = id;
    }

    public abstract void action();

    public boolean persoPresent() {
        for (Entite e : getLaby().entites) {
            if (e.getX() == getX() && e.getY() == getY()){
                return true;
            }
        }
        return false;
    }


    public int getId() {
        return id;
    }
}
