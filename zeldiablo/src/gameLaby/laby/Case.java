package gameLaby.laby;

public abstract class Case {
    private int x;
    private int y;
    private Labyrinthe laby;

    public Case(int x, int y, Labyrinthe laby) {
        this.x = x;
        this.y = y;
        this.laby = laby;
    }

    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }

    public Labyrinthe getLaby() {
        return laby;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }
}
