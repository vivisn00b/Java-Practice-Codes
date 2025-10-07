// SortedMap is an interface that extends Map and guarantees that the entries are sorted based on the keys, either in their natural ordering or by a specified Comparator.

package Collections.MapInterface.SortedMap;

import java.util.*;

public class SortedMapDemo {
    public static void main(String[] args) {
//        SortedMap<String, Integer> sMap = new SortedMap<String, Integer>() {
//            @Override
//            public Comparator<? super String> comparator() {
//                return null;
//            }
//
//            @Override
//            public SortedMap<String, Integer> subMap(String fromKey, String toKey) {
//                return null;
//            }
//
//            @Override
//            public SortedMap<String, Integer> headMap(String toKey) {
//                return null;
//            }
//
//            @Override
//            public SortedMap<String, Integer> tailMap(String fromKey) {
//                return null;
//            }
//
//            @Override
//            public String firstKey() {
//                return "";
//            }
//
//            @Override
//            public String lastKey() {
//                return "";
//            }
//
//            @Override
//            public Set<String> keySet() {
//                return Set.of();
//            }
//
//            @Override
//            public Collection<Integer> values() {
//                return List.of();
//            }
//
//            @Override
//            public Set<Entry<String, Integer>> entrySet() {
//                return Set.of();
//            }
//
//            @Override
//            public int size() {
//                return 0;
//            }
//
//            @Override
//            public boolean isEmpty() {
//                return false;
//            }
//
//            @Override
//            public boolean containsKey(Object key) {
//                return false;
//            }
//
//            @Override
//            public boolean containsValue(Object value) {
//                return false;
//            }
//
//            @Override
//            public Integer get(Object key) {
//                return 0;
//            }
//
//            @Override
//            public Integer put(String key, Integer value) {
//                return 0;
//            }
//
//            @Override
//            public Integer remove(Object key) {
//                return 0;
//            }
//
//            @Override
//            public void putAll(Map<? extends String, ? extends Integer> m) {
//
//            }
//
//            @Override
//            public void clear() {
//
//            }
//        };

        // Its implementation is TreeMap
        // Internal implementation of TreeMap is Red Black tree (self-balancing binary search tree)
        SortedMap<String, Integer> map = new TreeMap<>(); // Natural ordering
        //Map<String, Integer> map = new TreeMap<>(); // Even without SortedMap it sorts the keys but SortedMap interface has some useful functions
        map.put("Vivek", 91);
        map.put("Alfred", 51);
        map.put("Nora", 89);
        map.put("Fin", 89);
        map.put("Nina", 58);
        map.put("Garry", 79);
        map.put("Bob", 90);
        //map.put("Bob", 90); // doesn't put a duplicate key value pair
        //map.put("Bob", 75); // replaces the previous pair
        System.out.println(map);
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        //System.out.println(map.headMap(("Shubham"))); // won't do anything as this key doesn't exist
        System.out.println(map.headMap(("Nina"))); // exclude
        System.out.println(map.tailMap("Fin"));

        SortedMap<Integer, String> descMap = new TreeMap<>((a, b) -> b - a); // descending order
        descMap.put(91, "Vivek");
        descMap.put(99, "Shubham");
        descMap.put(78, "Monit");
        descMap.put(77, "Vipul");
        //descMap.put(null, "Anything");  // will give .NullPointerException
        descMap.get(77);
        descMap.containsKey(78);
        descMap.containsValue(77);
        System.out.println(descMap.subMap(78, 91));
    }
}