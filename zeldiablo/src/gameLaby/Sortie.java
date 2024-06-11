package gameLaby;

public class Sortie extends Case{

    public Sortie(int x, int y, Labyrinthe laby) {
        super(x, y, laby);
    }

    public boolean persoPresent() {
        Perso p = getLaby().getPerso();
        return (p.getX() == getX() && p.getY() == getY());
    }

    public boolean sortiePossible(){
        Perso p = getLaby().getPerso();
        return (persoPresent() && p.possedeAmulette());
    }

}
