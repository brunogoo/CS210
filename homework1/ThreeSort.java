// ThreeSort.java: Takes three integers as command-line arguments and writes
// them in ascending order, separated by spaces.

import edu.princeton.cs.algs4.StdOut;

public class ThreeSort {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        int max = Math.max(x, Math.max(y,z));
        int min = Math.min(x, Math.min(y,z));
        int mid = (x+y+z)- min - max;

        StdOut.println(min + " "+ mid + " "+max);

    }
}
