package gameLaby;


import java.util.ArrayList;

/**
 * gere un personnage situe en x,y
 */
public class Perso extends Entite {

    ArrayList<Item> inventaire = new ArrayList<Item>();
    private static boolean inventaireOuvert = false;

    public static void ouvrirInventaire(){
        inventaireOuvert = true;
    }

    public static void fermerInventaire(){
        inventaireOuvert = false;
    }

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

    public boolean possedeAmulette() {
        for (Item item : inventaire) {
            if (item instanceof Amulette) {
                return true;
            }
        }
        return false;
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

    public static boolean inventaireOuvert(){
        return inventaireOuvert;
    }

    public void addPv(int pv){
        this.setPv(this.getPv()+pv);
    }

}
