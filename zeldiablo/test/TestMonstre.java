import gameLaby.entites.Fantome;
import gameLaby.entites.Monstre;
import gameLaby.entites.Perso;
import gameLaby.laby.LabyJeu;
import gameLaby.laby.Labyrinthe;
import moteurJeu.Clavier;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestMonstre {

    /**
     * Test d'ajout d'un monstre qui se fait attaquer
     * @throws Exception
     */
    @Test
    public void test_ajout_monstre_attaque() throws Exception{
        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyMonstre.txt");
        Clavier clavier = new Clavier();
        LabyJeu labyJeu = new LabyJeu(labyrinthe);
        Perso pj = (Perso) labyrinthe.entites.get(0);
        Monstre m= new Monstre(1,1, 10, labyrinthe);
        labyrinthe.ajouterEntite(m);
        m.attaquer(pj);
        assertTrue( m.etrePresent(1,1),"le monstre devrait être présent en 1,1");


        Monstre m2 = (Monstre)labyrinthe.entites.get(1);
        assertTrue( m2.etrePresent(3,3),"le monstre devrait être présent en 2,2");

        pj.attaquer(m);
        assertEquals(9, m.getPv() , "le monstre devrait avoir 9 pv");
    }

    /**
     * Test déplacement du monstre en direction du personnage
     * @throws Exception
     */
    @Test
    public void test_mouvement_monstre() throws Exception{

        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyMonstre.txt");
        Clavier clavier = new Clavier();
        LabyJeu labyJeu = new LabyJeu(labyrinthe);

        //System.out.println(labyrinthe.entites.size());
        //System.out.println((labyrinthe.entites.get(1)).getClass().getName());

        //labyrinthe.mouvementsMonstres();
        Monstre m = (Monstre) labyrinthe.entites.get(1);

        labyrinthe.mouvementsMonstres();


        assertTrue(m.etrePresent(3,2),"le monstre devrait être en 3,2");



    }

    /**
     * Test de déplacement intelligent des monstre(s'ils ne foncent pas dans les murs et les esquivent).
     * @throws Exception
     */
    @Test
    public void test_mouvement_monstre_intelligent() throws Exception{

        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyMouvementMonstreIntelligent.txt");
        Clavier clavier = new Clavier();
        LabyJeu labyJeu = new LabyJeu(labyrinthe);

        //System.out.println(labyrinthe.entites.size());
        Monstre m = (Monstre) labyrinthe.entites.get(1);

        labyrinthe.mouvementsMonstres();
        //le monstre contourne un obstacle
        assertTrue(m.etrePresent(3,3),"le monstre devrait être en 3,3");

        labyrinthe.mouvementsMonstres();

        assertTrue(m.etrePresent(3,2),"le monstre devrait être en 3,2");

        labyrinthe.mouvementsMonstres();

        assertTrue(m.etrePresent(3,1),"le monstre devrait être en 3,1");

        labyrinthe.mouvementsMonstres();

        assertTrue(m.etrePresent(2,1),"le monstre devrait être en 2,1");

    }

    /**
     * Test des fantomes s'ils passent au travers des murs
     * @throws IOException
     */
    @Test
    public void test_monstre() throws IOException {
        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyFantome.txt");
        Clavier clavier = new Clavier();
        Fantome m = (Fantome) labyrinthe.entites.get(0);
        LabyJeu labyJeu = new LabyJeu(labyrinthe);
        labyrinthe.mouvementsMonstres();
        assertTrue(m.etrePresent(2,1),"le monstre devrait être présent en 1,2");
    }



}
