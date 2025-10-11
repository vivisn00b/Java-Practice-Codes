// Implementation of ConcurrentNavigableMap. ConcurrentMap, SortedMap
// Based on skip list data structure
// Maintains keys in ordered fashion

package Collections.MapInterface.ConcurrentSkipList;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListDemo {
    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        System.out.println("Initial map: " + map);
        // print key-value pair whose key is greater than 2
        System.out.println("ceilingEntry-2: " + map.ceilingEntry(2));
        // NavigableKeySet and descendingKeySet
        NavigableSet<Integer> navigableSet1 = map.navigableKeySet();
        System.out.println("NavigableKeySet: " + navigableSet1);
        NavigableSet navigableSet2 = map.descendingKeySet();
        System.out.println("descendingKeySet: ");
        // Iterate through the keySet
        Iterator itr = navigableSet2.iterator();
        while (itr.hasNext()) {
            String s = (String)itr.next();
            System.out.println(s);
        }
        // ceilingEntry - least entry >= key
        System.out.println("ceilingEntry(2): " + map.ceilingEntry(2));
        // floorEntry - greatest entry <= key
        System.out.println("floorEntry(2): " + map.floorEntry(2));
        // higherEntry - least entry > key
        System.out.println("higherEntry(5): " + map.higherEntry(5));
        // lowerEntry - greatest entry < key
        System.out.println("lowerEntry(5): " + map.lowerEntry(5));
        // print the first mapping
        System.out.println("firstEntry: " + map.firstEntry());
        // print the last mapping
        System.out.println("lastEntry: " + map.lastEntry());
        // remove the first mapping and print it
        System.out.println("pollFirstEntry: " + map.pollFirstEntry());
        // print the first mapping
        System.out.println("now firstEntry: " + map.firstEntry());
        // remove the last mapping and print it
        System.out.println("pollLastEntry: " + map.pollLastEntry());
        // print the last mapping
        System.out.println("now lastEntry: " + map.lastEntry());
        // SubMap - view between keys (inclusive, exclusive variants)
        System.out.println("subMap(3, false, 7, true): " + map.subMap(3, false, 7, true));
        // HeadMap - keys less than 6 (exclusive)
        System.out.println("headMap(6): " + map.headMap(6));
        // TailMap - keys greater or equal to 6
        System.out.println("tailMap(6): " + map.tailMap(6));
    }
}

//Skip list working:
//Think of it as multiple sorted linked lists stacked on top of each other.
//The bottom layer is a normal sorted linked list containing all elements.
//Each higher layer is a sparse "express lane" with fewer elements from the layer below.
//Each node contains multiple forward pointers (one per level).
//Traversal starts at the top layer, moving forward until overshooting the desired value, then drops down a layer to continue.
//This "skip" pattern reduces traversal steps drastically, resulting in O(log n) average time for search, insert, and delete operations.