package MultiThreading.ExecutorFramework;

import java.util.RandomAccess;
import java.util.concurrent.*;
import java.util.Random;

class CallableTest implements Callable {
    @Override
    public Object call() throws Exception {
        Random generator = new Random();
        Integer randomNumber = generator.nextInt(100);
        Thread.sleep(2000);
        return randomNumber;
    }
}

public class CallableEx {
    public static void main(String[] args) {
        FutureTask[] randNo = new FutureTask[5];
        for (int i = 1; i <= 5; i++) {
            Callable callable = new CallableTest();
            randNo[i] = new FutureTask(callable);
            Thread t = new Thread(randNo[i]);
        }
    }
}
