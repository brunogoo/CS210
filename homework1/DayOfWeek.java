// DayOfWeek.java: Takes three integers m (for month), d (for day), and y
// (for year) as command-line arguments and writes the day of the week (0 for
// Sunday, 1 for Monday, and so on) D, calculated as follows:
//
// y0 = y - (14 - m) / 12
// x0 = y0 + y0 / 4 - y0 / 100 + y0 / 400
// m0 = m + 12 * ((14 - m) / 12) - 2
// D = (d + x0 + 31 * m0 / 12) % 7

import edu.princeton.cs.algs4.StdOut;

public class DayOfWeek {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        int y0 = y - (14 - m) / 12;
        int x0 = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int D = (d + x0 + 31 * m0 / 12) % 7;
        StdOut.println(D);

        // StdOut.print("c");
    }
}
