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

        Monstre monstre = new Monstre(8,8, 5, laby);
        laby.ajouterEntite(monstre);

        // setInterval()
        new Timer().scheduleAtFixedRate(new TimerTask(){
            public void run(){
                laby.mouvementsMonstres();
            }
        },0,100);

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

        int width = laby.getLength()*LabyDessin.tailleCase;
        int height = laby.getLengthY()*LabyDessin.tailleCase;
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
