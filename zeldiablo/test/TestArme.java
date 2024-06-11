import gameLaby.entites.Monstre;
import gameLaby.entites.Perso;
import gameLaby.laby.LabyJeu;
import gameLaby.laby.Labyrinthe;
import gameLaby.objets.Epee;
import moteurJeu.Clavier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestArme {
    @Test
    public void test_arme() throws Exception {
        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyEpee.txt");
        LabyJeu labyJeu = new LabyJeu(labyrinthe);
        Clavier clavier = new Clavier();
        Perso pj = labyrinthe.getPerso();
        Monstre m = (Monstre)labyrinthe.entites.get(1);
        Epee epee = (Epee)labyrinthe.items.get(0);
        labyrinthe.deplacerPerso(Labyrinthe.BAS);
        epee.ramasserItem();
        boolean possede = pj.getInventaire().get(0) == epee;
        assertTrue(possede, "Le personnage devrait avoir une épée");
        labyJeu.update(0,clavier);
        pj.attaquer(m);
        assertFalse(m.etreVivant(), "le monstre aurait du être tué en un coup");

    }

}
