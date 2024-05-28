package gameLaby.laby;

import java.io.IOException;

import gameArkanoid.ArkanoidDessin;
import gameArkanoid.ArkanoidJeu;
import moteurJeu.MoteurJeu;

/**
 * charge et affiche un labyrinthe
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int width = 800;
        int height = 600;
        int pFPS = 100;

        // creation des objets
        LabyJeu jeuLaby = new LabyJeu();
        LabyDessin dessinLaby = new LabyDessin();

        // parametrage du moteur de jeu
        MoteurJeu.setTaille(width,height);
        MoteurJeu.setFPS(pFPS);

        // lancement du jeu
        MoteurJeu.launch(jeuLaby, dessinLaby);

        // charge le labyrinthe
        Labyrinthe laby = new Labyrinthe("labySimple/laby1.txt");

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
    }
}
