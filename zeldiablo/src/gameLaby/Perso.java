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
        this.pv = 10;
    }

    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }

    @Override
    public void ajouterEntite(Labyrinthe laby) {

    }




}
