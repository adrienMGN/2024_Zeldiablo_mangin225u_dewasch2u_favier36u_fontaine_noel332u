package gameLaby.interactif;

import gameLaby.laby.Case;
import gameLaby.laby.Labyrinthe;
import gameLaby.objets.Arc;
import gameLaby.objets.Epee;

public class Coffre extends Case {

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
            int random = (int) Math.floor(Math.random()*2+1);
            if(random == 0){
                System.out.println("Vous venez d'obtenir une épée");
                int dmg = (int) Math.floor(Math.random()*3+1);
                Epee epee = new Epee(this.getX(), this.getY(), dmg+1, laby);
                laby.ajouterItem(epee); //Epee
            } else if(random == 2 || random == 1){
                System.out.println("Vous venez d'obtenir un Arc");
                int dmg = (int) Math.floor(Math.random()*3+1);
                Arc arc = new Arc(this.getX(), this.getY(), dmg+1, laby);
                laby.ajouterItem(arc); //Arc
            }
        }
    }


    public boolean isActif(){
        return actif;
    }


}
