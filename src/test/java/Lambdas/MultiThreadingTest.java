package Lambdas;

import org.testng.annotations.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MultiThreadingTest {

    // Shared resource across test invocations
    private static final SharedTestResource sharedResource = new SharedTestResource();
    // ThreadLocal variable to hold test-specific data
    private static final ThreadLocal<String> threadLocalTestId = new ThreadLocal<>();

    @Test(threadPoolSize = 3, invocationCount = 3)
    public void accessSharedResourceTest() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started.");
        sharedResource.incrementCounter(threadName);
        System.out.println(threadName + " finished with counter: " + sharedResource.getCounter());
    }

    @Test
    public void safeCounterTest() throws InterruptedException {
        SafeCounter safeCounter = new SafeCounter();
        UnsafeCounter unsafeCounter = new UnsafeCounter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                safeCounter.incrementSafe();
                unsafeCounter.incrementNotSafe();
            }
        };

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int finalSafeValue = safeCounter.getValueSafe();
        int finalUnsafeValue = unsafeCounter.getValueNotSafe();
        System.out.println("Final safe counter value: " + finalSafeValue);
        System.out.println("Final unsafe counter value: " + finalUnsafeValue);
    }

    @Test(invocationCount = 3, threadPoolSize = 3)
    public void threadLocalTest() {
        String threadName = Thread.currentThread().getName();
        String testId = "TestID-" + threadName;

        // Set ThreadLocal value
        threadLocalTestId.set(testId);

        // Simulate using the ThreadLocal value
        System.out.println(threadName + " started with " + threadLocalTestId.get());

        // Clean up after use
        threadLocalTestId.remove();
    }

    @Test
    public void completableFuture1() throws ExecutionException, InterruptedException {
        // Run async task that returns a result
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);  // Simulate delay
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello from async";
        });

        // Do something after it's done
        CompletableFuture<String> finalResult = future.thenApply(result -> result + " - Completed");

        // Get the result (waits if not done yet)
        System.out.println("Result: " + finalResult.get());
    }

    @Test
    public void completableFutureTest2() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10)
                .thenApply(x -> x * 2)
                .thenApply(x -> x + 3); // Final result: (10 * 2) + 3 = 23

        System.out.println("Result: " + future.get());
    }

    @Test
    public void completableFutureTest3() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 5);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 10);

        CompletableFuture<Integer> combined = future1.thenCombine(future2, (a, b) -> a + b);

        System.out.println("Sum: " + combined.get());
    }
}
