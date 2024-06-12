package gameLaby.entites;

import gameLaby.laby.Labyrinthe;

/**
 * gere une entite de type monstre
 */
public class Monstre extends Entite {

    /**
     * @param x
     * @param y
     * @param pv
     * @param laby
     */
    public Monstre(int x, int y, int pv, Labyrinthe laby) {
        super(x, y, pv, laby);
    }

    /**
     * méthode attaquer attaque le perso
     * @param perso
     * @return
     */
    public void attaquer(Perso perso) {
        perso.subirDegats(1);
    }
}
