import gameLaby.laby.LabyJeu;
import gameLaby.laby.Labyrinthe;
import gameLaby.entites.Monstre;
import gameLaby.entites.Perso;
import moteurJeu.Clavier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLaby {


    /**
     * Test de déplacement du perso avec les touches clavier et s'il ne traverse pas les murs
     * @throws Exception
     */
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

    /**
     * test de l'attaque en fonction de la direction du personnage
     * @throws Exception
     */
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
        m_pv = m.getPv();
        System.out.println(m_pv);
        assertEquals(1,m_pv,"le monstre a perdu 1 pv");



    }

    /**
     * Test de l'attaque directionnelle dans la mauvaise direction
     * @throws Exception
     */
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
        m_pv = m.getPv();
        assertEquals(2,m_pv,"le monstre ne devrait pas perdre de pv");



    }

    /**
     * Test de mort du personnage attaqué par un monstre, fermeture du jeu causée par la mort du personnage
     * @throws Exception
     */
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
        pj_pv = pj.getPv();
        System.out.println(pj_pv);
        boolean game_over = labyJeu.etreFini();
        assertTrue(game_over,"le jeu est fini");

    }






}
