package gameLaby.objets;

import gameLaby.entites.Entite;
import gameLaby.entites.Perso;
import gameLaby.laby.Case;
import gameLaby.laby.Labyrinthe;

/**
 * Classe Fleche qui hérite de la classe Case
 */
public class Fleche extends Case {

    private String direction;

    /**
     * Constructeur pour les fleches
     * @param direction
     * @param x
     * @param y
     * @param laby
     */
    public Fleche(String direction, int x, int y, Labyrinthe laby){
        super(x, y, laby);
        this.direction = direction;
    }

    /**
     * fait avancer la fleche
     * return true si la fleche a pu avancer et false sinon
     * @return boolean
     */
    public boolean avancer(){
        try {
            Labyrinthe laby = this.getLaby();
            int x = this.getX();
            int y = this.getY();
            // on recupere la case suivante
            int[] suivant = Labyrinthe.getSuivant(x, y, this.direction);
            // on verifie si la case suivante est vide
            if (laby.estVideCase(suivant[0], suivant[1])) {
                // si c'est vide, on effectue le deplacement'
                this.setX(suivant[0]);
                this.setY(suivant[1]);
            } else {
                // sinon on ne peut pas avancer
                return false;
            }
            return true;
        }catch (ArrayIndexOutOfBoundsException e){
            // si la fleche sort du labyrinthe, elle ne peut pas avancer
            return false;
        }
    }

    /**
     * gere les collisions de la fleche
     * retourne l'entite sur laquelle la fleche est tombee si elle existe
     * @return Entite
     */
    public Entite collision(){
        Labyrinthe laby = this.getLaby();
        // on recupere la case suivante
        int[] suivant = Labyrinthe.getSuivant(getX(), getY(), direction);

        // on regarde si une entite est presente sur la case suivante
        for (Entite e : laby.entites) {
            // si c'est le cas et que l'entite est vivante
            if(e.etrePresent(suivant[0], suivant[1])&&e.etreVivant()){
                // et si ce n'est pas le personnage
                if (!(e instanceof Perso)) {
                    // on retourne l'entite
                    return e;
                }
            }
        }
        // sinon on retourne null
        return null;
    }
}
