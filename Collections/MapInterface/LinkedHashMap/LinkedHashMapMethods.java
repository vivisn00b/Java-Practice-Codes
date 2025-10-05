package Collections.MapInterface.LinkedHashMap;

import java.util.Map;
import java.util.LinkedHashMap;

public class LinkedHashMapMethods {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("one", "Red");
        map.put("two", "Green");
        map.put("three", "Blue");
        System.out.println("Original LinkedHashMap: " + map);

        // isEmpty(): Check if map is empty
        System.out.println("Is the map empty? " + map.isEmpty());

        // size(): Get number of entries
        System.out.println("Size of the map: " + map.size());

        // get(): Get value for a key
        System.out.println("Value for key 'one': " + map.get("one"));

        // containsKey(): Check key existence
        System.out.println("Contains key 'two'? " + map.containsKey("two"));

        // containsValue(): Check value existence
        System.out.println("Contains value 'Blue'? " + map.containsValue("Blue"));

        // keySet(): Get all keys
        System.out.println("Set of keys: " + map.keySet());

        // values(): Get all values
        System.out.println("Collection of values: " + map.values());

        // entrySet(): Get all key-value pairs
        System.out.println("Set of entries: " + map.entrySet());

        // remove(): Remove key-value pair
        System.out.println("Delete element with key 'one': " + map.remove("one"));
        System.out.println("After removal: " + map);

        // Iterating using entrySet()
        System.out.println("Iterating LinkedHashMap:");
        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // clear(): Remove all entries
        map.clear();
        System.out.println("After clearing: " + map);
    }
}

class AdvanceLinkedHashMap {
    public static void main(String[] args) {
        // LinkedHashMap with access order (LRU logic)
        LinkedHashMap<Integer, String> lruMap = new LinkedHashMap<Integer, String>(16, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > 3; // Max 3 entries
            }
        };

        // Adding entries
        lruMap.put(1, "One");
        lruMap.put(2, "Two");
        lruMap.put(3, "Three");

        System.out.println("Initial Map: " + lruMap);

        // Access some entries
        lruMap.get(1);  // Access key 1 (moves it to the end)
        lruMap.get(2);  // Access key 2 (moves it to the end)

        // Add a new entry, eldest entry will be removed automatically
        lruMap.put(4, "Four");

        System.out.println("After adding key 4 (LRU logic): " + lruMap);

        // Using putIfAbsent - adds key if not present
        lruMap.putIfAbsent(2, "Two_New"); // Won't replace, key 2 exists
        lruMap.putIfAbsent(5, "Five");    // Will add

        System.out.println("After putIfAbsent calls: " + lruMap);

        // Using putAll to copy all entries from another map
        Map<Integer, String> anotherMap = Map.of(
                6, "Six",
                7, "Seven"
        );
        lruMap.putAll(anotherMap);

        System.out.println("After putAll from another map: " + lruMap);
    }
    // The LinkedHashMap is constructed with accessOrder=true, so order changes on access.
    // The removeEldestEntry method is overridden to implement a size limit of 3 — oldest entries are removed automatically, acting like an LRU cache.
    // putIfAbsent is demonstrated to avoid overwriting existing keys.
    // putAll copies all entries from another map, preserving insertion order accordingly.
}