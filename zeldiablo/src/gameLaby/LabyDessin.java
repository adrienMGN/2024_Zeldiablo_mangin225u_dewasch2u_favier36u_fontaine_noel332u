package gameLaby;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import java.util.ArrayList;

public class LabyDessin implements DessinJeu {

    public static int tailleCase = 50;

    final Color gris = Color.rgb(180,180,180);
    ArrayList<Rectangle> grille = new ArrayList<>();
    ArrayList<ImageView> inv = new ArrayList<>();

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        Image amulette = new Image("file:labySimple/imgs/colieror.png");
        Image cle = new Image("file:labySimple/imgs/cle.png");

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
                }
                else {
                    gc.setFill(Color.WHITE);
                    gc.fillRect(x*tailleCase,y*tailleCase, tailleCase, tailleCase);
                }



                }
            }

        if(laby.getSortie()!=null){
            gc.setFill(Color.GREEN);
            gc.fillRect(laby.getSortie().getX()*tailleCase,laby.getSortie().getY()*tailleCase, tailleCase, tailleCase);
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
                    gc.drawImage(amulette,x*tailleCase,y*tailleCase);
                if (item instanceof Cle)
                    gc.drawImage(amulette,x*tailleCase,y*tailleCase);
            }
        }



            gc.setFill(Color.LIGHTGRAY);
            gc.clearRect(5,5,240,40);
            gc.setStroke(Color.rgb(140,140,140));
            for(int i = 0; i < 6; i++) {
                gc.strokeRect(i*40+5,5,40,40);

                if (laby.getPerso().inventaire.size() > i) {
                    Item item = laby.getPerso().inventaire.get(i);
                    if (item != null) {
                        if (item instanceof Amulette) {
                            gc.drawImage(amulette, i * 40 + 5, 5, 40, 40);
                        }
                        if (item instanceof Cle){
                            gc.drawImage(cle,i * 40 + 5,5,40,40);
                        }
                    }
                }
            }
    }
}

