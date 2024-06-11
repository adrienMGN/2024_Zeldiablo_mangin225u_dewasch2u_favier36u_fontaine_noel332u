package gameLaby;

public class Coffre extends Declenchable {

    int nbCoffres = 0;
    private int x,y,id;

    public Coffre(int id, int x, int y) {
        super(id, x, y);
        nbCoffres++;
    }

    public void ouvrir(Labyrinthe laby){
        Perso p = laby.getPerso();
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
