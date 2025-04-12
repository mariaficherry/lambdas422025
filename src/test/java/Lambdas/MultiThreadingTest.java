package Lambdas;

import org.testng.annotations.Test;

public class MultiThreadingTest {

    @Test
    public void multiThreadingThreadExample() {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
