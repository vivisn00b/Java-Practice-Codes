// It is a thread-safe implementation of the Set interface in Java.
// It is backed by a CopyOnWriteArrayList and is optimized for concurrent read-heavy operations.
// Iterators work over an immutable snapshot of the set; modifications after iterator creation are invisible during iteration.

package Collections.SetInterface.CopyOnWriteArraySet;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo {
    public static void main(String[] args) {
        // Thread-Safe
        // Copy-On-Write Mechanism
        // No Duplicate Elements
        // Iterators Do Not Reflect Modifications

        CopyOnWriteArraySet<Integer> copyOnWriteSet = new CopyOnWriteArraySet<>();
        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();

        for (int i = 1; i <= 5; i++) {
            copyOnWriteSet.add(i);
            concurrentSkipListSet.add(i);
        }

        System.out.println("Initial CopyOnWriteArraySet: " + copyOnWriteSet);
        System.out.println("Initial ConcurrentSkipListSet: " + concurrentSkipListSet);

        System.out.println("\nIterating and modifying CopyOnWriteArraySet:");
        for (Integer num : copyOnWriteSet) {
            System.out.println("Reading from CopyOnWriteArraySet: " + num);
            // Attempting to modify the set during iteration
            copyOnWriteSet.add(6);  // won't print it while iterating
        }

        System.out.println("\nIterating and modifying ConcurrentSkipListSet:");
        for (Integer num : concurrentSkipListSet) {
            //System.out.println("Reading from ConcurrentSkipListSet: " + num);
            // Attempting to modify the set during iteration
            //concurrentSkipListSet.add(6);  // will print this while iterating
            if (num == 5)
                concurrentSkipListSet.add(6);  // won't print this... hence this is not consistent
        }

        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        set.add("Java");
        set.add("OOP");
        set.add("Threads");
        set.add("Collections");
        set.add("OOP"); //duplicate elements are ignored
        System.out.println("Initial set: " + set);
        new Thread(() -> {
            set.add("Streams");
            System.out.println("Added new element in set");
        }).start();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {}
        Iterator<String> itr = set.iterator();
        while (itr.hasNext())
            System.out.println("Reading: " + itr.next());
        System.out.println("Contains 'Threads'? " + set.contains("Threads"));
        System.out.println("Size: " + set.size());
        set.remove("Collections");
        System.out.println("After removal: " + set);
        set.clear();
        System.out.println("After clear, set is empty? " + set.isEmpty());
        set.addAll(Arrays.asList("Java", "is", "fun"));
        System.out.println("New set: " + set);
        Object[] arr = set.toArray();  // or String[] arr = set.toArray(new String[0]);
        System.out.println(Arrays.toString(arr));
    }
}
