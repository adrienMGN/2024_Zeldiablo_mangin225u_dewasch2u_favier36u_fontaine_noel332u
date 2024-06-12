package gameLaby.entites;

import gameLaby.laby.Case;
import gameLaby.laby.Labyrinthe;

/**
 * Gere une entite
 */
public abstract class Entite extends Case {
    private int pv ;

    /**
     * @param x
     * @param y
     * @param pv
     * @param laby
     */
    public Entite(int x, int y, int pv, Labyrinthe laby) {
        super(x, y, laby);
        this.pv = pv;
    }

    /**
     * @return pv
     */
    public int getPv(){
        return pv;
    }

    /**
     * @param pv
     */
    public void setPv(int pv) {
        this.pv = pv;
    }

    /**
     * @return boolean si l'entite est vivante ou non'
     */
    public boolean etreVivant() {
        return pv != 0;
    }



    /**
     * enite subit degats
     * @param degats
     */
    public void subirDegats(int degats) {
        this.pv -= degats;
        if (this.pv < 0) {
            this.pv = 0;
        }
    }


    /*
    * methode collision pour savoir si une entite est presente dans une case et s'il faut gérer une collision
    * @param int[] xy
    * return Entite presente dans la cases
    * */
    public Entite collision(int[] xy){
        Labyrinthe laby = this.getLaby();
        for (Entite entite : laby.entites) {
            // si l'entite est presente dans la case et qu'elle est vivante on la retourne
            if (entite.etrePresent(xy[0], xy[1]) && entite.etreVivant()) {
                return entite;
            }
        }
        // si il n'y a aucune entite dans la case on retourne null
        return null;
    }
}