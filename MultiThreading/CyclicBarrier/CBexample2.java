package MultiThreading.CyclicBarrier;

import java.util.concurrent.*;

public class CBexample2 {
    public static void main(String[] args) {
        int workers = 3;

        CyclicBarrier barrier = new CyclicBarrier(workers, () -> {
            System.out.println("All workers reached barrier. Proceeding together...");
            // When all 3 have arrived, run that little Runnable (the barrier action).
            // After that, release all waiting threads.
            // Then reset the barrier for next use (that’s the “cyclic” magic).
        });

        ExecutorService executor = Executors.newFixedThreadPool(workers);

        for (int i = 1; i <= workers; i++) {
            final int id = i;
            executor.submit(() -> {
                try {
                    System.out.println("Worker " + id + " doing phase 1");
                    Thread.sleep(1000 * id);

                    System.out.println("Worker " + id + " waiting at barrier");
                    barrier.await(); // wait for others

                    System.out.println("Worker " + id + " doing phase 2");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}
