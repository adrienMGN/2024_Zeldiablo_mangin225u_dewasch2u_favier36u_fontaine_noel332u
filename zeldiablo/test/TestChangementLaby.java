import gameLaby.laby.LabyJeu;
import gameLaby.laby.Labyrinthe;
import gameLaby.Main;
import moteurJeu.Clavier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestChangementLaby {

    /**
     * Test de changement de Labyrinthe entre niveaux ou salles
     * @throws Exception
     */
    @Test
    public void test_changementLaby() throws Exception {
        Labyrinthe laby = new Labyrinthe("labySimple/labyTest/labyTestChangementLaby.txt");
        Labyrinthe laby2 = new Labyrinthe("labySimple/labyTest/labyTestChangementLaby2.txt");
        LabyJeu labyJeu = new LabyJeu(laby);
        Clavier clavier = new Clavier(); // necessaire pour update
        Main.setLabyActuel(new int[]{0, 0});
        Main.setLabyrinthes(new Labyrinthe[][]{{laby, laby2}});
        Main.changerLaby(laby, Labyrinthe.DROITE); // change de labyrinthe
        //vérif que le labyrinthe a bien changé;
        assertEquals(Main.getLaby(), laby2, "Le labyrinthe n'a pas changé");
    }
}
