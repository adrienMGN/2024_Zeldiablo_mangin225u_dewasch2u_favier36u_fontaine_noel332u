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
    public static void main(String[] args) throws IOException {
        

        // charge le labyrinthe
        Labyrinthe laby = new Labyrinthe("labySimple/laby2.txt");

        //affiche le labyrinthe charge
        for (int y = 0; y < laby.getLengthY(); y++) {
            // affiche la ligne
            for (int x = 0; x < laby.getLength(); x++) {
                if (laby.getMur(x, y))
                    System.out.print('X');
                else
                    System.out.print('.');
            }
            // saut de ligne
            System.out.println();
        }

        int width = 1000;
                //laby.getLength()*LabyDessin.tailleCase;
        int height = 700;
                //laby.getLengthY()*LabyDessin.tailleCase;
        LabyDessin.tailleCase = Math.min(width/laby.getLength(), height/laby.getLengthY());
        int pFPS = 10;



        // creation des objets
        LabyJeu jeuLaby = new LabyJeu(laby);
        LabyDessin dessinLaby = new LabyDessin();

        // parametrage du moteur de jeu
        MoteurJeu.setTaille(width,height);
        MoteurJeu.setFPS(pFPS);


        // lancement du jeu
        MoteurJeu.launch(jeuLaby, dessinLaby);



    }
}
