import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Degrees {
    private Digraph G;

    // Construct a Degrees object from a digraph G.
    public Degrees(Digraph G) {
        ...
    }
    
    // Sources of G.
    public Iterable<Integer> sources() {
        ...
    }

    // Sinks of G.
    public Iterable<Integer> sinks() {
        ...
    }

    // Is G a map?
    public boolean isMap() {
        ...
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        Degrees degrees = new Degrees(G);
        StdOut.println("Sources = " + degrees.sources());
        StdOut.println("Sinks   = " + degrees.sinks());
        StdOut.println("Is Map  = " + degrees.isMap());
    }
}
