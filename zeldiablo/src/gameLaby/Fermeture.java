package gameLaby;

public class Fermeture extends Declenchable {

    public static int nbFermetures = 0;

    public Fermeture(int id, int x, int y) {
        super(id, x, y);
        nbFermetures++;
    }

    public void action(Labyrinthe laby){
        for (PassageSecret passage : laby.psecrets) {
            if (passage.getId() == getId()){
                if(passage.isActive()) {
                    if (laby.getMonstre(passage.getX(), passage.getY())) {
                        laby.mouvementsMonstres();
                    }
                    passage.fermer();
                }
            }
        }
    }
}