package gameLaby;

public abstract class Entite {
    private int x;
    private int y;
    private int pv ;
    private boolean estVivant = true;
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
    public int getPv(){
        return pv;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setPv(int pv) {
        this.pv = pv;
    }

    public boolean etreVivant() {
        return estVivant;
    }


    public void mourir() {
        estVivant = false;
    }

    public void subirDegats(int degats) {
        this.pv -= degats;
    }


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