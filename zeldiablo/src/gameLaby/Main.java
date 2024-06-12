package gameLaby;

import java.io.IOException;

import gameLaby.laby.LabyDessin;
import gameLaby.laby.LabyJeu;
import gameLaby.laby.Labyrinthe;
import moteurJeu.MoteurJeu;

/**
 * charge et affiche un labyrinthe
 */
public class Main {

    private static int[] labyActuel = {2,1};
    private static Labyrinthe[][] labyrinthes;


    /**
     * affiche le labyrinth actuel
     * @param laby
     */
    public static void afficherLabyrinthe(Labyrinthe laby) {

        int width = 1000;
         int height = 700;
        LabyDessin.tailleCase = Math.min(width/laby.getLength(), height/laby.getLengthY());
        int pFPS = 10;



        // creation des objets
        LabyJeu jeuLaby = new LabyJeu(laby);
        LabyDessin dessinLaby = new LabyDessin();

        // parametrage du moteur de jeu
        MoteurJeu.setTaille(width,height);
        MoteurJeu.setFPS(pFPS);


        // lancement du jeu
        try{
            MoteurJeu.launch(jeuLaby, dessinLaby);
        }catch(IllegalStateException e){
        }
    }

    /**
     * change le labyrinthe actif
     * @param laby
     * @param direction
     */
    public static void changerLaby(Labyrinthe laby, String direction){
        switch(direction){
            case Labyrinthe.DROITE:
                labyActuel[1]++;
                break;
            case Labyrinthe.GAUCHE:
                labyActuel[1]--;
                break;
            case Labyrinthe.HAUT:
                labyActuel[0]--;
                break;
            case Labyrinthe.BAS:
                labyActuel[0]++;
                break;
        }
        try{
            Labyrinthe newLaby = labyrinthes[labyActuel[0]][labyActuel[1]];
             newLaby.getPerso().setPv(laby.getPerso().getPv());
            newLaby.getPerso().setInventaire(laby.getPerso().getInventaire());
            afficherLabyrinthe(newLaby);
        }catch (ArrayIndexOutOfBoundsException e){
            // si on sort du tableau on reste sur le même labyrinthe
            labyActuel = posLaby(laby);
        }
    }

    /**
     * retourne la position du labyrinthe actif actuellement
     * @param laby
     * @return
     */
    public static int[] posLaby(Labyrinthe laby){
        for (int i = 0; i < labyrinthes.length; i++){
            Labyrinthe[] ligne = labyrinthes[i];
            for (int j = 0; j < ligne.length; j++){
                Labyrinthe l = ligne[j];
                if (l!=null && l.equals(laby)){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) throws IOException {
        Labyrinthe laby2 = new Labyrinthe("labySimple/laby2.txt");
        Labyrinthe laby3 = new Labyrinthe("labySimple/laby3.txt");
        Labyrinthe laby4 = new Labyrinthe("labySimple/laby4.txt");
        Labyrinthe laby5 = new Labyrinthe("labySimple/laby5.txt");
        Labyrinthe laby6 = new Labyrinthe("labySimple/laby6.txt");
        Labyrinthe labyPresentation = new Labyrinthe("labySimple/labyPresentation.txt");
        labyrinthes = new Labyrinthe[][]{
                {null,null, null, null},
                {null,labyPresentation, null, laby5},
                {laby6,laby2, laby3, laby4},
                {null,null, null, null},
                {null,  null, null, null}};

        afficherLabyrinthe(labyrinthes[labyActuel[0]][labyActuel[1]]);
    }

    // méthodes de test
    public static Labyrinthe getLaby(){
        return labyrinthes[labyActuel[0]][labyActuel[1]];
    }
    public static void setLabyActuel(int[] labyActuel){
        Main.labyActuel = labyActuel;
    }
    public static void setLabyrinthes(Labyrinthe[][] labyrinthes){
        Main.labyrinthes = labyrinthes;
    }
}
