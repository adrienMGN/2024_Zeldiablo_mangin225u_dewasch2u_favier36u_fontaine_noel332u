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
