package gameLaby;

public class Levier {
    private int x;
    private int y;

    public Levier(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean persoPresent(Perso pj) {
        return pj.getX() == x && pj.getY() == y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
