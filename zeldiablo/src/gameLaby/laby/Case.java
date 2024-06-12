package gameLaby.laby;

/**
 * Classe abstraite Case qui permet de définir tout ce qui est sur une case du labyrinthe
 */
public abstract class Case {
    private int x;
    private int y;
    private Labyrinthe laby;

    /**
     * Constructeur de Case avec labyrinthe fixe
     * @param x
     * @param y
     * @param laby
     */
    public Case(int x, int y, Labyrinthe laby) {
        this.x = x;
        this.y = y;
        this.laby = laby;
    }

    /**
     * Constructeur de Case avec labyrinthe non fixe
     * @param x
     * @param y
     */
    public Case(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * recupere y
     * @return int y
     */
    public int getY() {
        return y;
    }

    /**
     * recupere x
     * @return int x
     */
    public int getX() {
        return x;
    }

    /**
     * recupere le labyrinthe
     * @return Labyrinthe laby
     */
    public Labyrinthe getLaby() {
        return laby;
    }

    /**
     * modifie le parametre x
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * modifie le parametre y
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Renseigne si le personnage est présent
     * @param dx
     * @param dy
     * @return boolean si la case est au coordonnees dx, dy
     */
    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }
}
