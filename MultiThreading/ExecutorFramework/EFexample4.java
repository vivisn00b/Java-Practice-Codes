package MultiThreading.ExecutorFramework;

import java.util.concurrent.*;

public class EFexample4 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        // Task after 2 secs
        scheduler.schedule(() -> {
            System.out.println("Run after 2 secs by " + Thread.currentThread().getName());
        }, 2, TimeUnit.SECONDS);
        // Task every 3 sec, delay is from start time (overlaps runs)
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Repeating task on " + Thread.currentThread().getName());
        }, 1, 3, TimeUnit.SECONDS);
        // Task after 4 sec from end time of the previous task (no overlap)
        scheduler.scheduleWithFixedDelay(() -> System.out.println("Task executed after 4 seconds by " + Thread.currentThread().getName()), 2, 4, TimeUnit.SECONDS);
        // Stop after 10 seconds
        scheduler.schedule(() -> {
            System.out.println("Shutting down scheduler");
            scheduler.shutdown();  // shutdown() must be triggered from inside another scheduled task because you decide dynamically when to stop the cycle.
        }, 10, TimeUnit.SECONDS);
    }
}
