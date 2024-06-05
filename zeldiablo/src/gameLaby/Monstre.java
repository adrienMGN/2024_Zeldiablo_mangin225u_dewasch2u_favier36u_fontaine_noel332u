package gameLaby;

public class Monstre extends Entite {


    public Monstre(int x, int y, int pv) {
        super(x, y, pv);
    }

    public Monstre(int x, int y, Labyrinthe laby) {
        super(x, y, laby);
        this.pv = 2;
    }

    public void ajouterEntite(Labyrinthe laby) {
        if(estVideCase(laby, this.x, this.y)) {
        laby.entites.add(this);}



    }



    /*
    public int attaquer(Perso perso) {
        perso.pv--;
        perso.checkPv();
        return ;
    }
     */






}
