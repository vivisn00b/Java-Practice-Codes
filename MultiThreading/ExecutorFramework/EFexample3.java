package MultiThreading.ExecutorFramework;

import java.util.concurrent.*;

public class EFexample3 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();   //Runs tasks one by one in the order they are submitted.
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
