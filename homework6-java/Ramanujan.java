// Ramanujan.java: Prints the integers <= N (command-line argument) that can be
// expressed as the sum of two distinct cubes.

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class Ramanujan {
    // A data type that encapsulates a pair of numbers (i, j) 
    // and the sum of their cubes, ie, i^3 + j^3.
    private static class Pair implements Comparable<Pair> {
        private int i;          // first element of the pair
        private int j;          // second element of the pair
        private int sumOfCubes; // i^3 + j^3

        // Construct a pair (i, j).
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
            sumOfCubes = i * i * i + j * j * j;
        }

        // Compare this pair to the other by sumOfCubes.
        public int compareTo(Pair other) {
            return sumOfCubes - other.sumOfCubes;
        } 
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args [0]);
        MinPQ<Pair> pq = new MinPQ<Pair>();
        Pair current = null; 
        Pair last = null;
        for (int i = 1; i * i * i <= n; i++) {
            Pair p = new Pair(i, i + 1); 
            pq.insert(p);
         }        
        while (!pq.isEmpty()) {
            last = current;
            current = pq.delMin();
            if (last != null && current.compareTo(last) == 0
                 && last.sumOfCubes <= n) {
                     StdOut.println(current.sumOfCubes + " = " 
                     + last.i + "^3 " + "+ " 
                     + last.j + "^3 " + "= " + current.i
                     + "^3 " + "+ " + current.j + "^3");
                    }
            if (current.j * current.j * current.j < n) {
                Pair p = new Pair(current.i, current.j + 1);
                pq.insert(p);
            }
        }
    }
}


  
