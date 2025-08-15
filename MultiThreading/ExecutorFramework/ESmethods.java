package MultiThreading.ExecutorFramework;
import java.util.concurrent.*;
import java.util.*;

public class ESmethods {
    public static void main(String[] args) throws Exception {
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {

            // Single task submissions
            Future<String> f1 = executor.submit(() -> "Callable result");
            Future<?> f2 = executor.submit(() -> System.out.println("Runnable no result"));
            Future<String> f3 = executor.submit(() -> System.out.println("Runnable with result"), "Fixed Result");

            // Bulk task submissions
            List<Callable<String>> tasks = Arrays.asList(
                    () -> "Task 1",
                    () -> "Task 2"
            );
            List<Future<String>> futures = executor.invokeAll(tasks);
            String firstResult = executor.invokeAny(tasks);

            System.out.println(f1.get());
            System.out.println(f3.get());
            for (Future<String> f : futures) {
                System.out.println(f.get());
            }
            System.out.println("First finished: " + firstResult);
        }
        // close() here calls shutdown()

        // shutdown and awaitTermination example:
        ExecutorService another = Executors.newSingleThreadExecutor();
        another.submit(() -> {
            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        });
        another.shutdown();
        another.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Terminated: " + another.isTerminated());
    }
}
