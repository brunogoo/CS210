import edu.princeton.cs.algs4.StdOut;

// ThreeDice.java: Writes the sum of three random integers between 1 and 6, such
// as you might get when rolling three dice.
public class ThreeDice {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);

        StdOut.print(Math.min(x,z) );
    }
}
