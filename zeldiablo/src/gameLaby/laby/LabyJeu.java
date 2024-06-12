package gameLaby.laby;
import gameLaby.interactif.Declenchable;
import gameLaby.objets.Arc;
import gameLaby.objets.Item;
import javafx.application.Platform;
import moteurJeu.Clavier;
import moteurJeu.Jeu;


/**
 * Classe LabyJeu
 */
public class LabyJeu implements Jeu {

    private final Labyrinthe laby;

    public static String DERNIER_MOUVEMENT = "";

    private double timer = 0;
    private double regen = 0;
    private double rechargeFleche = 0;
    private double updateFleche = 0;

    /**
     * @param labyrinthe
     */
    public LabyJeu (Labyrinthe labyrinthe) {
        laby = labyrinthe;
    }

    /**
     * @param secondes temps ecoule depuis la derniere mise a jour
     * @param clavier  objet contenant l'état du clavier'
     */
    public void update(double secondes, Clavier clavier) {

        // Gestion des touches du clavier

        // Gestion deplacement gauche droite haut bas
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

        // Gestion des touches pour les actions
        // touche e pour actionner un item
        if (clavier.e){
            laby.actionnerItem(LabyJeu.DERNIER_MOUVEMENT);
        }

        // touche f pour attaquer a distance
        if (clavier.f){
            laby.getPerso().attaquerDistance(LabyJeu.DERNIER_MOUVEMENT);
        }

        // touche espace pour attaquer en melee
        if (clavier.space){
            laby.attaqueDirectionnel(DERNIER_MOUVEMENT);
        }


        // Gestion des cases declenchables (ouverture et fermeture passage secret)
        for (int i = 0; i < laby.declenchables.size(); i++) {
            Declenchable declenchable = laby.declenchables.get(i);
            // si une entite est presente sur la case declenchable, declencher l'action
            if(declenchable.entitePresente()){
                declenchable.action();
            }
        }

        // Gestion de la recuperation d'items
        for (int i = 0; i < laby.items.size(); i++) {
            Item item = laby.items.get(i);
            // si le personnage est present sur la case de l'item, ramasser l'item
            if(item.persoPresent()){
                item.ramasserItem();
            }
        }


        // Mise a jour toutes les x secondes

        timer+=secondes;
        regen+=secondes;
        updateFleche+=secondes;

        // mouvement des monstres toutes les 0.5 secondes
        if (timer >= 0.5){
            laby.mouvementsMonstres();
            timer = 0;
        }

        // mise a jour des fleches toutes les 0.25 secondes
        if (updateFleche >= 0.25){
            Arc a = laby.getPerso().selectionnerMeilleurArc();
            if (a != null){
                a.avancerFleches();
            }
            updateFleche = 0;
        }

        // regen de 1 pv toutes les 5 secondes si pv < 5
        if (regen >= 5){
            if (laby.getPerso().getPv() < 5) {
                laby.getPerso().setPv(laby.getPerso().getPv() + 1);
            }
            regen = 0;
        }

        // recharge des fleches toutes les 5 secondes si le personnage n'a plus de fleches
        Arc a = laby.getPerso().selectionnerMeilleurArc();
        if (a != null && a.getNbFleches() == 0){
            rechargeFleche += secondes;
            if (rechargeFleche >= 5){
                a.setNbFleches(5);
                rechargeFleche = 0;
            }
        }

        // On test si le jeu est fini on exit
        if(etreFini()){
            Platform.exit();
        }
    }

    /**
     * Methode d'initialisation
     */
    public void init() {
    }

    /**
     * le jeu est fini si le personnage est mort ou si il est sorti du labyrinthe
     * @return true si le jeu est fini
     */
    public boolean etreFini(){
        boolean fini = false;
        if(laby.getSortie()!=null){
            if (laby.getSortie().sortiePossible()){
                System.out.println("Bravo vous avez fini le labyrinthe");
                fini = true;
            }
            if (laby.etreFini()){
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

    /**
     * @return le labyrinthe
     */
    public Labyrinthe getLaby() {
        return laby;
    }
}
