import edu.princeton.cs.algs4.StdOut;

public class ShannonEntropy {
    // Returns lg(x), ie, base 2 logarithm of x.
    private static double lg(double x) {
        return Math.log(x) / Math.log(2.0);
    }

    // Returns the Shannon entropy of the items in a[].
    private static double entropy(Comparable[] a) {
        double entropy = 0.0;
        Comparable [] list = new Comparable [a.length];
        boolean f = false;
        int index = 0;
        
        for (int i = 0; i < a.length; i++) {
            for (Comparable t : list)
                if (t == a[i]) {
                    f = true;
                }
            if (f) continue; 
            int q = 0;
            for (int j = 0; j < a.length; j++)
                if (a[j] == a[i]) q++;
                    double e = (double) q / a.length;
                    entropy += (e*lg(e));
                    list[index++] = a[i];
        }     
        entropy *= -1 / lg(a.length);
        return entropy;
    }
    
    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int x = Integer.parseInt(args[1]);
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = i % x;
        }
        StdOut.printf("H = %4.2f\n", entropy(a));
    }
}
