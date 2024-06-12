package gameLaby.laby;

import gameLaby.entites.Entite;
import gameLaby.entites.Fantome;
import gameLaby.entites.Monstre;
import gameLaby.entites.Perso;
import gameLaby.objets.*;
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

/**
 * Classe permettant de dessiner le jeu
 */
public class LabyDessin implements DessinJeu {

    public static int tailleCase = 50;

    /**
     * @param jeu    jeu a afficher
     * @param canvas canvas dans lequel dessiner l'etat du jeu
     */
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {

        // definition des images pour chaques objets ayant un sprite
        Image amulette = new Image("file:imgs/colieror.png");
        Image cle = new Image("file:imgs/cle.png");
        Image fantome = new Image("file:imgs/fantome.png");
        Image monstre = new Image("file:imgs/monstre.png");
        Image porte = new Image("file:imgs/porte.png");
        Image perso = new Image("file:imgs/perso.png");
        Image coffre = new Image("file:imgs/coffre.png");
        Image fleche = new Image("file:imgs/fleche.png");
        Image epee = new Image("file:imgs/epee.png");
        Image arc = new Image("file:imgs/arc.png");

        // recupere le labyrinthe
        LabyJeu jeuLaby = (LabyJeu) jeu;
        Labyrinthe laby = jeuLaby.getLaby();

        // recupere un pinceau pour dessiner
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        // dessin fond
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());


        // dessin des murs et des objets pouvant disparaitre (passages secrets et coffres)

        for (int y = 0; y < laby.getLengthY(); y++) {
            for (int x = 0; x < laby.getLength(); x++) {
                // dessin des murs
                if (laby.getMur(x, y)){
                    gc.setFill(Color.BROWN);
                    gc.fillRect(x*tailleCase, y*tailleCase, tailleCase, tailleCase);
                }
                // dessin des passages secrets quand ils sont ouverts
                else if (laby.getPsecret(x,y)!=-1) {
                    if(laby.psecrets.get(laby.getPsecret(x,y)).isActive()){
                        gc.setStroke(Color.BLACK);
                        gc.setFill(Color.WHITE);
                        gc.fillRect(x*tailleCase, y*tailleCase, tailleCase, tailleCase);
                    }
                    else {
                        gc.setFill(Color.BROWN);
                        gc.fillRect(x*tailleCase, y*tailleCase, tailleCase, tailleCase);
                    }
                }
                // dessin des coffres
                else if (laby.getCoffre(x,y)!=-1){
                    if(laby.coffres.get(laby.getCoffre(x,y)).isActif()){
                        gc.drawImage(coffre, x*tailleCase, y*tailleCase, tailleCase, tailleCase);
                    }
                    else {
                        gc.setFill(Color.WHITE);
                        gc.fillRect(x*tailleCase, y*tailleCase, tailleCase, tailleCase);
                    }
                }
                // dessin des cases vides (air)
                else {
                    gc.setFill(Color.WHITE);
                    gc.fillRect(x*tailleCase,y*tailleCase, tailleCase, tailleCase);
                }
            }
        }

        // si il y a une sortie dans ce labyrinthe
        if(laby.getSortie()!=null){
            // on la dessine
            gc.drawImage(porte,laby.getSortie().getX()*tailleCase,laby.getSortie().getY()*tailleCase, tailleCase, tailleCase);
        }


        // dessin entites
        for (int i = 0; i < laby.entites.size(); i++) {
            // on parcourt toutes les entites du labyrinthe
            Entite entite = laby.entites.get(i);
            // si l'entite est vivante
            if (entite.etreVivant()) {
                double px = entite.getX();
                double py = entite.getY();
                // on l'affiche en fonction de son type
                if (entite instanceof Fantome) {
                    gc.drawImage(fantome,px*tailleCase, py*tailleCase, tailleCase, tailleCase);
                }
                else if (entite instanceof Monstre) {
                    gc.drawImage(monstre,px*tailleCase-tailleCase/9, py*tailleCase, tailleCase+tailleCase/9, tailleCase);
                }
                else if (entite instanceof Perso) {
                    gc.drawImage(perso, px*tailleCase+tailleCase/8, py*tailleCase, tailleCase-tailleCase/4, tailleCase);
                }
                // on affiche ses pvs au dessus de lui
                gc.setFill(Color.BLACK);
                gc.setFont(Font.font("Comic Sans MS", 20));
                gc.fillText(""+entite.getPv(), px * tailleCase+tailleCase/2, py * tailleCase-5);
                gc.setTextAlign(TextAlignment.CENTER);
            }
        }

        // dessin des items
        for (int i = 0; i <laby.items.size(); i++) {
            // on parcourt tous les items du labyrinthe
            Item item = laby.items.get(i);
                double x = item.getX();
                double y = item.getY();
                // on les affiche en fonction de leur type
                if (item instanceof Amulette)
                    gc.drawImage(amulette,x*tailleCase,y*tailleCase);
                if (item instanceof Cle)
                    gc.drawImage(cle,x*tailleCase+tailleCase/7,y*tailleCase, tailleCase-tailleCase/3, tailleCase);
                if (item instanceof Epee)
                    gc.drawImage(epee,x*tailleCase+tailleCase/7,y*tailleCase, tailleCase-tailleCase/3, tailleCase);
                if (item instanceof Arc)
                    gc.drawImage(arc,x*tailleCase+tailleCase/7,y*tailleCase, tailleCase-tailleCase/3, tailleCase);
        }


        // dessin inventaire du perso
        gc.setFill(Color.LIGHTGRAY);
        gc.clearRect(5,5,240,40);
        gc.setStroke(Color.rgb(140,140,140));

        // on affiche 6 cases de l'inventaire
        for(int i = 0; i < 6; i++) {
            gc.strokeRect(i*40+5,5,40,40);

            // si l'inventaire a un item a cet emplacement
            if (laby.getPerso().getInventaire().size() > i) {
                // on recupere l'item a cet emplacement
                Item item = laby.getPerso().getInventaire().get(i);
                // on l'affiche en fonction de son type
                if (item instanceof Amulette) {
                    gc.drawImage(amulette, i * 40 + 5, 5, 40, 40);
                }
                if (item instanceof Cle){
                    gc.drawImage(cle,i * 40 + 11,5,28,40);
                }
                if (item instanceof Epee){
                    gc.drawImage(epee,i * 40 + 11,5,28,40);
                }
                if (item instanceof Arc){
                    // pour un arc, on affiche aussi le nombre de fleches restantes
                    gc.drawImage(arc,i * 40 + 11,5,28,40);
                    gc.setFill(Color.BLACK);
                    gc.setFont(Font.font("Comic Sans MS", 20));
                    gc.fillText(""+((Arc) item).getNbFleches(), i*40+37, 43);
                    gc.setTextAlign(TextAlignment.CENTER);

                    // on dessine les fleches de l'arc a leur endroit sur le terrain
                    ArrayList<Fleche> fleches = ((Arc) item).getFleches();
                    for(Fleche f : fleches){
                        gc.drawImage(fleche,f.getX()*tailleCase,f.getY()*tailleCase, tailleCase-tailleCase/3, tailleCase);
                    }
                }
            }
        }
    }
}

