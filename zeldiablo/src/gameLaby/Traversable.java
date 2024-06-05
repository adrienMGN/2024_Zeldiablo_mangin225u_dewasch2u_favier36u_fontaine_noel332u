package gameLaby;

public abstract class Traversable {
    private int x,y,id;

    public Traversable(int id,int x, int y) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void action(Labyrinthe laby);

    public void persoPresent(Labyrinthe laby) {
        if (laby.pj.getX() == x && laby.pj.getY() == y)
            action(laby);
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
