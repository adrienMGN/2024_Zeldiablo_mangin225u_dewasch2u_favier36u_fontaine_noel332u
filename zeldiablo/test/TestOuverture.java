import gameLaby.laby.LabyJeu;
import gameLaby.laby.Labyrinthe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import moteurJeu.Clavier;


public class TestOuverture {


    /**
     * Test d'ouverture d'un passage secret avec son ouverture
     * @throws Exception
     */
    @Test
    public void test_ouverture_simple() throws Exception{
        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyTestOuvertureSimple.txt");
        LabyJeu labyJeu = new LabyJeu(labyrinthe);
        labyrinthe.deplacerPerso(Labyrinthe.GAUCHE); // deplace gauche atteint ouverture
        Clavier clavier = new Clavier(); // necessaire pour update

        labyrinthe.ouvrirPassageSecret(labyrinthe.psecrets.get(0));
        boolean active = labyrinthe.psecrets.get(0).isActive(); // recupère l'état du passage secret


        assertEquals(true, active,"le passage doit etre ouvert");



    }

    /** test avec un passage secret double ouverture
    // une des ouverture est donc inutile et n'ouvre pas le passage secret
    /*
    * en effet, avec la gestion des passage et des ouverture, un passage et associer à une unique ouverture
    * l'ouverture lu en premier dans le labyrinthe est donc associer au passage secret lu à la suite
     * @throws Exception
    * */
    @Test
    public void test_ouverture_double() throws Exception{

        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyTestOuvertureDouble.txt");
        LabyJeu labyJeu = new LabyJeu(labyrinthe);
        labyrinthe.deplacerPerso(Labyrinthe.DROITE); // deplace gauche atteint ouverture
        Clavier clavier = new Clavier(); // necessaire pour update

        boolean active = labyrinthe.psecrets.get(0).isActive(); // recupère l'état du passage secret
        assertEquals(false, active,"le passage doit etre fermer");

        labyrinthe.deplacerPerso(Labyrinthe.GAUCHE); // deplace gauche atteint ouverture
        labyrinthe.deplacerPerso(Labyrinthe.GAUCHE); // de
        labyrinthe.ouvrirPassageSecret(labyrinthe.psecrets.get(0));
        active = labyrinthe.psecrets.get(0).isActive(); // recupère l'état du passage secret'
        assertEquals(true, active,"le passage doit etre ouvert");

    }

    /**
    * Test double ouverture et double passage secrets
     * @throws Exception
     */
    @Test
    public void test_ouverture_double_ok() throws Exception{
        Clavier clavier = new Clavier();
        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyTestOuvertureDoubleOk.txt");
        LabyJeu labyJeu = new LabyJeu(labyrinthe);
        labyrinthe.deplacerPerso(Labyrinthe.GAUCHE); // deplace gauche atteint ouverture
        labyrinthe.ouvrirPassageSecret(labyrinthe.psecrets.get(0));
        boolean active = labyrinthe.psecrets.get(0).isActive(); // recupère l'état du passage secret'
        assertEquals(true, active,"le passage doit etre ouvert");
        labyrinthe.deplacerPerso(Labyrinthe.DROITE); // deplace gauche atteint ouverture
        labyrinthe.deplacerPerso(Labyrinthe.DROITE); // deplace gauche at
        labyrinthe.ouvrirPassageSecret(labyrinthe.psecrets.get(1));
        active = labyrinthe.psecrets.get(1).isActive(); // recupère l'état du passage secret'
        assertEquals(true, active,"le passage doit etre ouvert");
    }
}
