import edu.princeton.cs.algs4.*;

public class GraphProperties {
    private int[] eccentricities;
    private int diameter;
    private int radius;
    private LinkedQueue<Integer> centers;

    // Calculate graph properties for the graph G.
    public GraphProperties(Graph G) {
        CC cc = new CC(G);
        if (cc.count() > 1) {
            throw new IllegalArgumentException("G is not connected");
        }
        ...
    }
    
    // Eccentricity of v.
    public int eccentricity(int v) {
        ...
    }

    // Diameter of G.
    public int diameter() {
        ...
    }

    // Radius of G.
    public int radius() {
        ...
    }

    // Centers of G.
    public Iterable<Integer> centers() {
        ...
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        GraphProperties gp = new GraphProperties(G);
        StdOut.println("Diameter = " + gp.diameter());
        StdOut.println("Radius   = " + gp.radius());
        StdOut.println("Centers  = " + gp.centers());
    }
}
