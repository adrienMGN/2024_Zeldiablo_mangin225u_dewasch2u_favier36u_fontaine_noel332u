import gameLaby.laby.LabyJeu;
import gameLaby.laby.Labyrinthe;
import moteurJeu.Clavier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFermeture {

    /**
     * Test de fermeture d'un passage secret après ouverture
     * @throws Exception
     */
    @Test
    public void test_fermeture1passage() throws Exception {

        Labyrinthe laby = new Labyrinthe("labySimple/labyTest/labyTestFermeture.txt");

        LabyJeu labyJeu = new LabyJeu(laby);

        laby.deplacerPerso(Labyrinthe.GAUCHE); // deplace gauche atteint ouverture
        Clavier clavier = new Clavier(); // necessaire pour update

        laby.deplacerPerso(Labyrinthe.DROITE);
        laby.deplacerPerso(Labyrinthe.DROITE);

        boolean active = laby.psecrets.get(0).isActive(); // recupère l'état du passage secret

        assertEquals(false, active, "Le passage secret est censé être fermé.");

        laby.deplacerPerso(Labyrinthe.GAUCHE);

    }


    /**
     * test avec un passage secret double fermeture
     * une des fermeture est donc inutile et n'ouvre pas le passage secret
     * @throws Exception
     */
// test avec un passage secret double fermeture
// une des fermeture est donc inutile et n'ouvre pas le passage secret
/*
 * en effet, avec la gestion des passage et des fermeture, un passage et associer à une unique fermeture
 * la fermeture lu en premier dans le labyrinthe est donc associer au passage secret lu à la suite
 * */
@Test
public void test_fermeture_double() throws Exception{

    Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyTestFermetureDouble.txt");
    LabyJeu labyJeu = new LabyJeu(labyrinthe);
    labyrinthe.deplacerPerso(Labyrinthe.DROITE); // deplace gauche atteint ouverture
    Clavier clavier = new Clavier(); // necessaire pour update

    labyrinthe.ouvrirPassageSecret(labyrinthe.psecrets.get(0));
    boolean active = labyrinthe.psecrets.getFirst().isActive(); // recupère l'état du passage secret
    assertEquals(true, active,"le passage doit etre ouvert");

    labyrinthe.deplacerPerso(Labyrinthe.GAUCHE); // deplace gauche atteint ouverture
    labyrinthe.deplacerPerso(Labyrinthe.GAUCHE); // deplace gauche atteint ouverture
    labyrinthe.fermerPassageSecret(labyrinthe.psecrets.get(0));
    active = labyrinthe.psecrets.getFirst().isActive(); // recupère l'état du passage secret
    assertEquals(false, active, "Le passage secret est censé être fermé.");

    labyrinthe.deplacerPerso(Labyrinthe.DROITE); // deplace gauche atteint ouverture
    labyrinthe.deplacerPerso(Labyrinthe.DROITE); // deplace gauche atteint ouverture
    labyrinthe.ouvrirPassageSecret(labyrinthe.psecrets.get(0));
    active = labyrinthe.psecrets.getFirst().isActive(); // recupère l'état du passage secret
    assertEquals(true, active, "Le passage secret est censé être ouvert.");

    labyrinthe.deplacerPerso(Labyrinthe.BAS); // deplace gauche atteint ouverture
    active = labyrinthe.psecrets.getFirst().isActive(); // recupère l'état du passage secret
    assertEquals(true, active, "Le passage secret est être resté ouvert.");


}

/**
 * Test double fermeture et double passage secrets
 * @throws Exception
 * */
@Test
public void test_fermeture_double_ok() throws Exception {
    Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyTestFermetureDoubleOk.txt");
    LabyJeu labyJeu = new LabyJeu(labyrinthe);
    labyrinthe.deplacerPerso(Labyrinthe.DROITE); // deplace gauche atteint ouverture
    Clavier clavier = new Clavier(); // necessaire pour update

    labyrinthe.ouvrirPassageSecret(labyrinthe.psecrets.get(0));
    boolean active = labyrinthe.psecrets.getFirst().isActive(); // recupère l'état du passage secret
   assertEquals(true, active, "le passage doit etre ouvert");

    labyrinthe.deplacerPerso(Labyrinthe.GAUCHE); // deplace gauche atteint ouverture
    labyrinthe.deplacerPerso(Labyrinthe.GAUCHE); // deplace gauche atteint ouverture

    labyrinthe.fermerPassageSecret(labyrinthe.psecrets.get(0));
    active = labyrinthe.psecrets.get(0).isActive(); // recupère l'état du passage secret
    assertEquals(false, active, "Le passage secret est censé être fermé.");

    labyrinthe.ouvrirPassageSecret(labyrinthe.psecrets.get(0));
    labyrinthe.deplacerPerso(Labyrinthe.DROITE); // deplace gauche atteint ouverture
    labyrinthe.deplacerPerso(Labyrinthe.DROITE); // deplace gauche atteint ouverture
    active = labyrinthe.psecrets.getFirst().isActive(); // recupère l'état du passage secret
    assertEquals(true, active, "Le passage secret est censé être ouvert.");

    labyrinthe.ouvrirPassageSecret(labyrinthe.psecrets.get(1));
    labyrinthe.deplacerPerso(Labyrinthe.BAS); // deplace gauche atteint ouverture
    active = labyrinthe.psecrets.get(1).isActive(); // recupère l'état du passage secret
    assertEquals(true, active, "Le passage secret est ouvert.");

    labyrinthe.deplacerPerso(Labyrinthe.GAUCHE);
    labyrinthe.fermerPassageSecret(labyrinthe.psecrets.get(1));
    active = labyrinthe.psecrets.get(1).isActive(); // recupère l'état du passage secret 2
    assertEquals(false, active, "Le passage secret est fermé.");
}




}
