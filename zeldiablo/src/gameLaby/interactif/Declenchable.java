package gameLaby.interactif;

import gameLaby.laby.Case;
import gameLaby.entites.Entite;
import gameLaby.laby.Labyrinthe;

/**
 * Classe abstraite pour les cases declenchables
 */
public abstract class Declenchable extends Case {
    private int id;

    /**
     * Constructeur de Declenchable
     * @param id
     * @param x
     * @param y
     * @param laby
     */
    public Declenchable(int id, int x, int y, Labyrinthe laby) {
        super(x, y, laby);
        this.id = id;
    }

    /**
     * action a effectuer
     */
    public abstract void action();

    /**
     * retourne si une entite est sur la case ou non
     * @return true si une entite est sur la case
     */
    public boolean entitePresente() {
        for (Entite e : getLaby().entites) {
            // si entite est sur la case on retourne true
            if (e.getX() == getX() && e.getY() == getY()){
                return true;
            }
        }
        return false;
    }


    /**
     * retourne l'id
     * @return id
     */
    public int getId() {
        return id;
    }
}
