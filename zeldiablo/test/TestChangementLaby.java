import gameLaby.laby.LabyJeu;
import gameLaby.laby.Labyrinthe;
import gameLaby.Main;
import moteurJeu.Clavier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestChangementLaby {

    @Test
    public void test_changementLaby() throws Exception {


        Labyrinthe laby = new Labyrinthe("labySimple/labyTest/labyTestChangementLaby.txt");
        Labyrinthe laby2 = new Labyrinthe("labySimple/labyTest/labyTestChangementLaby2.txt");
        LabyJeu labyJeu = new LabyJeu(laby);
        Clavier clavier = new Clavier(); // necessaire pour update
        Main.setLabyActuel(new int[]{0, 0});
        Main.setLabyrinthes(new Labyrinthe[][]{{laby, laby2}});
        Main.changerLaby(laby, Labyrinthe.DROITE); // change de labyrinthe
//        laby.deplacerPerso(Labyrinthe.DROITE); // deplace droite atteint bordure
//        labyJeu.update(0, clavier); // màj de l'état du jeu'
//
//        laby.deplacerPerso(Labyrinthe.DROITE); // deplace droite dépasse bordure
//        labyJeu.update(0, clavier); // màj de l'état du jeu'
//        laby.getLengthY();
//        laby.getLength();i
        //vérif que le labyrinthe a bien changé;
        assertEquals(Main.getLaby(), laby2, "Le labyrinthe n'a pas changé");
    }
}
