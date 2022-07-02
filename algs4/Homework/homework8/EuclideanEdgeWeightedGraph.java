import edu.princeton.cs.algs4.*;

public class EuclideanEdgeWeightedGraph {
    private int V;
    private int E;
    private SeparateChainingHashST<Point2D, LinkedBag<EuclideanEdge>> adj;

    // Initialize an empty Euclidean edge-weighted graph from an input stream.
    public EuclideanEdgeWeightedGraph(In in) {
        ...
    }
    
    // Number of vertices in this Euclidean edge-weighted graph.
    public int V() {
        ...
    }

    // Number of edges in this Euclidean edge-weighted graph.
    public int E() {
        ...
    }

    // Add an undirected edge to this Euclidean edge-weighted graph.
    public void addEdge(EuclideanEdge e) {
        ...
    }

    // Edges incident on vertex v.
    public Iterable<EuclideanEdge> adj(Point2D v) {
        ...
    }

    // All the edges in this Euclidean edge-weighted graph.
    public Iterable<EuclideanEdge> edges() {
        LinkedBag<EuclideanEdge> bag = new LinkedBag<EuclideanEdge>();
        for (Point2D v : adj.keys()) {
            int selfLoops = 0;
            for (EuclideanEdge e : adj(v)) {
                if (e.other(v).hashCode() > v.hashCode()) {
                    bag.add(e);
                }
                else if (e.other(v).equals(v)) {
                    if (selfLoops % 2 == 0) bag.add(e);
                    selfLoops++;
                }
            }
        }
        return bag;
    }

    // A string representation of this Euclidean edge-weighted graph.
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + "\n");
        for (Point2D v : adj.keys()) {
            s.append(v + ": ");
            for (EuclideanEdge e : adj(v)) {
                s.append(e + "  ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        In in = new In(args[0]);
        EuclideanEdgeWeightedGraph G = new EuclideanEdgeWeightedGraph(in);
        for (EuclideanEdge e : G.edges()) {
            StdOut.println(e);
        }
    }
}
