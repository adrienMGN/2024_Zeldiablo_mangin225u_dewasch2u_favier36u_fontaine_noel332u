import gameLaby.LabyJeu;
import gameLaby.Labyrinthe;
import gameLaby.Ouverture;
import gameLaby.PassageSecret;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import moteurJeu.Clavier;


public class TestOuverture {



    @Test
    /*
    * Test un passage secrat avec son ouverture*/
    public void test_ouverture_simple() throws Exception{
        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTestOuvertureSimple.txt");
        LabyJeu labyJeu = new LabyJeu(labyrinthe);
        labyrinthe.deplacerPerso(Labyrinthe.GAUCHE); // deplace gauche atteint ouverture
        Clavier clavier = new Clavier(); // necessaire pour update
        labyJeu.update(0, clavier); // màj de l'état du jeu'


        boolean active = labyrinthe.psecrets.get(0).isActive(); // recupère l'état du passage secret


        assertEquals(true, active,"le passage doit etre ouvert");



    }

    // test avec un passage secret double ouverture
    // une des ouverture est donc inutile et n'ouvre pas le passage secret
    /*
    * en effet, avec la gestion des passage et des ouverture, un passage et associer à une unique ouverture
    * l'ouverture lu en premier dans le labyrinthe est donc associer au passage secret lu à la suite
    * */
    @Test
    public void test_ouverture_double() throws Exception{

        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTestOuvertureSimple.txt");
        LabyJeu labyJeu = new LabyJeu(labyrinthe);
        labyrinthe.deplacerPerso(Labyrinthe.DROITE); // deplace gauche atteint ouverture
        Clavier clavier = new Clavier(); // necessaire pour update
        labyJeu.update(0, clavier); // màj de l'état du jeu'


        boolean active = labyrinthe.psecrets.getFirst().isActive(); // recupère l'état du passage secret
        assertEquals(false, active,"le passage doit etre fermer");

        labyrinthe.deplacerPerso(Labyrinthe.GAUCHE); // deplace gauche atteint ouverture
        labyrinthe.deplacerPerso(Labyrinthe.GAUCHE); // de

        labyJeu.update(0, clavier); // màj de l'état du jeu'
        active = labyrinthe.psecrets.get(0).isActive(); // recupère l'état du passage secret'
        assertEquals(true, active,"le passage doit etre ouvert");

    }

    /*
    * Test double ouverture et double passage secrets*/
    @Test
    public void test_ouverture_double_ok() throws Exception{
        Clavier clavier = new Clavier();
        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTestOuvertureDoubleOk.txt");
        LabyJeu labyJeu = new LabyJeu(labyrinthe);
        labyrinthe.deplacerPerso(Labyrinthe.GAUCHE); // deplace gauche atteint ouverture
        labyJeu.update(0, clavier); // màj de l'état du jeu'
        boolean active = labyrinthe.psecrets.get(0).isActive(); // recupère l'état du passage secret'
        assertEquals(true, active,"le passage doit etre ouvert");
        labyrinthe.deplacerPerso(Labyrinthe.DROITE); // deplace gauche atteint ouverture
        labyrinthe.deplacerPerso(Labyrinthe.DROITE); // deplace gauche at
        labyJeu.update(0, clavier); // màj de l'état du jeu'
        active = labyrinthe.psecrets.get(1).isActive(); // recupère l'état du passage secret'
        assertEquals(true, active,"le passage doit etre ouvert");
    }
}
