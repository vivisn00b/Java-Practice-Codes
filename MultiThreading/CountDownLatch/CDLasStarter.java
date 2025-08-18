package MultiThreading.CountDownLatch;

import java.util.concurrent.*;

public class CDLasStarter {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);

        for (int i = 1; i <= 3; i++) {
            final int id = i;
            new Thread(() -> {
                try {
                    startSignal.await(); // wait for "go"
                    System.out.println("Thread " + id + " running");
                } catch (InterruptedException ignored) {}
            }).start();
        }

// release them all at once
        System.out.println("Ready...set...");
        Thread.sleep(2000);
        startSignal.countDown(); // boom!

    }
}
