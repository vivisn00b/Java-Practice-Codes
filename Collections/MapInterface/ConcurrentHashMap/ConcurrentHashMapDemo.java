// ConcurrentHashMap is a thread-safe implementation of the Map interface.
// It allows multiple threads to read and write data simultaneously, without the need for locking the entire map.
// No null key or value

package Collections.MapInterface.ConcurrentHashMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentMap<Integer, String> map =  new ConcurrentHashMap<>();  // ConcurrentMap is implemented by ConcurrentHashMap
        map.put(1, "Map");
        map.put(2, "ConcurrentMap");
        map.put(3, "ConcurrentNavigableMap");
        map.put(4, "ConcurrentHashMap");

        // Java 7 --> segment based locking --> 16 segments --> smaller hashmaps
        // Only the segment being written to or read from is locked
        // read: do not require locking unless there is a write operation happening on the same segment
        // write: lock

        // java 8 --> no segmentation
        //        --> Compare-And-Swap approach --> no locking except resizing or collision
        // Thread A last saw --> x = 45
        // Thread A work --> x to 50
        // if x is still 45, then change it to 50 else don't change and retry

        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("A", 1);
        concurrentHashMap.put("B", 2);
        concurrentHashMap.put("C", 3);
        System.out.println("Map size: " + concurrentHashMap.size());
        System.out.println("Value of A: " + concurrentHashMap.get("A"));
        concurrentHashMap.remove("B");
        System.out.println("After removal map size is: " + concurrentHashMap.size());
        // Here we cant add 4 because "C" key is already present in ConcurrentHashMap object
        concurrentHashMap.putIfAbsent("C", 4);
        System.out.println(concurrentHashMap);

        Map<Integer, String> cHashMap = new ConcurrentHashMap<>();
        cHashMap.put(1, "Apple");
        cHashMap.put(2, "Banana");
        System.out.println("Size: " + cHashMap.size());
        System.out.println("Get 2: " + cHashMap.get(2));
        System.out.println("Contains 'Banana': " + cHashMap.containsValue("Banana"));
        cHashMap.replace(2, "Banana", "Orange");
        System.out.println("After replace: " + cHashMap.get(2));
        cHashMap.remove(2, "Orange"); // Remove only if value matches
        System.out.println("After remove: " + cHashMap);
        // Safe iteration example
        for (Integer key : cHashMap.keySet()) {
            cHashMap.put(key + 10, "Fruit" + key); // safe to update during iteration
        }
        System.out.println("After iteration and update: " + cHashMap);
    }
}
