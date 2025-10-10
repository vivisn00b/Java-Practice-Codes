package Collections.MapInterface.HashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapFunctions {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 10);              // put
        map.put("B", 20);
        map.put("C", 30);

        HashMap<String, Integer> copyMap = new HashMap<>();
        copyMap.put("D", 40);
        copyMap.putAll(map);           // putAll

        System.out.println("get('A'): " + map.get("A"));               // get
        System.out.println("containsKey('B'): " + map.containsKey("B"));      // containsKey
        System.out.println("containsValue(40): " + copyMap.containsValue(40));  // containsValue
        System.out.println("size(): " + map.size());                   // size
        System.out.println("isEmpty(): " + map.isEmpty());             // isEmpty
        System.out.println("keySet(): " + map.keySet());               // keySet
        System.out.println("values(): " + map.values());               // values
        System.out.println("entrySet(): " + map.entrySet());           // entrySet

        map.replace("C", 300);                    // replace
        map.remove("B");                          // remove
        copyMap.clear();                          // clear
        System.out.println("clone(): " + map.clone());  // clone

        map.compute("A", (k, v) -> v + 5);            // compute
        // System.out.println("After compute fnc: " + map);
        map.computeIfAbsent("D", k -> 100);           // computeIfAbsent
        map.computeIfPresent("A", (k, v) -> v * 2);   // computeIfPresent
        map.merge("A", 10, (oldV, newV) -> oldV + newV); // merge
        System.out.println("map after manipulations: " + map);

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Shubham", 91);
        hashMap.put("Bob", 80);
        hashMap.put("Akshit", 78);
        // Retrieves the value associated with a given key if it exists in the map. If the key does not exist, it returns a default value provided by the user.
        Integer res = hashMap.getOrDefault("Vivek", 0);
        System.out.println("Is Vivek present? " + res);  // 0
        hashMap.put("Shubham", 92);
        System.out.println(hashMap);

        Map<Integer, String> sourceMap = new HashMap<>();
        sourceMap.put(1, "Apple");
        sourceMap.put(2, "Banana");
        sourceMap.put(3, "Cherry");
        Collection<String> values = sourceMap.values(); // Get a Collection of values
        String[] valueArray = values.toArray(new String[0]); // Convert to array
        for (String value : valueArray) {
            System.out.println("Value: " + value);
        }

        Set<Integer> keys = sourceMap.keySet(); // Get a Set of keys
        Integer[] keyArray = keys.toArray(new Integer[0]); // Convert to array
        for (Integer key : keyArray)
            System.out.println("Key: " + key);

        // For key-value pair
        Set<Map.Entry<Integer, String>> entrySet = sourceMap.entrySet(); // Get a Set of entries
        Map.Entry<Integer, String>[] entryArray = entrySet.toArray(new Map.Entry[0]); // Convert to array
        for (Map.Entry<Integer, String> entry : entryArray) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
