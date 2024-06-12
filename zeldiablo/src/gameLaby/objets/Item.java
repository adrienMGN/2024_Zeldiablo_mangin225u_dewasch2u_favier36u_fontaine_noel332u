package gameLaby.objets;

import gameLaby.Main;
import gameLaby.laby.Case;
import gameLaby.laby.Labyrinthe;
import gameLaby.entites.Perso;

/**
 * Classe abstraite Item qui hérite de la classe Case
 */
public abstract class Item extends Case {

    /**
     * Constructeur pour les items etant fixes dans un labyrinthe
     * @param x
     * @param y
     * @param laby
     */
    public Item(int x, int y, Labyrinthe laby) {
        super(x, y, laby);
    }

    /**
     * Constructeur pour les items changant de labyrinthe
     * @param x
     * @param y
     */
    public Item(int x, int y){
        super(x, y);
    }

    /**
     * @return true si le personnage est sur la case de l'item
     */
    public boolean persoPresent() {
        Perso p = Main.getLaby().getPerso();
        if(getLaby()!=null) {
            p = getLaby().getPerso();
        }
        if (p.getX() == getX() && p.getY() == getY()){return true;}

        return false;
    }

    /**
     * Methode pour ramasser un item
     */
    public void ramasserItem(){
        Labyrinthe laby;
        if(getLaby()!=null) {
            laby = getLaby();
        }
        else{
            laby = Main.getLaby();
        }
        // ajout de l'item dans l'inventaire
        laby.getPerso().ajouterInventaire(this);
        laby.items.remove(this);
    }

}
