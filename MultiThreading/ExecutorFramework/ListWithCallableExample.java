package MultiThreading.ExecutorFramework;

import java.util.*;
import java.util.concurrent.*;

public class ListWithCallableExample {
    public static void main(String[] args) throws Exception {
//        ExecutorService exe = Executors.newFixedThreadPool(2);
//        Callable<Integer> callable1 = () -> 1;
//        Callable<Integer> callable2 = () -> 2;
//        Callable<Integer> callable3 = () -> 3;
//        Callable<Integer> callable4 = () -> 4;
//        List<Callable<Integer>> listCallable = Arrays.asList(callable1, callable2, callable3, callable4);
//        List<Future<Integer>> futures = exe.invokeAll(listCallable);
//        exe.shutdown();

//        ExecutorService exe = Executors.newFixedThreadPool(2);
//        Callable<Integer> callable1 = () -> {
//            System.out.println("Task 1");
//            return 1;
//        };
//        Callable<Integer> callable2 = () -> {
//            System.out.println("Task 2");
//            return 2;
//        };
//        Callable<Integer> callable3 = () -> {
//            System.out.println("Task 3");
//            return 3;
//        };
//        List<Callable<Integer>> listCallable = Arrays.asList(callable1, callable2, callable3);
//        List<Future<Integer>> futures = exe.invokeAll(listCallable); // Blocks the main thread and keeps it waiting until all tasks completed and returns list of futures
//        exe.shutdown();

        ExecutorService exe = Executors.newFixedThreadPool(3);
        Callable<Integer> callable1 = () -> {
            Thread.sleep(800);
            System.out.println("Task 1");
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            Thread.sleep(500);
            System.out.println("Task 2");
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 3");
            return 3;
        };
        List<Callable<Integer>> listCallable = Arrays.asList(callable1, callable2, callable3);

        //List<Future<Integer>> futures = exe.invokeAll(listCallable, 1, TimeUnit.SECONDS); // Using timeout

        Integer i = exe.invokeAny(listCallable); // Doesn't wait for all task to finish, instead returns the result of the task that finishes first
        System.out.println(i);

        exe.shutdown();

//        ExecutorService executor = Executors.newFixedThreadPool(3);
//        List<Callable<String>> tasks = Arrays.asList(
//                () -> { Thread.sleep(1000); return "Task 1"; },
//                () -> { Thread.sleep(500); return "Task 2"; },
//                () -> { Thread.sleep(2000); return "Task 3"; }
//        );
//        List<Future<String>> fList = executor.invokeAll(tasks);
//        for (Future<String> future : fList) {
//            System.out.println(future.get());
//        }
//        executor.shutdown();
    }
}
