package gameLaby.laby;

import gameLaby.entites.Entite;
import gameLaby.entites.Fantome;
import gameLaby.entites.Monstre;
import gameLaby.entites.Perso;
import gameLaby.objets.Amulette;
import gameLaby.objets.Cle;
import gameLaby.objets.Item;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import java.util.ArrayList;

public class LabyDessin implements DessinJeu {

    public static int tailleCase = 50;
    static Image amulette = new Image("file:imgs/colieror.png");
    static Image cle = new Image("file:imgs/cle.png");
    static Image fantome = new Image("file:imgs/fantome.png");
    static Image monstre = new Image("file:imgs/monstre.png");
    static Image perso = new Image("file:imgs/perso.png");
    static Image coffre = new Image("file:imgs/coffre.png");
    static Image porte = new Image("file:imgs/porte.png");
    static Image mur = new Image("file:imgs/murs.png");
    static Image fleche = new Image("file:img/fleche.png");

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
                    gc.drawImage(mur,x*tailleCase, y*tailleCase, tailleCase, tailleCase);
                }
                else if (laby.getPsecret(x,y)!=-1) {
                    if(laby.psecrets.get(laby.getPsecret(x,y)).isActive()){
                        gc.setStroke(Color.BLACK);
                        gc.strokeRect(x*tailleCase, y*tailleCase, tailleCase, tailleCase);
                    }
                }
                else if (laby.getCoffre(x,y)!=-1){
                    if(laby.coffres.get(laby.getCoffre(x,y)).isActif()){
                        gc.drawImage(coffre, x*tailleCase, y*tailleCase, tailleCase, tailleCase);
                    }
                    else {
                        gc.setFill(Color.WHITE);
                        gc.fillRect(x*tailleCase, y*tailleCase, tailleCase, tailleCase);
                    }
                }
                else {
                    gc.setFill(Color.WHITE);
                    gc.fillRect(x*tailleCase,y*tailleCase, tailleCase, tailleCase);
                }



                }
            }

        if(laby.getSortie()!=null){
            gc.drawImage(porte,laby.getSortie().getX()*tailleCase,laby.getSortie().getY()*tailleCase, tailleCase, tailleCase);
        }
        // dessin entites si vivantes

        for (int i = 0; i < laby.entites.size(); i++) {

            Entite entite = laby.entites.get(i);
            if (entite.etreVivant()) {
                double px = entite.getX();
                double py = entite.getY();
                if (entite instanceof Fantome) {
                    gc.drawImage(fantome,px*tailleCase, py*tailleCase, tailleCase, tailleCase);
                }
                else if (entite instanceof Monstre) {
                    gc.drawImage(monstre,px*tailleCase-tailleCase/9, py*tailleCase, tailleCase+tailleCase/9, tailleCase);
                }
                else if (entite instanceof Perso) {
                    gc.drawImage(perso, px*tailleCase+tailleCase/8, py*tailleCase, tailleCase-tailleCase/4, tailleCase);

                }

                gc.setFill(Color.BLACK);
                gc.setFont(Font.font("Comic Sans MS", 20));
                gc.fillText(""+entite.getPv(), px * tailleCase+tailleCase/2, py * tailleCase-5);
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
                    gc.drawImage(cle,x*tailleCase+tailleCase/7,y*tailleCase, tailleCase-tailleCase/3, tailleCase);
            }
        }



            gc.setFill(Color.LIGHTGRAY);
            gc.clearRect(5,5,240,40);
            gc.setStroke(Color.rgb(140,140,140));
            for(int i = 0; i < 6; i++) {
                gc.strokeRect(i*40+5,5,40,40);

                if (laby.getPerso().getInventaire().size() > i) {
                    Item item = laby.getPerso().getInventaire().get(i);
                    if (item != null) {
                        if (item instanceof Amulette) {
                            gc.drawImage(amulette, i * 40 + 5, 5, 40, 40);
                        }
                        if (item instanceof Cle){
                            gc.drawImage(cle,i * 40 + 11,5,28,40);
                        }
                    }
                }
            }
    }
}

