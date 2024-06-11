package gameLaby.objets;

import gameLaby.Main;
import gameLaby.laby.Case;
import gameLaby.laby.Labyrinthe;
import gameLaby.entites.Perso;

public abstract class Item extends Case {
    private boolean dansInventaire = false;

    public Item(int x, int y, Labyrinthe laby) {
        super(x, y, laby);
    }

    public Item(int x, int y){
        super(x, y);
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
        Perso p = Main.getLaby().getPerso();
        if(getLaby()!=null) {
            p = getLaby().getPerso();
        }
        if (p.getX() == getX() && p.getY() == getY()){return true;}

        return false;
    }

    public void ramasserItem(){
        Labyrinthe laby = Main.getLaby();
        if(getLaby()!=null) {
            laby = getLaby();
        }
        laby.getPerso().ajouterInventaire(this);
        this.dansInventaire = true;
        laby.items.remove(this);
    }

    public boolean inInventaire(){
        return dansInventaire;
    }

}
