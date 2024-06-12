package gameLaby.objets;

import gameLaby.Main;
import gameLaby.entites.Entite;
import gameLaby.laby.Labyrinthe;

import java.util.ArrayList;

/**
 * Classe Arc qui hérite de la classe Arme
 */
public class Arc extends Arme{

    private ArrayList<Fleche> fleches = new ArrayList<>();
    private int nbFleches = 5;

    /**
     * Constructeur pour les arcs
     * @param x
     * @param y
     * @param degats
     */
    public Arc(int x, int y, int degats) {
        super(x, y, degats);
    }

    /**
     * tire une fleche dans la direction du joueur
     * @param direction
     */
    public void tirerFleche(String direction){
        Labyrinthe laby = Main.getLaby();
        // si on a encore une fleche au moins
        if(nbFleches > 0){
            // on creer une fleche et on l'ajoute a la liste des fleches tirees
            Fleche f = new Fleche(direction, laby.getPerso().getX(), laby.getPerso().getY(), laby);
            fleches.add(f);
            nbFleches--;
        }
    }

    /**
     * fait avancer les fleches et gere les collisions
     */
    public void avancerFleches(){
        for(int i = 0; i<fleches.size(); i++){
            Fleche f = fleches.get(i);
            // si la fleche ne peut plus avancer
            if(!f.avancer()){
                // on regarde si elle a touche une entite
                Entite e = f.collision();
                if(e != null){
                    // si c'est le cas on lui inflige des degats
                    e.subirDegats(getDegats());
                }
                // on la retire de la liste des fleches tirees
                fleches.remove(f);
            }
        }
    }

    /**
     * retourne la liste des fleches
     * @return liste des fleches
     */
    public ArrayList<Fleche> getFleches(){
        return fleches;
    }

    /**
     * recupere le nombre de fleches restantes
     * @return nbFleches
     */
    public int getNbFleches(){
        return nbFleches;
    }

    /**
     * change le nombre de fleches de l'arc
     * @param nbFleches
     */
    public void setNbFleches(int nbFleches){
        this.nbFleches = nbFleches;
    }
}
