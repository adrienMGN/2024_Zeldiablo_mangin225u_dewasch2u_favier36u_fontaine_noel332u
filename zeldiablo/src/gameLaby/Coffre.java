package gameLaby;

public class Coffre extends Declenchable {

    int nbCoffres = 0;
    private int id;
    boolean actif;

    public Coffre(int id, int x, int y, Labyrinthe laby) {
        super(id, x, y, laby);
        actif = true;
        nbCoffres++;
    }

    public void ouvrir(Labyrinthe laby){
        Perso p = laby.getPerso();
        if (p.getX() == getX() && p.getY() == getY()) {
            ouvrirCoffre(laby);
        }
    }

    public void action(){
        Labyrinthe laby = getLaby();
        Coffre coffre = laby.coffres.get(0);
            if (coffre.getId() == getId()){
                if(coffre.actif) {
                    coffre.ouvrir(laby);
                }
            }
    }

    public void ouvrirCoffre(Labyrinthe laby){
        actif = false;
        if(laby.getPerso().possedeCle()){
            if(Math.floor(Math.random()*2+1) == 1){
                System.out.println("Vous venez d'obtenir une épée");
                //laby.getPerso().ajouterItem(); //Epee
            } else if(Math.floor(Math.random()*2+1) == 2){
                System.out.println("Vous venez d'obtenir un Arc");
                //laby.getPerso().ajouterItem(); //Arc
            }
        }
    }


}
