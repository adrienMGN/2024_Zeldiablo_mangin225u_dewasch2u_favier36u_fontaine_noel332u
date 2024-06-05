package gameLaby;

public abstract class Entite {
    public int x;
    public int y;
    public int pv ;
    public boolean estVivant = true;
    private Labyrinthe laby;

    public Entite(int x, int y, int pv) {
        this.x = x;
        this.y = y;
        this.pv = pv;
    }

    public Entite(int x, int y, Labyrinthe laby) {
        this.x = x;
        this.y = y;
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

    public Labyrinthe getLaby() {
        return this.laby;
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
    public abstract void ajouterEntite(Labyrinthe laby);

    public boolean estVideCase(Labyrinthe laby, int x, int y) {
        boolean vide = true;
        for (Entite entite : laby.entites) {
            if (entite.etrePresent(x, y)) {
                vide = false;
            }

        }
        for (Traversable traversable : laby.traversables) {
            if (traversable.etrePresent(x, y)) {
                vide = false;
            }
        }
        for (PassageSecret passageSecret : laby.psecrets) {
            if (passageSecret.etrePresent(x, y)) {
                vide = false;
            }
        }

            if (laby.pj.etrePresent(x,y)) {
                vide = false;
            }
            if (laby.murs[x][y]) {
                vide = false;
            }


        return vide;
    }

}
