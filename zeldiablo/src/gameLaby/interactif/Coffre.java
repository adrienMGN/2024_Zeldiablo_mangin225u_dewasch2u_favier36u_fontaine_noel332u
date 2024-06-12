package gameLaby.interactif;

import gameLaby.laby.Case;
import gameLaby.laby.Labyrinthe;
import gameLaby.objets.Arc;
import gameLaby.objets.Epee;

/**
 * Classe Coffre
 */
public class Coffre extends Case {

    static int nbCoffres = 0;
    boolean actif;

    /**
     * Constructeur de la classe Coffre
     * @param x
     * @param y
     * @param laby
     */
    public Coffre(int x, int y, Labyrinthe laby) {
        super(x, y, laby);
        actif = true;
        nbCoffres++;
    }

    /**
     * action pour ouvrir les coffres
     * ouvre si le personnage a une cle
     * donne au hasard une epee ou un arc
     */
    public void tenterOuverture(){
        Labyrinthe laby = getLaby();
        // si le personnage possede une cle
        if(laby.getPerso().possedeCle()){
            // alors il l'ouvre en utilisant la clé
            laby.getPerso().utiliserCle();
            // on desactive le coffre
            actif = false;

            // on donne un objet au hasard (epee ou arc)
            int random = (int) Math.floor(Math.random()*2+1);
            if(random == 1){
                System.out.println("Vous venez d'obtenir une épée");
                int dmg = (int) Math.floor(Math.random()*3+1);
                Epee epee = new Epee(this.getX(), this.getY(), dmg+1);
                laby.ajouterItem(epee); //Epee
            } else if(random == 2){
                System.out.println("Vous venez d'obtenir un Arc");
                int dmg = (int) Math.floor(Math.random()*3+1);
                Arc arc = new Arc(this.getX(), this.getY(), dmg+1);
                laby.ajouterItem(arc); //Arc
            }
        }
    }


    /**
     * retourne si le coffre a ete ouvert ou non
     * @return actif
     */
    public boolean isActif(){
        return actif;
    }


}
