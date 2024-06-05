package gameLaby;

public class PassageSecret {
    private int x;
    private int y;
    private int id;
    private boolean active;

    public static int nbPassages = 0;

    public PassageSecret( int id, int x, int y) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.active = false;
        nbPassages++;
    }

    public void ouvrir() {
        this.active = true;
    }

    public void fermer() {
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getId() {
        return id;
    }
}
