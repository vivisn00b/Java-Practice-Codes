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
    }
}
