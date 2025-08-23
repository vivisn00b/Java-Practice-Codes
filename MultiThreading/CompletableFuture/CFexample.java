package MultiThreading.CompletableFuture;

import java.util.concurrent.*;

public class CFexample {
    public static void main(String[] args) throws Exception {
        // Run async task
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "Hello";
        });

        // Transform result
        CompletableFuture<String> result = cf.thenApply(s -> s + " World");

        // Print when done
        result.thenAccept(System.out::println);

        // Wait to keep the program alive
        Thread.sleep(2000);
    }

    static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}