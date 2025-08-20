package MultiThreading.CyclicBarrier;

import java.util.concurrent.*;

public class CBmethods {
    public static void main(String[] args) {
        int parties = 3;
        CyclicBarrier barrier = new CyclicBarrier(parties, () -> {
            System.out.println("BARRIER ACTION: All parties have arrived");
        });

        ExecutorService executor = Executors.newFixedThreadPool(parties);

        for (int i = 1; i <= parties; i++) {
            final int id = i;
            executor.submit(() -> {
                System.out.println("Worker " + id + " doing phase 1");
                try {
                    Thread.sleep(1000 * id);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Worker " + id + " waiting at barrier (current waiting: " + barrier.getNumberWaiting() + "/" + barrier.getParties() + ")");
                // Tells you how many threads are currently parked at the barrier, waiting for others. / Returns how many threads are required to trip the barrier (the fixed number from constructor).
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Worker " + id + " passed barrier. Doing phase 2...");
                if (id == 3) {
                    System.out.println("Worker " + id + " simulating longer delay...");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Worker " + id + " waiting at barrier (cycle 2)");
                try {
                    barrier.await(2, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    System.out.println("Worker " + id + " interrupted!");
                } catch (BrokenBarrierException e) {
                    System.out.println("Worker " + id + " saw broken barrier!");
                } catch (TimeoutException e) {
                    System.out.println("Worker " + id + " timed out at barrier!");
                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Now main thread inspects barrier state
        System.out.println("Barrier broken? " + barrier.isBroken());
        // Returns true if the barrier is in a broken state.
        //
        //A barrier becomes broken if:
        //A waiting thread is interrupted,
        //A waiting thread times out, or
        //Something fails in the barrier action.

        // Reset barrier for reuse
        barrier.reset();
        System.out.println("Barrier reset. Broken? " + barrier.isBroken());
        // Useful if something went wrong (like a timeout) and you want to reuse it.
        //
        //Any threads currently waiting will get a `BrokenBarrierException`.
    }
}
