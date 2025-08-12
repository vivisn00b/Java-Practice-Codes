package MultiThreading.ExecutorFramework;

//public class EFexample {
//    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//        for (int i = 1; i < 10; i++) {
//            int factI = i;   // Effectively final: never reassigned after initialization, even if not marked final
//            Thread t1 = new Thread(
//                    () ->{
//                        long result = factorial(factI);
//                        System.out.println(result);
//                    }
//            );
//            t1.start();
//        }
//        System.out.println("Total time consumed: " + (System.currentTimeMillis() - startTime));
//    }
//
//    private static long factorial(int n) {
//        try {
//            Thread.sleep(800);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        long result = 1;
//        for (int i = 1; i < n; i++) {
//            result *= i;
//        }
//        return result;
//    }
//}

// Manual Thread Creation and NO REUSE of Threads
//public class EFexample {
//    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//        Thread[] threads = new Thread[9];
//        for (int i = 1; i < 10; i++) {
//            int factI = i;   // Effectively final: never reassigned after initialization, even if not marked final
//            threads[i-1] = new Thread(
//                    () ->{
//                        long result = factorial(factI);
//                        System.out.println(result);
//                    }
//            );
//            threads[i-1].start();
//        }
//        System.out.println("Total time consumed: " + (System.currentTimeMillis() - startTime));
//    }
//
//    private static long factorial(int n) {
//        try {
//            Thread.sleep(800);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        long result = 1;
//        for (int i = 1; i < n; i++) {
//            result *= i;
//        }
//        return result;
//    }
//}

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class EFexample {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(9);
        for (int i = 1; i < 10; i++) {
            int factI = i;   // Effectively final: never reassigned after initialization, even if not marked final
            executorService.submit(
                    () ->{
                        long result = factorial(factI);
                        System.out.println(result);
                    }
            );
        }
        executorService.shutdown();
        // If you want to print after all the threads completes its execution
        try {
            executorService.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total time consumed: " + (System.currentTimeMillis() - startTime));
    }

    private static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
