package MultiThreading.CompletableFuture;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class CFuture {
    public static void main(String[] args) {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {}
            return 50;
        });
        // Chain multiple task
        cf1.thenApply(n -> n*2)
                .thenApply(n -> "Result: " + n)
                .thenAccept(System.out::println);

        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> 10);
        // Combine two tasks
        cf1.thenCombine(cf2, (x, y) -> x+y)
                .thenAccept(sum -> System.out.println("Sum: " + sum));
        // Run after both tasks
        CompletableFuture<Void> both = CompletableFuture.allOf(cf1, cf2);
        both.thenRun(() -> System.out.println("Both finished!"));

        CompletableFuture<String> fast = CompletableFuture.supplyAsync(() -> "Fast");
        CompletableFuture<String> slow = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Slow";
        });
        // First result wins
        CompletableFuture.anyOf(fast, slow)
                .thenAccept(System.out::println);
    }
}
