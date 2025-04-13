package Lambdas;

public class SafeCounter {

    private int counter = 0;

    // Thread safe
    public synchronized void incrementSafe() {
        counter++;
    }

    public synchronized int getValueSafe() {
        return counter;
    }
}
