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


        // recupere un pinceau pour dessiner
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        // dessin fond
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // dessin perso
        gc.setFill(Color.RED);
        Perso perso = ((Labyrinthe) jeu).pj;
        double px = perso.getX();
        double py = perso.getY();
        gc.fillRect(px, py, , 10);

        // dessin mur
        gc.setFill(Color.BLACK);
        boolean[][] mur = ((Labyrinthe) jeu).MUR;
        double px = perso.getX();
        double py = perso.getY();
        gc.fillRect(px, py, , 10);

    }
    }
}
