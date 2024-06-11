package gameLaby;

public abstract class Entite extends Case{
    private int pv ;

    public Entite(int x, int y, int pv, Labyrinthe laby) {
        super(x, y, laby);
        this.pv = pv;
    }

    public int getPv(){
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    /**
     * @return boolean si l'entite est vivante ou non'
     */
    public boolean etreVivant() {
        return pv != 0;
    }



    /**
     * enite subit degats
     * @param degats
     */
    public void subirDegats(int degats) {
        this.pv -= degats;
    }


    /*
    * methode collision pour savoir si une entite est presente dans une case et s'il faut gérer une collision
    * @param int[] xy
    * return Entite presente dans la cases
    * */
    public Entite collision(int[] xy){
        Labyrinthe laby = this.getLaby();
        for (Entite entite : laby.entites) {
            if (entite.etrePresent(xy[0], xy[1]) && entite.etreVivant()) {
                return entite;
            }
        }
        return null;
    }
}