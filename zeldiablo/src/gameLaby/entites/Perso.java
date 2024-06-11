package gameLaby.entites;


import gameLaby.laby.Labyrinthe;
import gameLaby.objets.*;

import java.util.ArrayList;

/**
 * gere un personnage situe en x,y
 */
public class Perso extends Entite {

    ArrayList<Item> inventaire = new ArrayList<Item>();

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Perso(int dx, int dy, int pv, Labyrinthe laby) {
        super(dx, dy, pv, laby);
    }

    public Epee selectionnerMeilleurEpee() {
        Epee meilleur = null;
        for (int i = 0; i < inventaire.size(); i++) {
            if (inventaire.get(i) instanceof Epee) {
                Epee epee = (Epee) inventaire.get(i);
                if(meilleur == null) {
                    meilleur = epee;
                }
                else if (epee.getDegats() > meilleur.getDegats()) {
                    meilleur = epee;
                }
            }
        }
        return meilleur;
    }

    /**
     * attaque un monstre
     *
     * @param monstre monstre a attaquer
     * @return -1
     **/



   public void attaquer(Monstre monstre) {
       Epee e = selectionnerMeilleurEpee();
       if (e!= null) {
           monstre.subirDegats(e.getDegats());
       } else {
           monstre.subirDegats(1);
       }
       System.out.println("Vous attaquez le monstre");
    }

    public boolean possedeAmulette() {
        for (Item item : inventaire) {
            if (item instanceof Amulette) {
                return true;
            }
        }
        return false;
    }

    public boolean possedeCle() {
        for (Item item : inventaire) {
            if (item instanceof Cle) {
                return true;
            }
        }
        return false;
    }

    public void utiliserCle() {
        for (Item item : inventaire) {
            if (item instanceof Cle) {
                inventaire.remove(item);
                return;
            }
        }
    }

    public Arc selectionnerMeilleurArc(){
        Arc meilleur = null;
        for (int i = 0; i < inventaire.size(); i++) {
            if (inventaire.get(i) instanceof Arc) {
                Arc arc = (Arc) inventaire.get(i);
                if (meilleur == null) {
                    meilleur = arc;
                }
                else if (arc.getDegats() > meilleur.getDegats()) {
                    meilleur = arc;
                }
            }
        }
        return meilleur;
    }

    public void attaquerDistance(String direction){
        Arc arc = selectionnerMeilleurArc();
        if (arc != null) {
            arc.tirerFleche(direction);
        }
    }

    public void ajouterInventaire(Item item){
        this.inventaire.add(item);
    }

    public ArrayList<Item> getInventaire(){
        return this.inventaire;
    }

    public void setInventaire(ArrayList<Item> inventaire){
        this.inventaire = inventaire;
    }
}
