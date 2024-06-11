package gameLaby;
import javafx.application.Platform;
import moteurJeu.Clavier;
import moteurJeu.Jeu;
import moteurJeu.MoteurJeu;


public class LabyJeu implements Jeu {

    private final Labyrinthe laby;

    public static String DERNIER_MOUVEMENT = "";

    private double timer = 0;
    private double regen = 0;

    public LabyJeu (Labyrinthe labyrinthe) {
        laby = labyrinthe;
    }

    public void update(double secondes, Clavier clavier) {
        if (clavier.droite){
            DERNIER_MOUVEMENT = Labyrinthe.DROITE;
            laby.deplacerPerso(Labyrinthe.DROITE);
        }

        else if (clavier.gauche){
            DERNIER_MOUVEMENT = Labyrinthe.GAUCHE;
            laby.deplacerPerso(Labyrinthe.GAUCHE);
        }

        else if (clavier.haut){
            DERNIER_MOUVEMENT = Labyrinthe.HAUT;
            laby.deplacerPerso(Labyrinthe.HAUT);
        }

        else if (clavier.bas){
            DERNIER_MOUVEMENT = Labyrinthe.BAS;
            laby.deplacerPerso(Labyrinthe.BAS);
        }

        // Gestion des cases declenchables
        for (int i = 0; i < laby.declenchables.size(); i++) {
            Declenchable declenchable = laby.declenchables.get(i);
            if(declenchable.persoPresent()){
                declenchable.action();
            }
        }

        for (int i = 0; i < laby.items.size(); i++) {
            Item item = laby.items.get(i);
            if(item.persoPresent()){
                item.ramasserItem();
            }
        }

        // update le mouvement des monstres toutes les 0.5 secondes
        timer+=secondes;
        regen+=secondes;
        if (timer >= 0.5){
            laby.mouvementsMonstres();
            timer = 0;
        }

        if (regen >= 5){
            if (laby.getPerso().getPv() < 5) {
                laby.getPerso().setPv(laby.getPerso().getPv() + 1);
            }
            regen = 0;
        }


        laby.majLaby();


        // Gestion attaque du personnage
        if (clavier.space){
            laby.attaqueDirectionnel(DERNIER_MOUVEMENT);
        }

        if(etreFini()){
            Platform.exit();
        }
    }

    public void init() {
    }

    public boolean etreFini(){
        boolean fini = false;
        if(laby.getSortie()!=null){
            if (laby.etreFini()||laby.getSortie().sortiePossible()){
                fini = true;
            }
        }
        else {
            // Fin du jeu si le personnage est mort ou si le labyrinthe est fini
            if (laby.etreFini()) {
                fini = true;
            }
        }
        return fini;
    }

    public Labyrinthe getLaby() {
        return laby;
    }
}
