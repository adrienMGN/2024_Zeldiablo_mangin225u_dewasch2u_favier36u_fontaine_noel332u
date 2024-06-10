import gameLaby.LabyJeu;
import gameLaby.Labyrinthe;
import gameLaby.Monstre;
import gameLaby.Perso;
import javafx.scene.input.KeyEvent;
import moteurJeu.Clavier;
import org.junit.jupiter.api.Test;

import static java.awt.event.KeyEvent.VK_SPACE;
import static javafx.scene.input.KeyCode.SPACE;
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

    @Test
    public void test_attaque_directionnelle_perso_ok() throws Exception{
        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyMouvementMonstre.txt");
        Clavier clavier = new Clavier();
        LabyJeu labyJeu = new LabyJeu(labyrinthe);
        labyrinthe.deplacerPerso(Labyrinthe.BAS);
        labyrinthe.attaqueDirectionnel(Labyrinthe.BAS);

        Monstre m = (Monstre) labyrinthe.entites.get(1);
        Perso pj = (Perso) labyrinthe.entites.get(0);
        int m_pv = m.getPv();
        System.out.println(m_pv);
        labyJeu.update(0,clavier);
        m_pv = m.getPv();
        labyJeu.update(0,clavier);
        System.out.println(m_pv);
        assertEquals(1,m_pv,"le monstre a perdu 1 pv");



    }

    @Test
    public void test_attaque_directionnelle_perso_mauvaise_direction() throws Exception{
        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyMouvementMonstre.txt");
        Clavier clavier = new Clavier();
        LabyJeu labyJeu = new LabyJeu(labyrinthe);

        Monstre m = (Monstre) labyrinthe.entites.get(1);
        Perso pj = (Perso) labyrinthe.entites.get(0);
        int m_pv = m.getPv();
        labyrinthe.deplacerPerso(Labyrinthe.HAUT);
        labyrinthe.attaqueDirectionnel(Labyrinthe.HAUT);
        labyJeu.update(0,clavier);
        m_pv = m.getPv();
        labyJeu.update(0,clavier);
        assertEquals(2,m_pv,"le monstre ne devrait pas perdre de pv");



    }

    @Test
    public void test_game_over() throws Exception{
        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyMouvementMonstre.txt");
        Clavier clavier = new Clavier();
        LabyJeu labyJeu = new LabyJeu(labyrinthe);

        Monstre m = (Monstre) labyrinthe.entites.get(1);
        Perso pj = (Perso) labyrinthe.entites.get(0);
        int pj_pv = pj.getPv();
        System.out.println(pj_pv);
        for (int i = 0; i <5; i++)
        m.attaquer(pj);
        labyJeu.update(10,clavier);
        pj_pv = pj.getPv();
        System.out.println(pj_pv);
        labyJeu.update(0,clavier);
        boolean game_over = labyJeu.etreFini();
        assertTrue(game_over,"le jeu est fini");

    }






}
