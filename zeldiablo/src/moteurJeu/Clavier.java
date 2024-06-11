package moteurJeu;

import javafx.scene.input.KeyEvent;

public class Clavier {

    /**
     * controle appuyes
     */
    public boolean haut, bas, gauche, droite, space, e, f;

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
            // gestion attaque avec SPACE
            case SPACE:
                this.space = true;
                break;
            case E:
                this.e = true;
                break;
            case F:
                this.f = true;
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
            case E:
                this.e = false;
                break;
            case F:
                this.f = false;
                break;
        }
    }
}
