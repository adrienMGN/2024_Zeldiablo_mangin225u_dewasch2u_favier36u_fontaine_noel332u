/* (modif julien)
package gameLaby;
import javafx.scene.control.Menu;
import moteurJeu.Clavier;
import moteurJeu.Jeu;


public class LabyMenu extends Menu {


    public int update_menu(double secondes, Clavier clavier){
        int retour = 0;
        if (clavier.escape){
            retour = 1;
        }

        else if (clavier.enter){
            retour = 2 ;
        }
        return retour;
    }

    public void init() {
    }

    public boolean etreFini(){
        return laby.etreFini();
    }

    public Labyrinthe getLaby() {
        return laby;
    }
}
*/