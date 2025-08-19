// CyclicBarrier -> reusable checkpoint, resets automatically.
// Latch is good for “wait until N tasks finish.”
// Barrier is good for “let’s all reach this point, then move together.”
package MultiThreading.CyclicBarrier;

import java.util.concurrent.*;

public class CBexample {
    public static void main(String[] args) {
        int n = 3;
        ExecutorService exec = Executors.newFixedThreadPool(n);
        CyclicBarrier barrier = new CyclicBarrier(n);
        exec.submit(new SubSystem(barrier));
        exec.submit(new SubSystem(barrier));
        exec.submit(new SubSystem(barrier));
        System.out.println("Main thread...");
//        barrier.getNumberWaiting();
//        barrier.reset();
//        barrier.getParties();
        exec.shutdown();
    }
}

class SubSystem implements Callable<Integer> {

    private CyclicBarrier barrier;
    public SubSystem(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " service started");
        Thread.sleep(1500);
        System.out.println(Thread.currentThread().getName() + " is waiting...");
        barrier.await();  // CyclicBarrier never blocks the main thread
        return 0;
    }
}