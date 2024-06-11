package gameLaby.graphe;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe Arcs représente une liste d'arcs.
 * Elle permet d'ajouter des arcs à la liste et de récupérer la liste des arcs.
 */
public class Arcs {
    private List<Arc> arcs;

    /**
     * Constructeur de la classe Arcs.
     * Initialise la liste des arcs.
     */
    public Arcs(){
        arcs = new ArrayList<>();
    }

    /**
     * Ajoute un arc à la liste des arcs.
     * @param a L'arc à ajouter.
     */
    public void ajouterArc(Arc a){
        arcs.add(a);
    }

    /**
     * Récupère la liste des arcs.
     * @return La liste des arcs.
     */
    public List<Arc> getArcs(){
        return arcs;
    }
}