package gameLaby;

public class PassageSecret {
    private int id;
    private int x;
    private int y;
    private boolean active;

    public PassageSecret(int id, int x, int y) {
        this.x = x;
        this.y = y;
        this.active = false;
    }

    public void ouvrir() {
        this.active = true;
    }

    public boolean isActive() {
        return active;
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
