package MultiThreading.ExecutorFramework;

import java.util.concurrent.*;

public class FutureEx {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exe = Executors.newSingleThreadExecutor();
        //Future<Integer> future = exe.submit(() -> 42);
        //Future<?> future = exe.submit(() -> "Hello"); // uses callable
        //Runnable runnable = () -> System.out.println("Can be done like this way also");  // no return type for runnable
        //Future<?> future = exe.submit(runnable);
        Callable<String> callable = () -> "Has return type";
        Future<?> future = exe.submit(callable);
        System.out.println(future.get()); // get() will block the execution until the task is complete.
        if (future.isDone())
            System.out.println("Task completed!");
        exe.shutdown();
    }
}