package gameLaby;

public class Monstre extends Entite {

    public Monstre(int x, int y, int pv, Labyrinthe laby) {
        super(x, y, pv, laby);
    }

    /**
     * méthode attaquer attaque le perso
     * @param perso
     * @return
     */
    public int attaquer(Perso perso) {

        perso.subirDegats(1);
        return -1;
    }
}
