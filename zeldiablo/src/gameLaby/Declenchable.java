package gameLaby;

public abstract class Declenchable {
    private int x,y,id;

    public Declenchable(int id, int x, int y) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void action(Labyrinthe laby);

    public void entitePresent(Labyrinthe laby) {
        for (Entite e : laby.entites) {
            if (e.getX() == x && e.getY() == y)
                action(laby);
        }
    }

    public boolean etrePresent(int dx, int dy) {

        return (this.x == dx && this.y == dy);
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
