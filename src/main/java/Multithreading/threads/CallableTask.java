package Multithreading.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableTask implements Callable {
    @Override
    public Object call() throws Exception {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("hello");
            return 123;
        }
        catch (InterruptedException e) {
            throw new IllegalStateException("task interrupted", e);
        }
    }
}
