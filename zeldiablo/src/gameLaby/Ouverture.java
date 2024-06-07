package gameLaby;

public class Ouverture extends Declenchable {

    public static int nbOuvertures = 0;

    public Ouverture(int id, int x, int y) {
        super(id, x, y);
        nbOuvertures++;
    }

    public void action(Labyrinthe laby){
        for (PassageSecret passage : laby.psecrets) {
            if (passage.getId() == getId()){
                if(!passage.isActive()) {
                    passage.ouvrir();
                }
            }
        }
    }
}