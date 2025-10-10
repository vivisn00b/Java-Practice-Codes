package Collections.MapInterface.ConcurrentHashMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrencyDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> cHashMap = new ConcurrentHashMap<>();
        Runnable writer = () -> {
            for (int i = 0; i < 100; i++) {
                cHashMap.put(i, Thread.currentThread().getName()+"-"+i);
                System.out.println("{" + i + " = " + Thread.currentThread().getName()+"-"+i + "}");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {}
            }
        };

        Runnable reader = () -> {
            for (int i = 0; i < 1000; i++) {
                String val = cHashMap.get(i);
                System.out.println(Thread.currentThread().getName() + " read: key=" + i + ", value=" + val);
            }
        };
        Thread t1 = new Thread(writer, "Writer-1");
        Thread t2 = new Thread(writer, "Writer-2");
        Thread t3 = new Thread(reader, "Reader-1");
        Thread t4 = new Thread(reader, "Reader-2");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {}
        System.out.println(cHashMap.size()); // 100 (because the later thread will overwrite similar key entry of the previous thread)
        for (Map.Entry<Integer, String> entry : cHashMap.entrySet()) {
            System.out.println(entry);
        }
    }
}
