package gameLaby;


/**
 * gere un personnage situe en x,y
 */
public class Perso extends Entite {

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

    public void mourir() {
        super.mourir();
        System.out.println("Vous avez perdu");
    }

   public int attaquer(Monstre monstre) {
        monstre.subirDegats(1);
       System.out.println("Vous attaquez le monstre");
        return -1;
    }

}
