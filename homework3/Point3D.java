import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// An immutable data type representing a 3D point.
public class Point3D {
    private final double x; // x coordinate
    private final double y; // y coordinate
    private final double z; // z coordinate

    // Construct a point in 3D given its coordinates.
    public Point3D(double x, double y, double z) {
        ...
    }

    // The Euclidean distance between this point and that.
    public double distance(Point3D that) {
        ...
    }

    // A string representation of the point, as "(x, y, z)".
    public String toString() {
        ...
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int n = StdIn.readInt();
        Point3D[] points = new Point3D[n];
        for (int i = 0; i < n; i++) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            double z = StdIn.readDouble();
            points[i] = new Point3D(x, y, z);
        }
        Point3D origin = new Point3D(0, 0, 0);
        for (Point3D point : points) {
            StdOut.println(point + ", distance to origin = "
                           + point.distance(origin));
        }
    }
}
