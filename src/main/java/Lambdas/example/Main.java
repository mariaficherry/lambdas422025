package Lambdas.example;

public class Main {
    public static void main(String[] args) {
        for(int i=0;i<=5;i++){
        MyThreadForMain myThread = new MyThreadForMain(i);
        myThread.start();
        }

        MyThreadForMain myThread2 = new MyThreadForMain(6);
        Thread myRunnable = new Thread(myThread2);

        myRunnable.start();
    }
}