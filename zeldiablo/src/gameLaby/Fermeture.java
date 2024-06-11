package gameLaby;

public class Fermeture extends Declenchable {

    // gestion du nombre de fermetures pour id
    public static int nbFermetures = 0;

    public Fermeture(int id, int x, int y, Labyrinthe laby) {
        super(id, x, y, laby);
        nbFermetures++;
    }

    /**
     * parcours psecrets et les ferme
     */
    public void action(){
        Labyrinthe laby = getLaby();
        for (PassageSecret passage : laby.psecrets) {
            // si id même entre fermeture et passage secret
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