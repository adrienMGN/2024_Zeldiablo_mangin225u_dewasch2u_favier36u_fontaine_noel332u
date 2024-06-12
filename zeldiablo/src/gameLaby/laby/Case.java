package gameLaby.laby;

/**
 * Classe abstraite Case qui permet de définir tout ce qui est sur une case du labyrinthe
 */
public abstract class Case {
    private int x;
    private int y;
    private Labyrinthe laby;

    /**
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
     * @param x
     * @param y
     */
    public Case(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return int y
     */
    public int getY() {
        return y;
    }

    /**
     * @return int x
     */
    public int getX() {
        return x;
    }

    /**
     * @return Labyrinthe laby
     */
    public Labyrinthe getLaby() {
        return laby;
    }

    /**
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @param dx
     * @param dy
     * @return boolean si la case est au coordonnees dx, dy
     */
    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }
}
