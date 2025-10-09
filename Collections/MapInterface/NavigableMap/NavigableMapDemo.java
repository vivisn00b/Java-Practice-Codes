// NavigableMap is an interface that extends SortedMap and provides navigation methods to work on sorted maps more flexibly.
// Provides additional navigation methods like:
// key-based searches near given keys.
// removes first/last entries.
// reverse traversal.
// Implemented by classes such as TreeMap (most common) and ConcurrentSkipListMap
package Collections.MapInterface.NavigableMap;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapDemo {
    public static void main(String[] args) {
        NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(10, "Ten");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        System.out.println("Map: " + map);

        System.out.println("Lower Entry than 25: " + map.lowerEntry(25));     // 20=Twenty
        System.out.println("Floor Entry of 30: " + map.floorEntry(30));       // 30=Thirty
        System.out.println("Ceiling Entry of 25: " + map.ceilingEntry(25));   // 30=Thirty
        System.out.println("Higher Entry than 30: " + map.higherEntry(30));   // 40=Forty

        System.out.println("First Entry: " + map.firstEntry());               // 10=Ten
        System.out.println("Last Entry: " + map.lastEntry());                 // 50=Fifty

        System.out.println("Poll First Entry: " + map.pollFirstEntry());      // removes 10=Ten
        System.out.println("Poll Last Entry: " + map.pollLastEntry());        // removes 50=Fifty

        System.out.println("Map after polls: " + map);

        System.out.println("Descending Map: " + map.descendingMap());

        System.out.println("Navigable Key Set: " + map.navigableKeySet());
        System.out.println("Descending Key Set: " + map.descendingKeySet());
    }
}
