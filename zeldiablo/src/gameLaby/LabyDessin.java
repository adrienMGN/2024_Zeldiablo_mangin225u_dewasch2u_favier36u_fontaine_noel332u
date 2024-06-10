package gameLaby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
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


        // dessin entites si vivantes

        for (int i = 0; i < laby.entites.size(); i++) {

            Entite entite = laby.entites.get(i);
            if (entite.etreVivant()) {
                double px = entite.getX();
                double py = entite.getY();
                if (entite instanceof Monstre)
                    gc.setFill(Color.RED);
                else if (entite instanceof Perso)
                    gc.setFill(Color.BLUE);

                gc.fillOval(px * tailleCase, py * tailleCase, tailleCase, tailleCase);
                gc.setFill(Color.BLACK);
                gc.fillText(""+entite.getPv(), px * tailleCase+tailleCase/2, py * tailleCase+tailleCase/2);
                gc.setTextAlign(TextAlignment.CENTER);
            }
        }
        for (int i = 0; i <laby.items.size(); i++) {
            Item item = laby.items.get(i);
            if (!item.inInventaire()) {
                double x = item.getX();
                double y = item.getY();
                if (item instanceof Amulette)
                    gc.setFill(Color.YELLOW);
                gc.fillOval(x * tailleCase, y * tailleCase, tailleCase, tailleCase);
            }
        }
    }
    }

