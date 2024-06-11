package gameLaby;


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


    /**
     * attaque un monstre
     *
     * @param monstre monstre a attaquer
     * @return -1
     **/

   public int attaquer(Monstre monstre) {
       monstre.subirDegats(1);
       System.out.println("Vous attaquez le monstre");
        return -1;
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
