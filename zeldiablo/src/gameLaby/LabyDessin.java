package gameLaby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

public class LabyDessin implements DessinJeu {

    public static int tailleCase = 50;

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
                    gc.fillRect(x*tailleCase, y*tailleCase, tailleCase, tailleCase);
                }
                else if (laby.getPsecret(x,y)!=-1) {
                    if(laby.psecrets.get(laby.getPsecret(x,y)).isActive()){
                        gc.setStroke(Color.BLACK);
                        gc.strokeRect(x*tailleCase, y*tailleCase, tailleCase, tailleCase);
                    } else {
                        gc.setFill(Color.BLACK);
                        gc.fillRect(x*tailleCase,y*tailleCase, tailleCase, tailleCase);
                    }
                } else {
                    gc.setFill(Color.WHITE);
                    gc.fillRect(x*tailleCase,y*tailleCase, tailleCase, tailleCase);
                }



                }
            }


        // dessin entites

        for (int i = 0; i < laby.entites.size(); i++) {
            Entite entite = laby.entites.get(i);
            double px = entite.x;
            double py = entite.y;
            gc.setFill(Color.RED);
            gc.fillOval(px*tailleCase, py*tailleCase, tailleCase, tailleCase);
        }


        // dessin perso
        if (laby.pj.estVivant) {
            gc.setFill(Color.BLUE);
            Perso perso = laby.pj;
            double px = perso.x;
            double py = perso.y;
            gc.fillOval(px * tailleCase, py * tailleCase, tailleCase, tailleCase);
        }
    }
    }

