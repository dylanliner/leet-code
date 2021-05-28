package Multithreading.synchronization;

import java.util.concurrent.Callable;

public class CallableIncrement implements Callable<Integer> {

    final IncrementSynchronisation incrementSynchronisation;

    public CallableIncrement(IncrementSynchronisation incrementSynchronisation) {
        this.incrementSynchronisation = incrementSynchronisation;
    }

    @Override
    public Integer call() throws Exception {
        return incrementSynchronisation.atomicInteger.incrementAndGet();

    }
}
