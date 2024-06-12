import gameLaby.Main;
import gameLaby.entites.Monstre;
import gameLaby.entites.Perso;
import gameLaby.laby.LabyJeu;
import gameLaby.laby.Labyrinthe;
import gameLaby.objets.Arc;
import gameLaby.objets.Epee;
import moteurJeu.Clavier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestArme {
    /**
     * Test de présence de l'épée dans l'inventaire quand rammassée et si l'épée tue en un seul coup les monstres
     * @throws Exception
     */
    @Test
    public void test_arme_epee() throws Exception {
        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyEpee.txt");
        Perso pj = labyrinthe.getPerso();
        Monstre m = (Monstre)labyrinthe.entites.get(1);
        Epee epee = (Epee)labyrinthe.items.get(0);
        labyrinthe.deplacerPerso(Labyrinthe.BAS);
        pj.ajouterInventaire(epee);
        boolean possede = pj.getInventaire().get(0) == epee;
        assertTrue(possede, "Le personnage devrait avoir une épée");
        pj.attaquer(m);
        assertFalse(m.etreVivant(), "le monstre aurait du être tué en un coup");
    }

    /**
     * Test de présence de l'arc dans l'inventaire quand rammassé et s'il tue les monstres en un seul coup
     * @throws Exception
     */
    @Test
    public void test_arme_arc() throws Exception {
        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyTestArc.txt");
        Main.setLabyrinthes(new Labyrinthe[][]{{labyrinthe}});
        Main.setLabyActuel(new int[]{0, 0});
        Perso pj = labyrinthe.getPerso();
        Monstre m = (Monstre)labyrinthe.entites.get(1);
        Arc arc = (Arc)labyrinthe.items.get(0);
        labyrinthe.deplacerPerso(Labyrinthe.BAS);
        pj.ajouterInventaire(arc);
        boolean possede = pj.getInventaire().get(0) == arc;
        assertTrue(possede, "Le personnage devrait avoir une arc");
        arc.tirerFleche(Labyrinthe.BAS);
        assertTrue(m.etreVivant(), "le monstre ne doit pas encore avoir prit de dégats");
        arc.avancerFleches();
        arc.avancerFleches();
        assertFalse(m.etreVivant(), "le monstre aurait du être tué en un coup");
    }
}
