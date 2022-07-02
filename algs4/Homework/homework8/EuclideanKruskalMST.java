import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinkedQueue;
import edu.princeton.cs.algs4.StdOut;

public class EuclideanKruskalMST {
    private double weight; 
    private LinkedQueue<EuclideanEdge> mst; 

    // Compute a minimum spanning tree (or forest) of an Euclidean 
    // edge-weighted graph.
    public EuclideanKruskalMST(EuclideanEdgeWeightedGraph G) {
        ...
    }

    // Edges in a minimum spanning tree (or forest).
    public Iterable<EuclideanEdge> edges() {
        ...
    }

    // Sum of the edge weights in a minimum spanning tree (or forest).
    public double weight() {
        ...
    }
    
    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        In in = new In(args[0]);
        EuclideanEdgeWeightedGraph G = new EuclideanEdgeWeightedGraph(in);
        EuclideanKruskalMST mst = new EuclideanKruskalMST(G);
        for (EuclideanEdge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
    }
}
