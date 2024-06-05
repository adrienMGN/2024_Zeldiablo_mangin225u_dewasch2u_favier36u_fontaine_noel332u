import gameLaby.LabyJeu;
import gameLaby.Labyrinthe;
import gameLaby.Ouverture;
import moteurJeu.Clavier;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFermeture {

    @Test
    public void test_fermeture1passage() throws Exception {

        Labyrinthe laby = new Labyrinthe("labySimple/labyTestFermeture.txt");

        LabyJeu labyJeu = new LabyJeu(laby);

        laby.deplacerPerso(Labyrinthe.GAUCHE); // deplace gauche atteint ouverture
        Clavier clavier = new Clavier(); // necessaire pour update
        labyJeu.update(0, clavier); // màj de l'état du jeu'

        laby.deplacerPerso(Labyrinthe.DROITE);
        laby.deplacerPerso(Labyrinthe.DROITE);
        labyJeu.update(0, clavier);

        boolean active = laby.psecrets.get(0).isActive(); // recupère l'état du passage secret

        assertEquals(false, active, "Le passage secret est censé être fermé.");

        laby.deplacerPerso(Labyrinthe.GAUCHE);

    }

}
