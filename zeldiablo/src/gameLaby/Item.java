package gameLaby;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Item {
    private int x;
    private int y;
    private Labyrinthe laby;

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
    public void ramasseItem(){
        Perso pj = laby.getPerso();
        if (pj.etrePresent(this.x,this.y)){
        pj.ajouterInventaire(this);}
    }

}
