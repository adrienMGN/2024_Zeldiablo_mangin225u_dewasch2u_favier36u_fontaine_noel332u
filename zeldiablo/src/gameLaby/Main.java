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
    private static Labyrinthe laby2;
    private static Labyrinthe laby3;
    private static int labyActuel = 0;
    private static Labyrinthe[] labyrinthes = {laby2, laby3};



    public static void afficherLabyrinthe(Labyrinthe laby2) {

        int width = 1000;
        int height = 700;
        LabyDessin.tailleCase = Math.min(width/laby2.getLength(), height/laby2.getLengthY());
        int pFPS = 10;



        // creation des objets
        LabyJeu jeuLaby = new LabyJeu(laby2);
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

    public static void changerLaby(int i){
        labyActuel+=i;
        if (labyActuel >= labyrinthes.length){
            labyActuel = 0;
        }
        afficherLabyrinthe(labyrinthes[labyActuel]);
    }

    public static void main(String[] args) throws IOException {
        laby2 = new Labyrinthe("labySimple/laby2.txt");
        laby3 = new Labyrinthe("labySimple/laby3.txt");

        afficherLabyrinthe(labyrinthes[labyActuel]);
    }
}
