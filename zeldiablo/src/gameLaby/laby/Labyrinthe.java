package gameLaby.laby;

import gameLaby.*;
import gameLaby.entites.Entite;
import gameLaby.entites.Fantome;
import gameLaby.entites.Monstre;
import gameLaby.entites.Perso;
import gameLaby.graphe.Couple;
import gameLaby.graphe.Dijkstra;
import gameLaby.graphe.GrapheListe;
import gameLaby.graphe.Valeur;
import gameLaby.interactif.*;
import gameLaby.objets.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * classe labyrinthe. represente un labyrinthe avec
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 */
public class Labyrinthe {

    /**
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char VIDE = '.';
    public static final char OUVERTURE = 'O';
    public static final char FERMETURE = 'F';
    public static final char PSECRET = 'H';
    public static final char MONSTRE= 'M';
    public static final char FANTOME = 'G';
    public static final char AMULETTE = 'A';
    public static final char EPEE = 'E';
    public static final char ARC = 'B';

    public static final char SORTIE = 'S';
    public static final char COFFRE = 'C';
    public static final char CLE = 'K';

    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";

    /**
     * attribut du personnage
     */
    private Perso pj;
    private Sortie sortie = null;

    /**
     * les murs du labyrinthe
     */
    private boolean[][] murs;

    public ArrayList<Declenchable> declenchables = new ArrayList<>();
    public ArrayList<PassageSecret> psecrets = new ArrayList<>();
    public ArrayList<Entite> entites = new ArrayList<>();
    public ArrayList<Item> items = new ArrayList<>();
    public ArrayList<Coffre> coffres = new ArrayList<>();

    /**
     * retourne la case suivante selon une actions
     *
     * @param x      case depart
     * @param y      case depart
     * @param action action effectuee
     * @return case suivante
     */
    public static int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                // on monte une ligne
                y--;
                break;
            case BAS:
                // on descend une ligne
                y++;
                break;
            case DROITE:
                // on augmente colonne
                x++;
                break;
            case GAUCHE:
                // on augmente colonne
                x--;
                break;
            default:
                throw new Error("action inconnue");
        }
        int[] res = {x, y};
        return res;
    }

    /**
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @return labyrinthe cree
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(String nom) throws IOException {
        Labyrinthe laby = this;
        // ouvrir fichier
        FileReader fichier = new FileReader(nom);
        BufferedReader bfRead = new BufferedReader(fichier);

        int nbLignes, nbColonnes;
        // lecture nblignes
        nbLignes = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        nbColonnes = Integer.parseInt(bfRead.readLine());

        // creation labyrinthe vide
        this.murs = new boolean[nbColonnes][nbLignes];
        this.pj = null;

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;

        // parcours le fichier
        while (ligne != null) {

            // parcours de la ligne
            for (int colonne = 0; colonne < ligne.length(); colonne++) {
                char c = ligne.charAt(colonne);
                switch (c) {
                    case MUR:
                        this.murs[colonne][numeroLigne] = true;
                        break;
                    case VIDE:
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case PJ:
                        this.murs[colonne][numeroLigne] = false;
                        this.pj = new Perso(colonne, numeroLigne, 5, laby);
                        this.entites.add(pj);
                        break;
                    case OUVERTURE:
                        declenchables.add(new Ouverture(Ouverture.nbOuvertures, colonne, numeroLigne, laby));
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case FERMETURE:
                        declenchables.add(new Fermeture(Fermeture.nbFermetures, colonne, numeroLigne, laby));
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case PSECRET:
                        psecrets.add(new PassageSecret(PassageSecret.nbPassages,colonne, numeroLigne, laby));
                        this.murs[colonne][numeroLigne] = true;
                        break;
                    case MONSTRE:
                        entites.add(new Monstre(colonne, numeroLigne, 2, laby));
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case FANTOME:
                        entites.add(new Fantome(colonne, numeroLigne, 2,laby));
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case AMULETTE:
                        items.add(new Amulette(colonne, numeroLigne, laby));
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case SORTIE:
                        sortie = new Sortie(colonne, numeroLigne, laby);
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case COFFRE:
                        coffres.add(new Coffre(colonne, numeroLigne, laby));
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case CLE:
                        items.add(new Cle(colonne, numeroLigne,laby));
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case EPEE:
                        // degats aléatoire entre 2 et 4
                        int degatsEpee = (int)Math.ceil(Math.random()*3) +1;
                        items.add(new Epee(colonne, numeroLigne,degatsEpee));
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case ARC:
                        int degatsArc = (int)Math.ceil(Math.random()*3) +1;
                        items.add(new Arc(colonne, numeroLigne,degatsArc));
                        this.murs[colonne][numeroLigne] = false;
                        break;

                    default:
                        throw new Error("caractere inconnu " + c);

                }
            }

            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }

        // ferme fichier
        bfRead.close();
    }


    /**
     * deplace le personnage en fonction de l'action.
     * gere la collision avec les murs
     *
     * @param action une des actions possibles
     */
    public void deplacerPerso(String action) {
        try {
            // case courante
            int[] courante = {this.pj.getX(), this.pj.getY()};

            // calcule case suivante
            int[] suivante = getSuivant(courante[0], courante[1], action);

            // si c'est pas un mur, on effectue le deplacement
            if (!this.murs[suivante[0]][suivante[1]] && estVideCase(suivante[0], suivante[1]) && pj.etreVivant()) {
                // on met a jour personnage
                this.pj.setX(suivante[0]);
                this.pj.setY(suivante[1]);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            // si on essaye de sortir d'un labyrinthe, alors on change de labyrinthe
            Main.changerLaby(this, LabyJeu.DERNIER_MOUVEMENT);
        }

    }

    /**
     * attaque les monstres dans la direction du personnage
     * @param derniere_direction direction de l'attaque
     */
    public void attaqueDirectionnel(String derniere_direction) {
        // case courante
        int[] courante = {this.pj.getX(), this.pj.getY()};

        // case suivante = case courante + direction
        int[] suivante = getSuivant(courante[0], courante[1], derniere_direction);

        // si une entite vivante est presente dans la case, on l'attaque
        for (Entite entite : entites) {
            if (entite instanceof Monstre && entite.etreVivant() && entite.etrePresent(suivante[0], suivante[1])) {
                Monstre m = (Monstre) entite;
                pj.attaquer(m);
            }
        }
    }


    /**
     * actionne un item dans la direction du personnage
     * @param derniere_direction direction de l'action
     */
    public void actionnerItem(String derniere_direction){
        // case courante
        int[] courante = {this.pj.getX(), this.pj.getY()};

        // case suivante = case courante + direction
        int[] suivante = getSuivant(courante[0], courante[1], derniere_direction);

        // pour chaque coffres
        for (Coffre c : coffres) {
            // si le coffre est present dans la case et n'est pas deja ouvert
            if (c.etrePresent(suivante[0], suivante[1])&& c.isActif()) {
                // on essaye de l'ouvrir
                c.tenterOuverture();
            }
        }
    }


    /**
     * fait bouger tous les monstres du labyrinthe
     */
    public void mouvementsMonstres(){
        // on creer les chemins pour les monstres affectes par les murs et non affectes
        GrapheListe g1 = new GrapheListe(this, false);
        GrapheListe g2 = new GrapheListe(this, true);
        Dijkstra d = new Dijkstra();

        for (Entite entite : entites) {
            // on parcourt les entites
            if (entite instanceof Monstre && entite.etreVivant()) {
                // si c'est un monstre et qu'il est vivant
                // on recupere le graphe correspondant
                GrapheListe g = g1;
                if (entite instanceof Fantome){
                    // si c'est un fantome, on prend le graphe sans les murs
                    g = g2;
                }
                Monstre m = (Monstre) entite;
                String monstre = m.getX()+","+m.getY();

                // on recupere le chemin le plus court
                Valeur v = d.resoudre(g, monstre);
                List<String> l = v.calculerChemin(pj.getX()+","+pj.getY());

                // si il a un chemin jusqu'au personnage
                if (l.size()>=2) {
                    // on recupere la case suivante
                    String[] prochain = l.get(l.size() - 2).split(",");
                    int[] coords = {Integer.parseInt(prochain[0]), Integer.parseInt(prochain[1])};

                    // si la case est vide, on deplace le monstre
                    Entite collision = m.collision(coords);
                    if (collision==null) {
                        m.setX(coords[0]);
                        m.setY(coords[1]);
                    }
                    else{
                        // si c'est un personnage, on l'attaque
                        if(collision instanceof Perso)
                            m.attaquer(this.pj);
                    }
                }
                else{
                    // si le monstre n'a pas de chemin jusqu'au personnage, il bouge aleatoirement
                    if (!g.suivants(monstre).isEmpty())
                        mouvementAleatoireMonstres(m, g.suivants(monstre));
                }
            }
        }
    }

    /**
     * fait bouger un monstre aleatoirement quand il ne trouve pas le personnage
     * @param m monstre
     * @param v liste des cases suivantes possibles
     */
    public void mouvementAleatoireMonstres(Monstre m, List<Couple> v) {
        // on recupere une case aleatoire dans celles disponibles
        int random = (int) (Math.random() * v.size());
        String dest = v.get(random).getDest();
        String[] prochain = dest.split(",");
        int[] coords = {Integer.parseInt(prochain[0]), Integer.parseInt(prochain[1])};

        // si la case est vide, on deplace le monstre
        Entite collision = m.collision(coords);
        if (collision==null) {
            m.setX(coords[0]);
            m.setY(coords[1]);
        }
    }


    /**
     * fin du jeu si le personnage est mort
     * @return fin du jeu
     */
    public boolean etreFini() {
        if (!this.pj.etreVivant()) {
            System.out.println("Vous êtes mort");
            return true;
        }
        return false;
    }

    // ##################################
    // GETTER
    // ##################################

    /**
     * return taille selon Y
     *
     * @return
     */
    public int getLengthY() {
        return murs[0].length;
    }

    /**
     * return taille selon X
     *
     * @return
     */
    public int getLength() {
        return murs.length;
    }

    /**
     * return mur en (i,j)
     * @param x
     * @param y
     * @return
     */
    public boolean getMur(int x, int y) {
        // utilise le tableau de boolean
        return this.murs[x][y];
    }

    /**
     * return l'indice du passage secret en (x,y) si il y en a un
     * @param x
     * @param y
     * @return
     */
    public int getPsecret(int x, int y) {
        for (int i = 0; i < psecrets.size(); i++) {
            PassageSecret psecret = psecrets.get(i);
            if (psecret.getX() == x && psecret.getY() == y) {
                return i;
            }
        }
        return -1;
    }

    /**
     * return si il y a un monstre en (x,y)
     * @param x
     * @param y
     * @return
     */
    public boolean getMonstre(int x, int y) {
        for (Entite entite : entites) {
            if (entite instanceof Monstre) {
                if (entite.getX() == x && entite.getY() == y && entite.etreVivant()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * return la position du personnage
     * @return int[] position
     */
    public int[] getPersonnage() {
        return new int[]{this.pj.getY(), this.pj.getX()};
    }

    /**
     * return le personnage du labyrinthe
     * @return perso
     */
    public Perso getPerso() {
        return this.pj;
    }

    /**
     * ajoute une entite au labyrinthe
     * @param e
     */
    public void ajouterEntite(Entite e) {
        if(estVideCase(e.getX(), e.getY())) {
            this.entites.add(e);}
    }

    /**
     * ajoute un item au labyrinthe
     * @param i
     */
    public void ajouterItem(Item i) {
        if(estVideCase(i.getX(), i.getY())) {
            this.items.add(i);}
    }



    /**
     * méthode estVideCase indique si la case est vide
     * @param x
     * @param y
     * @return
     */
    public boolean estVideCase(int x, int y){
        boolean vide = true;
        for (Entite entite : this.entites) {
            // si entite est presente dans la case + vivante
            if (entite.etrePresent(x, y) && entite.etreVivant()) {
                vide = false;
            }
        }

        for (Coffre c: coffres){
            // si coffre est present dans la case et actif
            if (c.getX() == x && c.getY() == y && c.isActif()){
                vide = false;
            }
        }

        // si mur est present dans la case
        if (this.murs[x][y]) {
            vide = false;
        }
        return vide;
    }

    /**
     * retourne la sortie du labyrinthe
     * @return sortie
     */
    public Sortie getSortie() {
        return sortie;
    }

    /**
     * retourne l'indice du coffre en (x,y) si il y en a un
     * @param x
     * @param y
     * @return
     */
    public int getCoffre(int x, int y) {
        for (int i = 0; i < coffres.size(); i++) {
            Coffre coffre = coffres.get(i);
            if (coffre.getX() == x && coffre.getY() == y) {
                return i;
            }
        }
        return -1;
    }

    /**
     * ouvre le passage secret en parametre
     * @param p
     */
    public void ouvrirPassageSecret(PassageSecret p){
        for (int i = 0; i < psecrets.size(); i++) {
            PassageSecret psecret = psecrets.get(i);
            if (psecret.equals(p)) {
                psecret.ouvrir();
                this.murs[psecret.getX()][psecret.getY()] = false;
            }
        }
    }

    /**
     * ouvre le passage secret en parametre
     * @param p
     */
    public void fermerPassageSecret(PassageSecret p){
        for (int i = 0; i < psecrets.size(); i++) {
            PassageSecret psecret = psecrets.get(i);
            if (psecret.equals(p)) {
                psecret.fermer();
                this.murs[psecret.getX()][psecret.getY()] = true;
            }
        }
    }
}