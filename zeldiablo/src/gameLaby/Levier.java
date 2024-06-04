package gameLaby;

public class Levier {
    private int id;
    private int x;
    private int y;
    private boolean active;

    public Levier(int id, int x, int y) {
        this.x = x;
        this.y = y;
        this.active = false;
    }

    public boolean persoPresent(Perso pj) {
        return pj.getX() == x && pj.getY() == y;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
