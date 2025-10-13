package Collections.MapInterface.ImmutableMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        // return unmodifiable view of the specified map
        Map<String, Integer> map2 = Collections.unmodifiableMap(map1);
        System.out.println(map2);
        //map2.put("C", 3);  // throws exception
        // we are just creating an unmodifiable view of map1 so we can directly change the content of map1
        //map1.put("C", 3);
        // to avoid that we use Map.of function

        // limitation: can take only 10 key-value pair
        Map<String, Integer> map3 = Map.of("Shubham", 98, "Vivek", 89);
        //map3.put("Akshit", 88); // will give exception
        System.out.println(map3);

        // overcomes limitation of Map.of()
        Map<String, Integer> map4 = Map.ofEntries(Map.entry("Akshit", 99), Map.entry("Vivek", 99));
    }
}
