package Multithreading.ConcurrentMap;

import Multithreading.synchronization.CallableIncrement;
import Multithreading.synchronization.IncrementSynchronisation;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcurrentMapMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        IncrementSynchronisation incrementSynchronisation = new IncrementSynchronisation();
        List<Callable<Integer>> callables = Stream.generate(() -> new CallableIncrement(incrementSynchronisation))
                .limit(1000)
                .collect(Collectors.toList());
        int count = 0;



        executor.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);
        executor.shutdown();
    }
}
