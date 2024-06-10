package gameLaby;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe GrapheListe implémente l'interface Graphe.
 * Elle représente un graphe sous forme de liste d'adjacence.
 */
public class GrapheListe{

    String[][] graphe;


    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;

    /**
     * Constructeur de la classe GrapheListe.
     * Charge un graphe à partir d'un fichier.
     * @param laby Le nom du fichier à charger.
     */
    public GrapheListe(Labyrinthe laby) {
        graphe = new String[laby.getLength()][laby.getLengthY()];
        for (int y = 0; y < laby.getLengthY(); y++) {
            for (int x = 0; x < laby.getLength(); x++) {
                graphe[x][y] = x+","+y;
            }
        }

        for (int y = 0; y < laby.getLengthY(); y++) {
            for (int x = 0; x < laby.getLength(); x++) {
                if (!laby.getMur(x, y)) {
                    if (x > 0 && !laby.getMur(x - 1, y) && !laby.getMonstre(x - 1, y)) {
                        ajouterArc(graphe[x][y], graphe[x - 1][y], 1);
                    }
                    if (x < laby.getLength() - 1 && !laby.getMur(x + 1, y) && !laby.getMonstre(x + 1, y)) {
                        ajouterArc(graphe[x][y], graphe[x + 1][y], 1);
                    }
                    if (y > 0 && !laby.getMur(x, y - 1) && !laby.getMonstre(x, y - 1)) {
                        ajouterArc(graphe[x][y], graphe[x][y - 1], 1);
                    }
                    if (y < laby.getLengthY() - 1 && !laby.getMur(x, y + 1)&& !laby.getMonstre(x, y + 1)) {
                        ajouterArc(graphe[x][y], graphe[x][y + 1], 1);
                    }
                }
            }
        }
    }

    /**
     * Récupère l'indice d'un noeud dans la liste des noeuds.
     * @param n Le noeud dont on veut récupérer l'indice.
     * @return L'indice du noeud dans la liste des noeuds.
     */
    public int getIndice(String n){
        return noeuds.indexOf(n);
    }

    /**
     * Ajoute un arc au graphe.
     * @param depart Le noeud de départ de l'arc.
     * @param destination Le noeud de destination de l'arc.
     * @param cout Le coût de l'arc.
     */
    public void ajouterArc(String depart, String destination, double cout){
        if(this.noeuds == null){
            this.noeuds = new ArrayList<>();
        }
        if(this.adjacence == null){
            this.adjacence = new ArrayList<>();
        }

        int indice = getIndice(depart);
        if(indice == -1){
            noeuds.add(depart);
            adjacence.add(new Arcs());
        }
        indice = getIndice(destination);
        if(indice == -1){
            noeuds.add(destination);
            adjacence.add(new Arcs());
        }
        indice = getIndice(depart);
        Arc a = new Arc(destination,cout);
        adjacence.get(indice).ajouterArc(a);
    }

    /**
     * Récupère la liste des noeuds du graphe.
     * @return La liste des noeuds du graphe.
     */
    public List<String> listeNoeuds(){
        return noeuds;
    }

    /**
     * Récupère la liste des arcs partant du noeud spécifié.
     * @param n Le noeud à partir duquel récupérer les arcs.
     * @return La liste des arcs partant du noeud spécifié.
     */
    public List<Arc> suivants(String n){
        int indice = getIndice(n);
        if (indice == -1){
            return new ArrayList<Arc>();
        }
        return adjacence.get(indice).getArcs();
    }

    /**
     * Retourne une représentation sous forme de chaîne de cette classe.
     * @return Une chaîne représentant cette classe.
     */
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < noeuds.size(); i++){
            s.append(noeuds.get(i));
            s.append(" -> ");
            List<Arc> l = adjacence.get(i).getArcs();
            for (Arc a : l){
                s.append(a.toString());
            }
            s.append("\n");
        }
        return s.toString();
    }
}