package gameLaby.interactif;

import gameLaby.laby.Labyrinthe;

/**
 * Classe pour les cases de fermeture d'un passage secret
 */
public class Fermeture extends Declenchable {

    // gestion du nombre de fermetures pour id
    public static int nbFermetures = 0;

    /**
     * Constructeur de la classe Fermeture
     * @param id
     * @param x
     * @param y
     * @param laby
     */
    public Fermeture(int id, int x, int y, Labyrinthe laby) {
        super(id, x, y, laby);
        nbFermetures++;
    }

    /**
     * parcours psecrets et les ferme si id correspond
     */
    public void action(){
        Labyrinthe laby = getLaby();
        for (PassageSecret passage : laby.psecrets) {
            // si id même entre fermeture et passage secret
            if (passage.getId() == getId()){
                // si le passage n'est pas deja ferme
                if(passage.isActive()) {
                    // si un monstre est sur le passage, on le deplace
                    if (laby.getMonstre(passage.getX(), passage.getY())) {
                        laby.mouvementsMonstres();
                    }
                    passage.fermer();
                }
            }
        }
    }
}