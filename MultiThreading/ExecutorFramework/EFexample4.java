package MultiThreading.ExecutorFramework;

import java.util.concurrent.*;

public class EFexample4 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        // Task after 2 secs
        scheduler.schedule(() -> {
            System.out.println("Run after 2 secs by " + Thread.currentThread().getName());
        }, 2, TimeUnit.SECONDS);
        // Task every 1 sec
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Repeating task on " + Thread.currentThread().getName());
        }, 1, 1, TimeUnit.SECONDS);
        // Stop after 10 seconds
        scheduler.schedule(() -> {
            System.out.println("Shutting down scheduler");
            scheduler.shutdown();
        }, 10, TimeUnit.SECONDS);
    }
}
