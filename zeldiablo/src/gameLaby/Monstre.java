package gameLaby;

public class Monstre extends Entite {

    public Monstre(int x, int y, int pv, Labyrinthe laby) {
        super(x, y, pv, laby);
        this.setPv(2);
    }

    public int attaquer(Perso perso) {

        perso.subirDegats(1);
        System.out.println("attaquer");

        return -1;
    }
}
