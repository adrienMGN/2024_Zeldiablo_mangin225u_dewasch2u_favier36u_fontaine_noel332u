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
    public Perso(int dx, int dy) {
        super(dx, dy);
        this.setPv(5);
    }

    /**
     * tue le personnage et affiche un message
     */
    public void mourir() {
        super.mourir();
        System.out.println("Vous avez perdu");
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

    public void ajouterInventaire(Item item){
        this.inventaire.add(item);
    }

    public ArrayList<Item> getInventaire(){
        return this.inventaire;
    }

}
