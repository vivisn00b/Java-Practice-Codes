package Collections.Hashtable;

import java.util.HashMap;
import java.util.Hashtable;

public class HashtableDemo {
    public static void main(String[] args) {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        // Hashtable is synchronized
        // no null key or value
        // Legacy Class, replaced by ConcurrentHashMap
        // slower than HashMap
        // only a linked list is used in case of collision
        // all methods are synchronized
        hashtable.put(1, "Apple");
        hashtable.put(2, "Banana");
        hashtable.put(3, "Cherry");
        System.out.println(hashtable);
        System.out.println("Value for key 2: " + hashtable.get(2));
        System.out.println("Does key 3 exist? " + hashtable.containsKey(3));
        hashtable.remove(1);
        System.out.println("After removing key 1: " + hashtable);
//        hashtable.put(null, "value"); // Throws exception
//        hashtable.put(4, null);   // Throws exception
    }
}

class SyncTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, "Thread1 - " + i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, "Thread2 - " + i);
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Final size of HashMap: " + map.size());  // will give incorrect value as HashMap is not synchronized

        // Hashtable's every method is synchronized which costs it an overhead
        Hashtable<Integer, String> htMap = new Hashtable<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                htMap.put(i, "Thread1");
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                htMap.put(i, "Thread2");
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final size of HashMap: " + htMap.size());  // will give correct output as Hashtable is synchronized
    }
}
