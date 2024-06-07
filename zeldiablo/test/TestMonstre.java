import gameLaby.LabyJeu;
import gameLaby.Labyrinthe;
import gameLaby.Monstre;
import gameLaby.Perso;
import moteurJeu.Clavier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMonstre {

    @Test

    /*
     * test ajout d'un monstre par une méthode*/
    public void test_ajout_monstre_attaque() throws Exception{
        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyMonstre.txt");
        Clavier clavier = new Clavier();
        LabyJeu labyJeu = new LabyJeu(labyrinthe);
        Perso pj = (Perso) labyrinthe.entites.get(0);
        Monstre m= new Monstre(1,1, 10, labyrinthe);
        labyrinthe.ajouterEntite(m);
        m.attaquer(pj);
        labyJeu.update(2, clavier);
        assertTrue( m.etrePresent(1,1),"le monstre devrait être présent en 1,1");


        Monstre m2 = (Monstre)labyrinthe.entites.get(1);
        assertTrue( m2.etrePresent(3,3),"le monstre devrait être présent en 2,2");

        assertEquals(9, pj.getPv() , "le monstre devrait avoir 9 pv");
    }

    @Test
    /*test mouvement d'un monstre vers perso*/
    public void test_mouvement_monstre() throws Exception{

        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyMonstre.txt");
        Clavier clavier = new Clavier();
        LabyJeu labyJeu = new LabyJeu(labyrinthe);
        labyJeu.update(0, clavier);

        //System.out.println(labyrinthe.entites.size());
        //System.out.println((labyrinthe.entites.get(1)).getClass().getName());

        //labyrinthe.mouvementsMonstres();
        Monstre m = (Monstre) labyrinthe.entites.get(1);

        labyrinthe.mouvementsMonstres();
        labyJeu.update(0, clavier);


        assertTrue(m.etrePresent(3,2),"le monstre devrait être en 3,2");



    }

    @Test
    /*test mouvemnt du monstre intelligent evite obstacle*/

    public void test_mouvement_monstre_intelligent() throws Exception{

        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyMouvementMonstreIntelligent.txt");
        Clavier clavier = new Clavier();
        LabyJeu labyJeu = new LabyJeu(labyrinthe);
        labyJeu.update(0, clavier);

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


}
