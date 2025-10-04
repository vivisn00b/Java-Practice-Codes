// It stores key-value pairs while maintaining the insertion order of the entries.
// In this class, the data is stored in the form of nodes.
// The implementation of the LinkedHashMap is very similar to a doubly linked list.
// It maintains the order in which elements are added.
// Allows one null key and multiple null values.

package Collections.MapInterface.LinkedHashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Orange", 50);
        linkedHashMap.put("Apple", 20);
        linkedHashMap.put("Guava", 13);
        System.out.println(linkedHashMap);

        linkedHashMap.get("Apple");
        linkedHashMap.get("Orange");
        linkedHashMap.get("Guava");
        linkedHashMap.get("Apple");
        linkedHashMap.get("Orange");
        linkedHashMap.get("Apple");
        linkedHashMap.get("Guava");

        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Shubham", 91);
        hashMap.put("Bob", 80);
        hashMap.put("Akshit", 78);
        LinkedHashMap linkedHashMap1 = new LinkedHashMap(hashMap);
        System.out.println(linkedHashMap1);
    }
}
