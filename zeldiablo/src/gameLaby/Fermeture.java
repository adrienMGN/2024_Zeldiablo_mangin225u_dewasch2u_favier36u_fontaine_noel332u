package gameLaby;

public class Fermeture extends Declenchable {

    // gestion du nombre de fermetures pour id
    public static int nbFermetures = 0;

    public Fermeture(int id, int x, int y) {
        super(id, x, y);
        nbFermetures++;
    }

    /**
     * @param laby
     * parcours psecrets et les ferme
     */
    public void action(Labyrinthe laby){
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