package gameLaby;

public class Fermeture extends Traversable{

    public static int nbFermetures = 0;

    public Fermeture(int id, int x, int y) {
        super(id, x, y);
        nbFermetures++;
    }

    public void action(Labyrinthe laby){
        for (PassageSecret passage : laby.psecrets) {
            if (passage.getId() == getId()){
                if(passage.isActive()) {
                    passage.fermer();
                    laby.murs[passage.getX()][passage.getY()] = true;
                }
            }
        }
    }
}