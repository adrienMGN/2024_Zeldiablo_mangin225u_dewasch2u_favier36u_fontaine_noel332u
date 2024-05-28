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
        gc.setFill(Color.BLACK);
        Raquette raquette = arkanoid.getRaquette();
        double px = raquette.getPx() - Raquette.RAQUETTE_TAILLE / 2;
        double py = raquette.getPy();
        gc.fillRect(px, py, Raquette.RAQUETTE_TAILLE, 10);

        // dessin balle
        gc.setFill(Color.RED);
        Perso perso = jeu.getPerso();
        double px = perso.getX();
        double py = balle.getY();
        gc.fillOval(bx - 5, by - 5, 10, 10);



        // dessin balle
        gc.setFill(Color.RED);
        Balle balle = arkanoid.getBalle();
        double bx = balle.getPx();
        double by = balle.getPy();
        gc.fillOval(bx - 5, by - 5, 10, 10);

    }
    }
}
