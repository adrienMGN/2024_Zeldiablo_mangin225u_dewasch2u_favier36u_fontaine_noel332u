package gameLaby;

public class Coffre extends Case{

    static int nbCoffres = 0;
    boolean actif;

    public Coffre(int x, int y, Labyrinthe laby) {
        super(x, y, laby);
        actif = true;
        nbCoffres++;
    }

    public void action(){
        Labyrinthe laby = getLaby();
        if(laby.getPerso().possedeCle()){
            laby.getPerso().utiliserCle();
            actif = false;
            if(Math.floor(Math.random()*2+1) == 1){
                System.out.println("Vous venez d'obtenir une épée");
                //laby.getPerso().ajouterItem(); //Epee
            } else if(Math.floor(Math.random()*2+1) == 2){
                System.out.println("Vous venez d'obtenir un Arc");
                //laby.getPerso().ajouterItem(); //Arc
            }
        }
    }


    public boolean isActif(){
        return actif;
    }


}
