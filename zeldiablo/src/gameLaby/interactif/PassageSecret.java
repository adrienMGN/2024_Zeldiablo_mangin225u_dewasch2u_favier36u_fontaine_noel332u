package gameLaby.interactif;

import gameLaby.laby.Case;
import gameLaby.laby.Labyrinthe;

/**
 * Classe pour les cases de passage secret
 */
public class PassageSecret extends Case {
    private int id;
    private boolean active;

    // gestion du nombre de passages secrets pour id
    public static int nbPassages = 0;

    /**
     * @param id
     * @param x
     * @param y
     * @param laby
     */
    public PassageSecret( int id, int x, int y, Labyrinthe laby) {
        super(x, y, laby);
        this.id = id;
        this.active = false;
        nbPassages++;
    }

    /**
     * met active a true
     */
    public void ouvrir() {
        this.active = true;
    }

    /**
     * met active a false
     */
    public void fermer() {
        this.active = false;
    }

    /**
     * @return active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }
}
