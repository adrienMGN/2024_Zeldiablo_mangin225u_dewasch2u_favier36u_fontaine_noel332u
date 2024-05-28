package gameLaby.laby;
import moteurJeu.Clavier;
import moteurJeu.Jeu;

public class LabyJeu implements Jeu {

    private final Perso perso;
    private final Labyrinthe laby = new Labyrinthe("laby1.txt");

    public LabyJeu (Perso perso) {
        this.perso = perso;
    }

    public void update(double secondes, Clavier clavier){
    }

    public void init() {
    }

    public boolean etreFini(){
        return false;
    }
}
