package MultiThreading.CompletableFuture;

import java.util.concurrent.*;

public class CFmethods {
    public static void main(String[] args) {
        // runs something that doesn’t return a result
        CompletableFuture<Void> f1= CompletableFuture.runAsync(() -> System.out.println("No return"));
        f1.thenRun(() -> System.out.println(000000)); // ignores result, just runs something
        CompletableFuture<Integer> a = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> b = CompletableFuture.supplyAsync(() -> 20);
        a.thenCombine(b, (x,y) -> x+y)  // combine two futures’ results
                .thenAccept(sum -> System.out.println("Sum: " + sum));
        // consume two results, no return
        b.thenAcceptBoth(a, (result1, result2) -> System.out.println(result1 * result2));
        // run after both, no input/return
        a.runAfterBoth(b, () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("runAfterBoth method");
        });

        CompletableFuture<String> fast = CompletableFuture.supplyAsync(() -> "Fast!");
        CompletableFuture<String> slow = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(2000); } catch (Exception ignored) {}
            return "Slow!";
        });
        // whichever finishes first wins
        fast.applyToEither(slow, res -> "Winner: " + res)
                .thenAccept(System.out::println);
        // acceptEither(other, consumer) → like above but no return
        // run something after first done
        fast.runAfterEither(slow, () -> System.out.println("Running " + Thread.currentThread().getName() + " thread"));

        // Composing Async Task
        CompletableFuture<Integer> base = CompletableFuture.supplyAsync(() -> 5);
        // take result of one future, return another future
        base.thenCompose(n -> CompletableFuture.supplyAsync(() -> n * 2))
                .thenAccept(System.out::println);
        // wait until all are complete
        CompletableFuture<Void> all = CompletableFuture.allOf(a, b, f1);
        all.thenRun(() -> System.out.println("a, b, f1 finished!"));

        //Error Handling: Async pipelines need error handling or else you'll get silent deaths
        //
        // supplyAsync().thenApply().thenAccept()), everything runs asynchronously in background threads.
        // If something throws an exception inside one of those tasks, the future doesn’t crash your program like normal code would, it just silently marks that future as "completed exceptionally".
//        CompletableFuture<Integer> risky = CompletableFuture.supplyAsync(() -> {
//            if (true) throw new RuntimeException("Boom!");
//            return 42;
//        });
//
//        risky.exceptionally(ex -> {
//            System.out.println("Recovered from: " + ex);
//            return -1;
//        }).thenAccept(System.out::println);
        CompletableFuture<Integer> hazard = CompletableFuture.supplyAsync(() -> {
            return 10/0;
        });
        hazard.thenApply(n -> n*2)
                .thenAccept(System.out::println); //these never run
        hazard.exceptionally(ex -> {
            System.out.println("Error: " + ex);
            return -1; // fallback value
        }).thenAccept(System.out::println);

        // manual completion
        CompletableFuture<String> cf = new CompletableFuture<>();
        new Thread(() -> {
            try { Thread.sleep(1000); } catch (Exception ignored) {}
            cf.complete("Hello from another thread");  // complete successfully
        }).start();
        cf.thenAccept(System.out::println);
        // completeExceptionally(ex) → complete with failure
        //obtrudeValue(value) → force override value even if completed

        // Timeouts
        CompletableFuture<String> slowTask = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(4000);
            } catch (Exception e) {}
            return "Done...";
        });
        slowTask.orTimeout(2, TimeUnit.SECONDS)  // auto-fails if not done in time
                .exceptionally(ex -> "Timed out!!!")
                .thenAccept(System.out::println);
        // completeOnTimeout(value, timeout, unit) → fallback if too slow
    }
}
