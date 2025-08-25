package MultiThreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

public class CFdemo {
    public static void main(String[] args) {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Worker thread inside F1");
            } catch (InterruptedException e) {}
            return "OK";
        });
        String str =null;
//        try {
//            str = f1.get();
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        str = f1.getNow("Value absent");
        System.out.println("F1 returned: " + str);
        System.out.println("Main thread...");
    }
}
