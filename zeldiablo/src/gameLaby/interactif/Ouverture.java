package gameLaby.interactif;

import gameLaby.laby.Labyrinthe;

public class Ouverture extends Declenchable {

    public static int nbOuvertures = 0;

    public Ouverture(int id, int x, int y, Labyrinthe laby) {
        super(id, x, y, laby);
        nbOuvertures++;
    }

    /**
     * action pour ouvrir les passages secrets
     */
    public void action(){
        Labyrinthe laby = getLaby();
        for (PassageSecret passage : laby.psecrets) {
            if (passage.getId() == getId()){
                if(!passage.isActive()) {
                    passage.ouvrir();
                }
            }
        }
    }
}