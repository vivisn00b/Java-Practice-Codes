package MultiThreading.ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureCancelDilemma {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        Future<Integer> future = exec.submit(() ->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Execption: " + e);
            }
            System.out.println("Hello");
            return 1;
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e);
        }
        future.cancel(false);
        try {
            exec.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Is done: " + future.isDone());
        System.out.println("Is cancelled: " + future.isCancelled()); // Even tho not cancelled, it will print true
        exec.shutdown();
    }
}
