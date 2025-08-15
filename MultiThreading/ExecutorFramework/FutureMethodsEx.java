package MultiThreading.ExecutorFramework;

import java.util.concurrent.*;

public class FutureMethodsEx {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> task = () -> {
            Thread.sleep(2000);
            return "Done!";
        };

        Future<String> future = executor.submit(task);

        System.out.println("isDone? " + future.isDone());

        try {
            System.out.println("Result: " + future.get(1, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            System.out.println("Task took too long, cancelling...");
            future.cancel(true);
        }

        System.out.println("isCancelled? " + future.isCancelled());
        System.out.println("isDone? " + future.isDone());

        executor.shutdown();
    }
}
