import gameLaby.laby.LabyJeu;
import gameLaby.laby.Labyrinthe;
import moteurJeu.Clavier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCoffre {

    /**
     * Test de ramassage de la clé, ajout dans l'inventaire
     * @throws Exception
     */
    @Test
    public void test_ramasser_cle() throws Exception {

        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyCleCoffre.txt");
        Clavier clavier = new Clavier();
        LabyJeu labyJeu = new LabyJeu(labyrinthe);

        boolean possede = labyrinthe.getPerso().possedeCle();
        assertFalse(possede, "le personnage ne doit pas posseder la clé");
        labyrinthe.deplacerPerso(Labyrinthe.BAS);
        labyrinthe.items.get(0).ramasserItem();
        possede = labyrinthe.getPerso().possedeCle();
        assertTrue(possede, "la cle doit être dans l'inventaire du personnage");
    }

    /**
     * Test ouverture d'un coffre et de disparition de la clé une fois le coffre ouvert
     * @throws Exception
     */
    @Test
    public void test_ouvrir_coffre() throws Exception {
        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyCleCoffre.txt");
        Clavier clavier = new Clavier();
        LabyJeu labyJeu = new LabyJeu(labyrinthe);

        labyrinthe.deplacerPerso(Labyrinthe.BAS);

        boolean present = labyrinthe.getCoffre(1,3)!=-1;
        assertTrue(present, "le coffre doit être présent dans le labyrinthe");

        labyrinthe.actionnerItem(Labyrinthe.BAS);
        boolean possede = labyrinthe.getPerso().possedeCle();
        assertFalse(possede, "le personnage ne doit plus posseder la clé");
    }
}
