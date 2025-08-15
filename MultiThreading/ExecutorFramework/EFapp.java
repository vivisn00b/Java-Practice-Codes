package MultiThreading.ExecutorFramework;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.*;

class Processor implements Runnable {
    private int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting: " + id);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
        System.out.println("Completed: " + id);
    }
}

public class EFapp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exe = Executors.newFixedThreadPool(3);
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            //exe.submit(new Processor(i));
            //Future<?> future = exe.submit(new Processor(i), "Task-" + i + " submitted");
            futures.add(exe.submit(new Processor(i), "Task-" + i + " submitted by " + Thread.currentThread().getName()));
            //System.out.println("Future result: " + future.get()); // It immediately calls future.get(), which blocks until that task finishes. Only then does it submit the next one.
        }
        // collect results without blocking submission
        for (Future<?> future : futures)
            System.out.println("Future result: " + future.get());

        exe.shutdown();
        if (exe.awaitTermination(100, TimeUnit.SECONDS)) {
            System.out.println("All tasks completed...");
        }
//        try {
//            exe.awaitTermination(100, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {}
//        System.out.println("All tasks completed...");
    }
}
