package gameLaby;

import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import moteurJeu.MoteurJeu;

/**
 * charge et affiche un labyrinthe
 */
public class Main {

    // charge les labyrinthes
    private static int[] labyActuel = {2,0};
    private static Labyrinthe[][] labyrinthes;


    /**
     * charge les labyrinthes
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

    public static void changerLaby(String direction){
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
        afficherLabyrinthe(labyrinthes[labyActuel[0]][labyActuel[1]]);
    }

    public static void main(String[] args) throws IOException {
        Labyrinthe laby2 = new Labyrinthe("labySimple/laby2.txt");
        Labyrinthe laby3 = new Labyrinthe("labySimple/laby3.txt");
        Labyrinthe laby4 = new Labyrinthe("labySimple/laby4.txt");
        Labyrinthe laby5 = new Labyrinthe("labySimple/laby5.txt");
        labyrinthes = new Labyrinthe[][]{
                {null, null, null},
                {null, null, laby5},
                {laby2, laby3, laby4},
                {null, null, null},
                {null, null, null}};

        afficherLabyrinthe(labyrinthes[labyActuel[0]][labyActuel[1]]);
    }
}
