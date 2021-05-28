package Multithreading.threads;

import java.util.concurrent.*;

public class ScheduledCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());

        int initialDelay = 0;
        int period = 1;
        executor.schedule(new CallableTask(), initialDelay, TimeUnit.SECONDS);

    }
}
