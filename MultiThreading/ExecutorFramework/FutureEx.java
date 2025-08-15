package MultiThreading.ExecutorFramework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureEx {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exe = Executors.newSingleThreadExecutor();
        Future<Integer> future = exe.submit(() -> 42);
        System.out.println(future.get()); // get() will block the execution until the task is complete.
        exe.shutdown();
    }
}