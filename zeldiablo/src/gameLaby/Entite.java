package gameLaby;

public abstract class Entite {
    public int x;
    public int y;
    public int pv ;
    public boolean estVivant = true;
    private Labyrinthe laby;

    public Entite(int x, int y, int pv, Labyrinthe laby) {
        this.x = x;
        this.y = y;
        this.pv = pv;
        this.laby = laby;
    }

    public Entite(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public boolean etrePresent(int dx, int dy) {
        return (this.x == dx && this.y == dy);
    }

    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }


    public void mourir(Labyrinthe laby) {
        laby.entites.remove(this);
        estVivant = false;
    }


/*
    public int checkPv() {
        if (this.pv == 0) {
            estVivant = false;
        }
        return this.pv;
    }

    public int subirDegats(int degats) {
        this.pv -= degats;
        return this.checkPv();
    }

*/
    /*
    * methode collision
    * */
    public Entite collision(int[] xy){
        for (Entite entite : laby.entites) {
            if (entite.etrePresent(xy[0], xy[1])) {
                return entite;
            }
        }
        return null;
    }
}