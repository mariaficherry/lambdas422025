package Lambdas;

public class UnsafeCounter {
    private int counter = 0;

    // Not Thread-safe
    public void incrementNotSafe() {
        counter++;
    }

    public int getValueNotSafe() {
        return counter;
    }
}
