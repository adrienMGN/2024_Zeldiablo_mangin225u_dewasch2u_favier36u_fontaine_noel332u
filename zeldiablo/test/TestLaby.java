import gameLaby.Labyrinthe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLaby {


    @Test
    public void test_deplacerPerso() throws Exception{
        Labyrinthe labyrinthe = new Labyrinthe("labySimple/laby0.txt");

        assertArrayEquals(labyrinthe.getPersonnage(),new int[]{2,3},"mauvais positionnement du personnage");

        labyrinthe.deplacerPerso(Labyrinthe.HAUT);
        assertArrayEquals(labyrinthe.getPersonnage(),new int[]{1,3},"mauvais deplacement vers le haut");

        labyrinthe.deplacerPerso(Labyrinthe.BAS);
        assertArrayEquals(labyrinthe.getPersonnage(),new int[]{2,3},"mauvais deplacement vers le bas");

        labyrinthe.deplacerPerso(Labyrinthe.GAUCHE);
        assertArrayEquals(labyrinthe.getPersonnage(),new int[]{2,2},"mauvais deplacement vers la gauche");

        labyrinthe.deplacerPerso(Labyrinthe.DROITE);
        assertArrayEquals(labyrinthe.getPersonnage(),new int[]{2,3},"mauvais deplacement vers la droite");

        for (int i = 0; i <3; i++) {
            labyrinthe.deplacerPerso(Labyrinthe.DROITE);
        }
        assertArrayEquals(labyrinthe.getPersonnage(),new int[]{2,5},"le personnage traverse le mur");

        for (int i = 0; i <2; i++) {
            labyrinthe.deplacerPerso(Labyrinthe.BAS);
        }
        assertArrayEquals(labyrinthe.getPersonnage(),new int[]{3,5},"le personnage traverse le mur");

        for (int i = 0; i <5; i++) {
            labyrinthe.deplacerPerso(Labyrinthe.GAUCHE);
        }
        assertArrayEquals(labyrinthe.getPersonnage(),new int[]{3,1},"le personnage traverse le mur");

        for (int i = 0; i <3; i++) {
            labyrinthe.deplacerPerso(Labyrinthe.HAUT);
        }
        assertArrayEquals(labyrinthe.getPersonnage(),new int[]{1,1},"le personnage traverse le mur");
    }

}
