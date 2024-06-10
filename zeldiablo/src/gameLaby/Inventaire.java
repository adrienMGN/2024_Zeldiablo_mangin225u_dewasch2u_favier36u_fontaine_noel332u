package gameLaby;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import moteurJeu.Clavier;

import java.util.ArrayList;

public class Inventaire extends Application {

    final Color gris = Color.rgb(180,180,180);
    ArrayList<Rectangle> grille = new ArrayList<>();
    ArrayList<ImageView> inv = new ArrayList<>();

    private Labyrinthe laby;
    Perso pj = laby.getPerso();

    @Override
    public void start(Stage stage){

        GridPane root = new GridPane();
        root.setPadding(new Insets(5));
        root.setBackground(new Background(new BackgroundFill(Color.rgb(128,128,128), new CornerRadii(0), null)));

        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 5; j++) {

                Rectangle r = createRectangle();
                StackPane spane = new StackPane();

                /*Image image =
                ImageView imageView = ajouterItem(image);

                spane.getChildren().addAll(r, imageView);
                grille.add(r);
                inv.add(imageView);*/
                root.add(r, i, j);
                root.add(spane, 0, 0);

            }
        }

        Scene scene = new Scene(root);
        stage.setTitle("Inventaire");
        stage.setScene(scene);
        stage.show();

    }

    public ImageView ajouterItem(Image image){

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(32);
        imageView.setFitHeight(32);

        return imageView;

    }

    private Rectangle createRectangle(){

        Rectangle r = new Rectangle(40,40);
        r.setFill(gris);
        r.setStrokeWidth(1);
        r.setStroke(Color.rgb(70,70,70));

        r.setOnMouseEntered(event -> {
            r.setFill(Color.rgb(210,210,210));
        });

        r.setOnMouseExited(event -> {
            r.setFill(gris);
        });

        return r;
    }

}
