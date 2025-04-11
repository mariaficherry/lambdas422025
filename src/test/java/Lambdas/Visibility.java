package Lambdas;

public class Visibility {
    public int x;   // Accessible anywhere
    private int y;  // Only accessible in this class
    protected int z;    // Accessible in the same package and subclasses
    int w;  // Default access (package-private)
}
