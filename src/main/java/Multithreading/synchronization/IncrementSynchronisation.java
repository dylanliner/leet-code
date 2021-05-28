package Multithreading.synchronization;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class IncrementSynchronisation {
    ReentrantLock lock = new ReentrantLock();
    int count = 0;

    AtomicInteger atomicInteger = new AtomicInteger(0);;

    public synchronized void  increment() {
        count = count + 1;
    }

     void  increment2() {
         lock.lock();
         try {
             count++;
         } finally {
             lock.unlock();
         }
    }
}
