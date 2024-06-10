package gameLaby;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Item {
    private int x;
    private int y;
    private boolean dansInventaire = false;
    private Labyrinthe laby;

    public Item(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }

    public void persoPresent(Labyrinthe laby) {
        Perso p = laby.getPerso();
        if (p.getX() == x && p.getY() == y)
            ramasseItem(p);
    }

    public void ramasseItem(Perso pj){
        pj.ajouterInventaire(this);
        this.dansInventaire = true;
    }

    public boolean inInventaire(){
        return dansInventaire;
    }

}
