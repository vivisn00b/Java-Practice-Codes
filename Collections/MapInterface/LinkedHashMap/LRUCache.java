// Java implementation of an LRU (Least Recently Used) cache using LinkedHashMap.

package Collections.MapInterface.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // Remove eldest entry if size exceeds capacity
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> studentMap = new LRUCache<>(3);
        studentMap.put("Bob", 99);
        studentMap.put("Alice", 85);
        studentMap.put("Ram", 71);
        // Adding new entries beyond capacity triggers eviction of the least used entry.
        studentMap.put("Bob", 100);
        studentMap.put("Vivek", 96);
        System.out.println(studentMap);

        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        System.out.println("Cache: " + cache);
        // Access some elements updates their position as recently used
        cache.get(1);
        cache.get(2);
        // Add a new entry, eldest (least recently used) should be removed
        cache.put(4, "Four");
        System.out.println("Cache after adding (4): " + cache);
        // Demonstrate cache content
        cache.put(5, "Five");
        System.out.println("Cache after adding (5): " + cache);
    }
}
