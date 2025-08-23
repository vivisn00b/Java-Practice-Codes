package MultiThreading.CyclicBarrier;

import java.util.concurrent.*;

public class CBcycles {
    public static void main(String[] args) {
        // Barrier with 3 parties and a barrier action
        CyclicBarrier barrier = new CyclicBarrier(3, () ->
                System.out.println("== All parties reached the barrier ==")
        );

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 3; i++) {
            final int id = i;
            executor.submit(() -> {
                try {
                    // -------- Phase 1 --------
                    System.out.println("Thread " + id + " working in Phase 1");
                    Thread.sleep(1000 * id);
                    barrier.await(); // sync point
                    System.out.println("Thread " + id + " finished Phase 1");

                    // -------- Phase 2 --------
                    System.out.println("Thread " + id + " working in Phase 2");
                    if (id == 3) Thread.sleep(5000); // slow thread 3
                    barrier.await(2, TimeUnit.SECONDS); // shorter timeout
                    System.out.println("Thread " + id + " finished Phase 2");

                } catch (TimeoutException e) {
                    System.out.println("Thread " + id + " timed out at Phase 2");
                } catch (BrokenBarrierException e) {
                    System.out.println("Thread " + id + " barrier broken at Phase 2");
                } catch (InterruptedException e) {
                    System.out.println("Thread " + id + " interrupted");
                }

//                try {
//                    // -------- Phase 3 --------
//                    System.out.println("Thread " + id + " working in Phase 3");
//                    barrier.await();
//                    System.out.println("Thread " + id + " finished Phase 3");
//                } catch (Exception e) {
//                    System.out.println("Thread " + id + " problem at Phase 3: " + e);
//                }
                // Threads enter Phase 3, call await(), and hit BrokenBarrierException (just like before).
                // But now they don’t give up. They loop, sleep a little, and try again.
                // Meanwhile the main thread resets the barrier.
                boolean phase3Done = false;
                while (!phase3Done) {
                    try {
                        System.out.println("Thread " + id + " working in Phase 3");
                        barrier.await();  // will succeed only after reset
                        System.out.println("Thread " + id + " finished Phase 3");
                        phase3Done = true;
                    } catch (BrokenBarrierException e) {
                        System.out.println("Thread " + id + " saw broken barrier at Phase 3, retrying...");
                        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
                    } catch (InterruptedException e) {
                        System.out.println("Thread " + id + " interrupted at Phase 3");
                        return;
                    }
                }
            });
        }

        // Give threads time to fail at Phase 2
        try { Thread.sleep(6000); } catch (InterruptedException ignored) {}

        // Reset barrier so Phase 3 can work
        System.out.println("== Resetting barrier for Phase 3 ==");
        barrier.reset();

        executor.shutdown();
    }
}
