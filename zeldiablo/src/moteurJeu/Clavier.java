package moteurJeu;

import javafx.scene.input.KeyEvent;

public class Clavier {

    /**
     * controle appuyes
     */
    public boolean haut, bas, gauche, droite, space, i;

    /**
     * stocke les commandes
     *
     * @param event evenement clavier
     */
    public void appuyerTouche(KeyEvent event) {

        switch (event.getCode()) {

            // si touche bas
            case S:
            case DOWN:
                this.bas = true;
                break;

            // si touche haut
            case Z:
            case UP:
                this.haut = true;
                break;

            // si touche gauche
            case Q:
            case LEFT:
                this.gauche = true;
                break;

            // si touche droite
            case D:
            case RIGHT:
                this.droite = true;
                break;
            case SPACE:
                this.space = true;
                break;


            case I:
                this.i = true;
                break;
        }

    }

    /**
     * stocke les commandes
     *
     * @param event evenement clavier
     */
    public void relacherTouche(KeyEvent event) {

        switch (event.getCode()) {

            // si touche bas
            case S:
            case DOWN:
                this.bas = false;
                break;

            // si touche haut
            case Z:
            case UP:
                this.haut = false;
                break;

            // si touche gauche
            case Q:
            case LEFT:
                this.gauche = false;
                break;

            // si touche droite
            case D:
            case RIGHT:
                this.droite = false;
                break;
            case SPACE:
                this.space = false;
                break;

        }
    }
}
