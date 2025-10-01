// A HashMap is a part of Java’s Collection Framework and implements the Map interface.
// It stores elements in key-value pairs.
// Keys are unique. If we try to insert a duplicate, it replaces the existing value of the corresponding key.
// Values can be duplicated.
// Internally uses Hashing, hence allows efficient key-based retrieval, insertion, and removal
// Allows to store the null keys as well, but there should be only one null key object. Multiple values can be null.

package Collections.MapInterface.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("John", 25);
        hashMap.put("Jane", 30);
        hashMap.put("Jim", 35);
        hashMap.put("Viv", 21);
        System.out.println(hashMap.get("Viv"));
        hashMap.remove("Jim");
        System.out.println(hashMap.containsKey("Jim")); // Output: false
        System.out.println(hashMap.size());
        System.out.println("Mappings of HashMap are : " + hashMap);
        Set<String> keySet = hashMap.keySet();
        for (String key : keySet) {
            System.out.println("Key: " + key);
        }
//        for (String key : hashMap.keySet()) {
//            System.out.println("Key: " + key);
//        }
        for (Integer val : hashMap.values()) {
            System.out.println("Values: " + val);
        }
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry);
        }

        HashMap<String, String> map = new HashMap<>(10, 0.75f);  // Automatically resizes bucket array if the count exceeds loadFactor × capacity. Default load factor is 0.75
        map.put(null, "NullKeyValue"); // one null key allowed
        map.put("A", null); // multiple null values possible
        System.out.println(map);
    }
}
