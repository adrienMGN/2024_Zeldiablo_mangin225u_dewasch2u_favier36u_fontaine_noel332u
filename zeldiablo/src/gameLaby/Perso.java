package gameLaby;


/**
 * gere un personnage situe en x,y
 */
public class Perso extends Entite {

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Perso(int dx, int dy) {
        super(dx, dy);
        this.pv = 5;
    }

    public void mourir(Labyrinthe laby) {
        super.mourir(laby);
        System.out.println("Vous avez perdu");
    }

}
