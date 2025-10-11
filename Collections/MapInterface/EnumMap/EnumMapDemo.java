// EnumMap is a specialized Map implementation in Java for use with enum keys, offering efficient storage and quick access when the keys are all from a single enum type
// Maintains natural enum order
// Internally stored as arrays
// Null keys not allowed
// Null values are permitted
// Not synchronized

package Collections.MapInterface.EnumMap;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class EnumMapDemo {
    public static void main(String[] args) {
        Map<Day, String> enumHashMap = new HashMap<>(); // using HashMap
        enumHashMap.put(Day.SUNDAY, "Gym");
        enumHashMap.put(Day.TUESDAY, "Rest");
        enumHashMap.put(Day.MONDAY, "Walk");
        enumHashMap.put(null, "Sleep"); // will allow one null key
        System.out.println(enumHashMap); // Order will vary, {MONDAY=Walk, SUNDAY=Gym, TUESDAY=Rest}

        Map<Day, String> map = new EnumMap<>(Day.class);
        // array of size same as enum
        // ["Gym",_,_,_,_,_,_]
        // no hashing
        // ordinal/index is used
        // FASTER THAN HASHMAP
        // MEMORY EFFICIENT
        map.put(Day.SUNDAY, "Gym");
        map.put(Day.TUESDAY, "Gym");
        map.put(Day.MONDAY, "Walk");
        String s = map.get(Day.TUESDAY);
        System.out.println(map); // will print in the order defined in enum
        System.out.println(Day.SUNDAY.ordinal());
    }
}