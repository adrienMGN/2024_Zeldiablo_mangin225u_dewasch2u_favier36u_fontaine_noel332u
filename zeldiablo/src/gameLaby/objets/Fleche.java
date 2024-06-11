package gameLaby.objets;

import gameLaby.entites.Entite;
import gameLaby.laby.Case;
import gameLaby.laby.Labyrinthe;

public class Fleche extends Case {

    private String direction;

    public Fleche(String direction, int x, int y, Labyrinthe laby){
        super(x, y, laby);
        this.direction = direction;
    }

    public boolean avancer(){
        try {
            Labyrinthe laby = this.getLaby();
            int x = this.getX();
            int y = this.getY();
            int[] suivant = Labyrinthe.getSuivant(x, y, this.direction);
            if (laby.estVideCase(suivant[0], suivant[1])) {
                this.setX(suivant[0]);
                this.setY(suivant[1]);
            } else {
                return false;
            }
            return true;
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    public Entite collision(){
        Labyrinthe laby = this.getLaby();
        int[] suivant = Labyrinthe.getSuivant(getX(), getY(), direction);

        for (Entite e : laby.entites) {
            if(e.etrePresent(suivant[0], suivant[1])&&e.etreVivant()){
                return e;
            }
        }
        return null;
    }
}
