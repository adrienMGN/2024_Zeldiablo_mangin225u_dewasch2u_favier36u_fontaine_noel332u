package gameLaby.interactif;

import gameLaby.laby.Labyrinthe;

/**
 * Classe pour les cases d'ouverture d'un passage secret
 */
public class Ouverture extends Declenchable {

    // gestion du nombre d'ouvertures pour id
    public static int nbOuvertures = 0;

    /**
     * constructeur d'une ouverture
     * @param id
     * @param x
     * @param y
     * @param laby
     */
    public Ouverture(int id, int x, int y, Labyrinthe laby) {
        super(id, x, y, laby);
        nbOuvertures++;
    }

    /**
     * action pour ouvrir les passages secrets si id correspond
     */
    public void action(){
        Labyrinthe laby = getLaby();
        for (PassageSecret passage : laby.psecrets) {
            // si id même entre ouverture et passage secret
            if (passage.getId() == getId()){
                // si le passage n'est pas deja ouvert
                if(!passage.isActive()) {
                    laby.ouvrirPassageSecret(passage);
                }
            }
        }
    }
}