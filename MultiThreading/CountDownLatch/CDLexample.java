package MultiThreading.CountDownLatch;

import java.util.concurrent.*;

public class CDLexample {
    public static void main(String[] args) throws InterruptedException {
        int n = 3;
        ExecutorService exec = Executors.newFixedThreadPool(n);
        CountDownLatch latch = new CountDownLatch(n);
        exec.submit(new Service(latch));
        exec.submit(new Service(latch));
        exec.submit(new Service(latch));
        latch.await();  // blocks until the count reaches 0
        System.out.println("Main thread started after waiting for other threads to start...");
        exec.shutdown();
    }
}

class DependentService implements Callable<String> {

    private final CountDownLatch latch;
    public DependentService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(1500);
            System.out.println(Thread.currentThread().getName() + " service started...");
        } finally {
            latch.countDown();  // decrements the count by 1
        }
        return "ok";
    }
}
