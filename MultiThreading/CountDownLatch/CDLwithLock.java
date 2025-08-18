package MultiThreading.CountDownLatch;

import java.util.concurrent.*;

public class CDLwithLock {
    public static void main(String[] args) throws InterruptedException {
        int n = 3;
        CountDownLatch latch = new CountDownLatch(n);
        for (int i = 0; i < 3; i++) {
            new Thread(new Service(latch)).start();
        }
        //latch.await();  // blocks until the count reaches 0
        latch.await(6000, TimeUnit.SECONDS); // blocks for 6 seconds
        System.out.println("Main thread started after waiting for other threads to start...");
    }
}

class Service implements Runnable {

    private final CountDownLatch latch;
    public Service(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1500);
            System.out.println(Thread.currentThread().getName() + " service started...");
        } catch (InterruptedException e) {

        } finally {
            latch.countDown();  // decrements the count by 1
        }
    }
}