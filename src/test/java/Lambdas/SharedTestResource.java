package Lambdas;

public class SharedTestResource {
    private int counter = 0;

    // Synchronized to avoid race conditions
    public synchronized void incrementCounter(String threadName) {
        counter++;
        System.out.println(threadName + " increment counter to: " + counter);
    }

    public int getCounter() {
        return counter;
    }

}
