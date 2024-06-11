package gameLaby;

public class PassageSecret extends Case{
    private int id;
    private boolean active;

    // gestion du nombre de passages secrets pour id
    public static int nbPassages = 0;

    public PassageSecret( int id, int x, int y, Labyrinthe laby) {
        super(x, y, laby);
        this.id = id;
        this.active = false;
        nbPassages++;
    }

    /**
     * met active a true
     */
    public void ouvrir() {
        this.active = true;
    }

    public void fermer() {
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }

    public int getId() {
        return id;
    }
}
