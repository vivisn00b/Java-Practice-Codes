package MultiThreading.ExecutorFramework;

import java.util.concurrent.*;

public class EFexample2 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();   //Creates a new thread for each task initially, then reuses idle threads for new tasks.
        for (int i = 0; i < 10; i++) {
            int taskID = i;
            pool.execute(() -> {
                System.out.println("Task " + taskID + " executed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            });
        }
        pool.shutdown();
    }
}
