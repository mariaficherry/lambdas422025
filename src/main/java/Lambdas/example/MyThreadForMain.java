package Lambdas.example;

public class MyThreadForMain extends Thread {

    // Override run method
    @Override
    public void run() {
        System.out.println("Thread is running");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
