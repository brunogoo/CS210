import edu.princeton.cs.algs4.StdOut;

// A data type representing a six-sided die.
public class Die {
    private int value; // face value

    // Roll the die.
    public void roll() {
        ...
    }

    // Face value of the die.
    public int value() {
        ...
    }

    // Does the die have the same face value as that?
    public boolean equals(Die that) {
        ...
    }

    // A string representation of the die giving the current face value.
    public String toString() {
        ...
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        Die a = new Die();
        a.roll();
        while (a.value() != x) {
            a.roll();
        }
        Die b = new Die();        
        b.roll();
        while (b.value() != y) {
            b.roll();
        }
        Die c = new Die();        
        c.roll();
        while (c.value() != z) {
            c.roll();
        }
        StdOut.println(a);
        StdOut.println(a.equals(b));
        StdOut.println(b.equals(c));        
    }
}
