import gameLaby.LabyJeu;
import gameLaby.Labyrinthe;
import gameLaby.Monstre;
import gameLaby.Perso;
import moteurJeu.Clavier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMonstre {

    @Test

    public void test_ajout_monstre() throws Exception{
        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyMonstre.txt");
        Clavier clavier = new Clavier();
        LabyJeu labyJeu = new LabyJeu(labyrinthe);
        System.out.println(labyrinthe.entites.size());
        Monstre m= new Monstre(1,1, 10);
        labyrinthe.ajouterEntite(m);
        labyJeu.update(0, clavier);
        assertTrue( m.etrePresent(1,1),"le monstre devrait être présent en 1,1");

        Monstre m2 = (Monstre)labyrinthe.entites.get(0);
        System.out.println(m2.getX() + " " +  m2.getY());
        assertTrue( m2.etrePresent(2,2),"le monstre devrait être présent en 2,2");

    }

    public void test_mouvement_monstre() throws Exception{

        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyMouvementMonstre.txt");
        Clavier clavier = new Clavier();
        LabyJeu labyJeu = new LabyJeu(labyrinthe);

        labyrinthe.mouvementsMonstres();
        Monstre m = (Monstre) labyrinthe.entites.get(0);




    }

}
