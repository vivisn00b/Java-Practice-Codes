package MultiThreading.ThreadSafety;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicClass {
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicClass atomic = new AtomicClass();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomic.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomic.increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Vlaue: " + atomic.getCounter());
    }
}
