package gameLaby.entites;


import gameLaby.laby.Labyrinthe;
import gameLaby.objets.*;

import java.util.ArrayList;

/**
 * gere un personnage du jeu
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

    /**
     * selectionne l'epee la plus puissante
     * @return epee
     */
    public Epee selectionnerMeilleurEpee() {
        Epee meilleur = null;
        for (int i = 0; i < inventaire.size(); i++) {
            // on parcout l'inventaire
            if (inventaire.get(i) instanceof Epee) {
                // si l'objet est une epee
                Epee epee = (Epee) inventaire.get(i);
                // on remplace le meilleur par l'epee si elle est plus puissante
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
       // on selectionne l'epee la plus puissante
       Epee e = selectionnerMeilleurEpee();
       // si on a une epee on attaque avec les degats de l'epee sinon on attaque avec 1
       if (e!= null) {
           monstre.subirDegats(e.getDegats());
       } else {
           monstre.subirDegats(1);
       }
       System.out.println("Vous attaquez le monstre");
    }


    /**
     * @return boolean si le personnage possede une amulette
     */
    public boolean possedeAmulette() {
        for (Item item : inventaire) {
            // on parcourt l'inventaire et on regarde si on a une amulette
            if (item instanceof Amulette) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return boolean si le personnage possede une cle
     */
    public boolean possedeCle() {
        for (Item item : inventaire) {
            // on parcourt l'inventaire et on regarde si on a une cle
            if (item instanceof Cle) {
                return true;
            }
        }
        return false;
    }

    /**
     * utilise une cle
     */
    public void utiliserCle() {
        for (Item item : inventaire) {
            // on parcourt l'inventaire et on utilise la cle
            if (item instanceof Cle) {
                inventaire.remove(item);
                return;
            }
        }
    }

    /**
     * selectionne l'arc le plus puissant
     * @return arc
     */
    public Arc selectionnerMeilleurArc(){
        Arc meilleur = null;
        for (int i = 0; i < inventaire.size(); i++) {
            // on parcout l'inventaire et on regarde si l'objet est un arc
            if (inventaire.get(i) instanceof Arc) {
                Arc arc = (Arc) inventaire.get(i);
                // on remplace le meilleur par l'arc si il est plus puissant
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

    /**
     * attaque a distance dans la derniere direction du perso
     * @param direction direction de l'attaque
     */
    public void attaquerDistance(String direction){
        // on selectionne l'arc la plus puissant'
        Arc arc = selectionnerMeilleurArc();
        if (arc != null) {
            // si on a un arc, on tire une fleche dans la direction de l'attaque
            arc.tirerFleche(direction);
        }
    }

    /**
     * ajoute un item a l'inventaire
     * @param item
     */
    public void ajouterInventaire(Item item){
        this.inventaire.add(item);
    }

    /**
     * @return inventaire
     */
    public ArrayList<Item> getInventaire(){
        return this.inventaire;
    }

    /**
     * @param inventaire
     */
    public void setInventaire(ArrayList<Item> inventaire){
        this.inventaire = inventaire;
    }
}
