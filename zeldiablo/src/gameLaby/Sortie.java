package gameLaby;

public class Sortie {
    private int x;
    private int y;

    public Sortie(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }

    public boolean persoPresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }

    public boolean sortiePossible(Labyrinthe laby){
        Perso p = laby.getPerso();
        return (persoPresent(p.getX(), p.getY()) && p.possedeAmulette());
    }

}
