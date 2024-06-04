package gameLaby;
import moteurJeu.Clavier;
import moteurJeu.Jeu;


public class LabyJeu implements Jeu {

    private final Labyrinthe laby;

    public LabyJeu (Labyrinthe labyrinthe) {
        laby = labyrinthe;
    }

    public void update(double secondes, Clavier clavier){
        if (clavier.droite){
            laby.deplacerPerso(Labyrinthe.DROITE);
        }

        else if (clavier.gauche){
            laby.deplacerPerso(Labyrinthe.GAUCHE);
        }

        else if (clavier.haut){
            laby.deplacerPerso(Labyrinthe.HAUT);
        }

        else if (clavier.bas){
            laby.deplacerPerso(Labyrinthe.BAS);
        }

        for (int i = 0; i < laby.leviers.size(); i++) {
            Levier levier = laby.leviers.get(i);
            if (levier.persoPresent(laby.pj)) {
                PassageSecret psecret = laby.psecrets.get(i);
                psecret.ouvrir();
                laby.murs[psecret.getX()][psecret.getY()] = false;
            }
        }
    }

    public void init() {
    }

    public boolean etreFini(){
        return laby.etreFini();
    }

    public Labyrinthe getLaby() {
        return laby;
    }
}
