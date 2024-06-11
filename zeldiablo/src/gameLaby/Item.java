package gameLaby;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Item extends Case{
    private boolean dansInventaire = false;

    public Item(int x, int y, Labyrinthe laby) {
        super(x, y, laby);
    }

    public int getY() {
        return super.getY();
    }
    public int getX() {
        return super.getX();
    }

    public void setX(int x) {
        super.setX(x);
    }
    public void setY(int y) {
        super.setY(y);
    }

    public boolean etrePresent(int dx, int dy) {
        return super.etrePresent(dx, dy);
    }

    public boolean persoPresent() {
        if (!this.dansInventaire) {
            Perso p = getLaby().getPerso();
            if (p.getX() == getX() && p.getY() == getY()){
                return true;
            }
        }
        return false;
    }

    public void ramasserItem(){
        getLaby().getPerso().ajouterInventaire(this);
        this.dansInventaire = true;
    }

    public boolean inInventaire(){
        return dansInventaire;
    }

}
