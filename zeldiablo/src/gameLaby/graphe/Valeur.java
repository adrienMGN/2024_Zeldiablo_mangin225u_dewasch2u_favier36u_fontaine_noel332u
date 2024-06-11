package gameLaby.graphe;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;

/**
 * Classe fournie, permet de stocker des valeurs associées au noeud et des parents
 * - un noeud est represente par un String (son nom)
 * - on accede avec des get (getValeur et getParent)
 * - on modifie avec des set (setValeur et setParent)
 */
public class Valeur {

    /**
     * attributs pour stocker les informations (type Table = Dictionnaire)
     * dans le programme de 2 annee.
     */
    Map<String, Double> valeur;
    Map<String, String> parent;

    /**
     * constructeur vide (initialise la possibilité de stocker des valeurs)
     */
    public Valeur() {
        this.valeur = new TreeMap<>();
        this.parent = new TreeMap<>();
    }

    /**
     * permet d'associer une valeur a un nom de noeud (ici L(X))
     *
     * @param nom    le nom du noeud
     * @param valeur la valeur associée
     */
    public void setValeur(String nom, double valeur) {
        // modifie valeur
        this.valeur.put(nom, valeur);
    }

    /**
     * * permet d'associer un parent a un nom de noeud (ici parent(X))
     *
     * @param nom    nom du noeud
     * @param parent nom du noeud parent associe
     */
    public void setParent(String nom, String parent) {
        this.parent.put(nom, parent);
    }

    /**
     * accede au parent stocke associe au noeud nom passe en parametre
     *
     * @param nom nom du noeud
     * @return le nom du noeud parent
     */
    public String getParent(String nom) {
        return this.parent.get(nom);
    }


    /**
     * accede a la valeur associee au noeud nom passe en parametre
     *
     * @param nom nom du noeud
     * @return la valeur stockee
     */
    public double getValeur(String nom) {
        return this.valeur.get(nom);
    }

    /**
     * retourne une chaine qui affiche le contenu
     * - par noeud stocke
     * - a chaque noeud, affiche la valeur puis le noeud parent
     *
     * @return descriptif du noeud
     */
    public String toString() {
        StringBuilder res = new StringBuilder();
        // pour chaque noeud
        for (String s : this.valeur.keySet()) {
            // ajoute la valeur et le noeud parent
            Double valeurNoeud = valeur.get(s);
            String noeudParent = parent.get(s);
            res.append(" -> V:");
            res.append(valeurNoeud);
            res.append(" p:");
            res.append(noeudParent);
            res.append("\n");
        }
        return res.toString();

    }


    /**
     * Calcule le chemin à partir d'une destination donnée en utilisant les parents stockés.
     * Le chemin est retourné sous forme de liste de noms de noeuds, en commençant par la destination et en remontant jusqu'à la source.
     * @param destination Le nom du noeud de destination.
     * @return Une liste de noms de noeuds représentant le chemin de la source à la destination.
     */
    public List<String> calculerChemin(String destination){
        // On crée une liste pour stocker le chemin
        List<String> chemin = new ArrayList<>();
        // On ajoute la destination
        chemin.add(destination);
        // On récupère le parent de la destination
        String parent = this.getParent(destination);
        // Tant qu'on a un parent, on l'ajoute au chemin et on récupère le parent du parent
        while (parent!= null){
            chemin.add(parent);
            parent = this.getParent(parent);
        }
        // On retourne la liste à la fin
        chemin.reversed();
        return chemin;
    }
}