package gameLaby.objets;

import gameLaby.entites.Entite;
import gameLaby.laby.Labyrinthe;

import java.util.ArrayList;

public class Arc extends Arme{

    private ArrayList<Fleche> fleches = new ArrayList<>();
    private int nbFleches = 5;

    public Arc(int x, int y, int degats, Labyrinthe laby) {
        super(x, y, degats, laby);
    }

    public void tirerFleche(String direction){
        Labyrinthe laby = getLaby();
        if(nbFleches > 0){
            Fleche f = new Fleche(direction, laby.getPerso().getX(), laby.getPerso().getY(), laby);
            fleches.add(f);
            nbFleches--;
        }
    }

    public void avancerFleches(){
        int taille = fleches.size();
        for(int i = 0; i<taille; i++){
            Fleche f = fleches.get(i);
            if(!f.avancer()){
                Entite e = f.collision();
                if(e != null){
                    e.subirDegats(getDegats());
                }
                fleches.remove(f);
            }
        }
    }

    public ArrayList<Fleche> getFleches(){
        return fleches;
    }

    public int getNbFleches(){
        return nbFleches;
    }

    public void setNbFleches(int nbFleches){
        this.nbFleches = nbFleches;
    }
}
