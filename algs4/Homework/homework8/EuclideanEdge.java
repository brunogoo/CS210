import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;

public class EuclideanEdge implements Comparable<EuclideanEdge> {
    private Point2D v;
    private Point2D w;

    // Construct an Euclidean edge given the end points.
    public EuclideanEdge(Point2D v, Point2D w) {
        ...
    }
    
    // Either endpoint of this edge.
    public Point2D either() {
        ...
    }

    // Endpoint of this edge that is different from the given vertex.
    public Point2D other(Point2D vertex) {
        ...
    }
    
    // Weight of this edge, ie, the Euclidean distance between the endpoints.
    public double weight() {
        ...
    }

    // A string representation of this edge.
    public String toString() {
        return String.format("%s-%s %.5f", v, w, weight());
    }

    // Compare two edges by their weights.
    public int compareTo(EuclideanEdge that) {
        ...
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        double wx = Double.parseDouble(args[0]);
        double wy = Double.parseDouble(args[1]);
        double xx = Double.parseDouble(args[2]);
        double xy = Double.parseDouble(args[3]);
        double yx = Double.parseDouble(args[4]);
        double yy = Double.parseDouble(args[5]);
        double zx = Double.parseDouble(args[6]);
        double zy = Double.parseDouble(args[7]);
        Point2D w = new Point2D(wx, wy);
        Point2D x = new Point2D(xx, xy);
        Point2D y = new Point2D(yx, yy);
        Point2D z = new Point2D(zx, zy);
        EuclideanEdge e1 = new EuclideanEdge(w, x);
        EuclideanEdge e2 = new EuclideanEdge(y, z);
        StdOut.println(e1);
        StdOut.println(e2);
        StdOut.println(e1.compareTo(e2));
    }
}
