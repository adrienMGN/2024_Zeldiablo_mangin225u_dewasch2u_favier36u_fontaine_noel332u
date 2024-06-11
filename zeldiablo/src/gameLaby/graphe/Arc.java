package gameLaby.graphe;
/**
 * La classe Arc représente un arc dans un graphe.
 * Chaque arc a une destination et un coût associé.
 */
public class Arc {
    private String dest;
    private double cout;

    /**
     * Constructeur de la classe Arc.
     * @param dest La destination de cet arc.
     * @param cout Le coût de cet arc.
     */
    public Arc(String dest, double cout) {
        this.dest = dest;
        this.cout = cout;
    }

    /**
     * Récupère la destination de cet arc.
     * @return La destination de cet arc.
     */
    public String getDest(){
        return dest;
    }

    /**
     * Récupère le coût de cet arc.
     * @return Le coût de cet arc.
     */
    public double getCout(){
        return cout;
    }

    /**
     * Retourne une représentation sous forme de chaîne de cet arc.
     * @return Une chaîne représentant cet arc.
     */
    public String toString(){
        return getDest() + "(" + getCout() + ") ";
    }
}