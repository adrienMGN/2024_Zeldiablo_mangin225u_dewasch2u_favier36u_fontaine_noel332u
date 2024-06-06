package gameLaby;

public class Monstre extends Entite {


    public Monstre(int x, int y, int pv) {
        super(x, y, pv);
    }

    public Monstre(int x, int y, Labyrinthe laby) {
        super(x, y, laby);
        this.pv = 2;
    }

    public int attaquer(Perso perso) {

        perso.pv--;
        System.out.println("attaquer");

        return -1;
    }
}
