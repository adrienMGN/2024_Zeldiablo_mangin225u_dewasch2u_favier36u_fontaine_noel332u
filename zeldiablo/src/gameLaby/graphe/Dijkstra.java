package gameLaby.graphe;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe Dijkstra implémente l'interface Algorithme.
 * Elle utilise l'algorithme de Dijkstra pour résoudre un graphe.
 */
public class Dijkstra {


    /*
    Entrées :
        G un graphe orienté avec une pondération positive des arcs (coût ou poids)
        A un sommet (départ) de G
    Début
        Q <- {} // utilisation d’une liste de noeuds à traiter
        Pour chaque sommet v de G faire
            v.valeur <- Infini
            v.parent <- Indéfini
            Q <- Q U {v} // ajouter le sommet v à la liste Q
        Fin Pour
        A.valeur <- 0
        Tant que Q est un ensemble non vide faire
            u <- un sommet de Q telle que u.valeur est minimal
            // enlever le sommet u de la liste Q
            Q <- Q \ {u}
            Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
                d <- u.valeur + poids(u,v)
                Si d < v.valeur
                    // le chemin est plus interessant
                    Alors v.valeur <- d
                    v.parent <- u
                Fin Si
            Fin Pour
        Fin Tant que
    Fin
    */

    /**
     * Méthode pour résoudre un graphe en utilisant l'algorithme de Dijkstra.
     * @param g Le graphe à résoudre.
     * @param depart Le point de départ dans le graphe.
     * @return La valeur résultante après avoir résolu le graphe.
     */
    public Valeur resoudre(GrapheListe g, String depart) {

        Valeur valeur = new Valeur();
        // Liste q qui contiendra tous les noeuds pour lesquels ils faut trouver un chemin
        List<String> q = new ArrayList<>();
        // On initialise toutes les valeurs à la plus grande valeur possible et sans parent
        // On ajoute tous les noeuds à la liste q
        for (String v : g.listeNoeuds()){
            valeur.setValeur(v,Double.MAX_VALUE);
            valeur.setParent(v, null);
            q.add(v);
        }
        // On met la valeur du point de depart à 0
        valeur.setValeur(depart, 0);
        // Tant que q n'est pas vide
        while (!q.isEmpty()){
            // On récupère le noeud avec le chemin le plus court avec une boucle
            String u = q.getFirst();
            for (String n : q){
                if (valeur.getValeur(u)>valeur.getValeur(n)){
                    u = n;
                }
            }
            // On le retire car il a un chemin
            q.remove(u);
            // On parcourt tous les noeuds suivants du chemin le plus court
            for (Couple a : g.suivants(u)){
                String v =  a.getDest();
                double d = valeur.getValeur(u)+a.getCout();

                if (d < valeur.getValeur(v)){
                    valeur.setValeur(v, d);
                    valeur.setParent(v, u);
                }
            }
        }
        return valeur;
    }

    /**
     * Retourne une représentation sous forme de chaîne de cette classe.
     * @return Une chaîne représentant cette classe.
     */
    public String toString() {
        return "Dijkstra";
    }
}