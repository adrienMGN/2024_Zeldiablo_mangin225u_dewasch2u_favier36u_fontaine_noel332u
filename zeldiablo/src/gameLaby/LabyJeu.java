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
            declenchable.entitePresent(laby);
        }

        for (int i = 0; i < laby.items.size(); i++) {
            Item item = laby.items.get(i);
            item.persoPresent(laby);
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
                laby.getPerso().addPv(1);
            }
            regen = 0;
        }


        laby.majLaby();
        laby.gestionEntite();


        // Gestion attaque du personnage
        if (clavier.space){
            laby.attaqueDirectionnel(DERNIER_MOUVEMENT);
        }

        if(laby.getSortie()!=null){
            if (laby.etreFini()||laby.getSortie().sortiePossible(laby)){
                Platform.exit();
            }
        }
        else {
            // Fin du jeu si le personnage est mort ou si le labyrinthe est fini
            if (laby.etreFini()) {
                Platform.exit();
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
