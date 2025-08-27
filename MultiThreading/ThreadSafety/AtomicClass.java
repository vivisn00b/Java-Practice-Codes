package MultiThreading.ThreadSafety;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicClass {
    private AtomicInteger counter = new AtomicInteger(0);
    private AtomicBoolean flag = new AtomicBoolean(false);

    public void increment() throws InterruptedException {
        counter.incrementAndGet();
        if (counter.get() == 2000) {
            // thread-safe toggle
            if (flag.compareAndSet(false, true)) {
                Thread.sleep(1000);
                System.out.println("Flag was false, now set to true");
            }
        }
    }

    public int getCounter() throws InterruptedException {
        Thread.sleep(1500);
        return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicClass atomic = new AtomicClass();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    atomic.increment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    atomic.increment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Vlaue: " + atomic.getCounter());
    }
}
