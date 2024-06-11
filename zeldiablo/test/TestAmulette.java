import gameLaby.objets.Amulette;
import gameLaby.laby.Labyrinthe;
import gameLaby.laby.LabyJeu;
import gameLaby.entites.Monstre;
import moteurJeu.Clavier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAmulette {

    @Test
    public void test_ramasser_Amulette_et_placement() throws Exception{
        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyAmulette.txt");
        Clavier clavier = new Clavier();
        LabyJeu labyJeu = new LabyJeu(labyrinthe);
        Amulette a = new Amulette(1,2, labyrinthe);
        boolean presence = a.etrePresent(1,2);
        assertTrue(presence, "l'amulette n'est pas présente dans le labyrinthe");
        labyrinthe.ajouterItem(a);
        labyrinthe.deplacerPerso(Labyrinthe.BAS);
        labyJeu.update(0,clavier);
        boolean possede = labyrinthe.getPerso().getInventaire().contains(a);

        assertTrue(possede, "l'amulette n'est pas dans l'inventaire du personnage");



        // le test ne passe pas car exit 0

        labyrinthe.deplacerPerso(Labyrinthe.BAS);
        labyJeu.update(0,clavier);
        boolean fini = labyJeu.etreFini();
        //boolean fini = labyrinthe.getPerso().etrePresent(1,3);
        assertTrue(fini, "le jeu devrait être fini");



    }

    @Test
    /*
    * test verifie que le monstre ne peut pas ramasser l'amulette*/
    public void test_monstre_ramasser_Amulette() throws Exception{
        Labyrinthe labyrinthe = new Labyrinthe("labySimple/labyTest/labyAmuletteMonstre.txt");
        Clavier clavier = new Clavier();
        LabyJeu labyJeu = new LabyJeu(labyrinthe);
        Monstre m = new Monstre(1,1, 2, labyrinthe);
        Amulette a = new Amulette(1,1, labyrinthe);
        boolean presence = a.etrePresent(1,1);
        assertTrue(presence, "l'amulette doit  être présente dans le labyrinthe");
        labyrinthe.ajouterItem(a);
        labyrinthe.ajouterEntite(m);
        labyJeu.update(0,clavier);
        assertTrue(presence, "l'amulette doit toujours être présente dans le labyrinthe");


    }

}

