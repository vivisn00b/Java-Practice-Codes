package Collections.MapInterface.SortedMap;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapMethods {
    public static void main(String[] args) {
        SortedMap<Integer, String> map = new TreeMap<>();
        map.put(3, "Banana");
        map.put(1, "Apple");
        map.put(2, "Mango");
        map.put(5, "Grape");
        map.put(4, "Orange");

        System.out.println("Initial map: " + map); // Sorted by key

        System.out.println("First key: " + map.firstKey());      // 1
        System.out.println("Last key: " + map.lastKey());        // 5

        System.out.println("SubMap (2,5): " + map.subMap(2, 5));      // {2=Mango, 3=Banana, 4=Orange}
        System.out.println("HeadMap (<4): " + map.headMap(4));        // {1=Apple, 2=Mango, 3=Banana}
        System.out.println("TailMap (>=3): " + map.tailMap(3));       // {3=Banana, 4=Orange, 5=Grape}
        System.out.println("Contains Key 2: " + map.containsKey(2));  // true
        System.out.println("Contains Value 'Grape': " + map.containsValue("Grape")); // true

        map.replace(3, "Cherry");
        System.out.println("After replace: " + map);

        // Iterating over entries
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        System.out.println("PollFirstEntry: " + map.pollFirstEntry()); // Removes 1=Apple
        System.out.println("PollLastEntry: " + map.pollLastEntry());   // Removes 5=Grape
        System.out.println("Updated map: " + map);

        map.clear();
        System.out.println("Cleared map: " + map); // {}
    }
}

class TreeMapFunctionsDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(3, "C");
        map.put(1, "A");
        map.put(2, "B");
        map.put(5, "E");
        map.put(4, "D");

        System.out.println(map);                     // {1=A, 2=B, 3=C, 4=D, 5=E}
        System.out.println(map.get(2));              // B
        System.out.println(map.firstKey());          // 1
        System.out.println(map.lastKey());           // 5
        System.out.println(map.subMap(2, 5));        // {2=B, 3=C, 4=D}
        System.out.println(map.headMap(4));          // {1=A, 2=B, 3=C}
        System.out.println(map.tailMap(3));          // {3=C, 4=D, 5=E}
        System.out.println(map.containsKey(3));      // true
        System.out.println(map.containsValue("E"));  // true
        System.out.println(map.size());              // 5
        System.out.println(map.comparator());        // null (uses natural order)
        System.out.println(map.pollFirstEntry());    // 1=A removed and returned
        System.out.println(map.pollLastEntry());     // 5=E removed and returned
        map.replace(2, "BB");
        System.out.println(map);                     // {2=BB, 3=C, 4=D}
        map.clear();
        System.out.println(map);                     // {}
    }
}