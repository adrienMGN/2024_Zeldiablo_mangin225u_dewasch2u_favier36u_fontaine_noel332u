package gameLaby.laby;

import gameArkanoid.ArkanoidJeu;
import gameArkanoid.Balle;
import gameArkanoid.Raquette;
import gameLaby.laby.Perso;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

public class LabyDessin implements DessinJeu {

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {

        LabyJeu jeuLaby = (LabyJeu) jeu;
        Labyrinthe laby = jeuLaby.getLaby();

        // recupere un pinceau pour dessiner
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        // dessin fond
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());


        // dessin mur

        for (int y = 0; y < laby.getLengthY(); y++) {
            // affiche la ligne
            for (int x = 0; x < laby.getLength(); x++) {
                if (laby.getMur(x, y)){
                    gc.setFill(Color.BLACK);
                    gc.fillRect(x*100, y*100, 100, 100);
                }
                else {
                    gc.setFill(Color.WHITE);
                    gc.fillRect(x*100,y*100, 100, 100);
                }
            }
        }


        // dessin perso
        gc.setFill(Color.RED);
        Perso perso = laby.pj;
        double px = perso.getX();
        double py = perso.getY();
        gc.fillOval(px*100, py*100, 100, 100);

    }
    }

