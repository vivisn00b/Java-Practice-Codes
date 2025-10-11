package Collections.MapInterface.EnumMap;

import java.util.EnumMap;

enum Week {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumMapMethods {
    public static void main(String[] args) {
        EnumMap<Week, String> map = new EnumMap<>(Week.class);
        map.put(Week.MONDAY, "Gym");
        map.put(Week.TUESDAY, "Study");
        map.put(Week.WEDNESDAY, "Work");
        System.out.println("Initial map: " + map);

        // getOrDefault(Object key, V defaultValue)
        System.out.println("Activity on THURSDAY: " + map.getOrDefault(Week.THURSDAY, "NIL"));

        // get()
        System.out.println("Activity on TUESDAY: " + map.get(Week.TUESDAY));

        // containsKey, containsValue
        System.out.println("Contains key FRIDAY? " + map.containsKey(Week.FRIDAY));
        System.out.println("Contains value 'Work'? " + map.containsValue("Work"));

        // putIfAbsent()
        map.putIfAbsent(Week.THURSDAY, "Shopping");
        map.putIfAbsent(Week.MONDAY, "Rest"); // Won't update since MONDAY exists
        System.out.println("After putIfAbsent: " + map);

        // replace()
        map.replace(Week.WEDNESDAY, "Meeting");
        System.out.println("After replace WEDNESDAY: " + map);

        // replace(key, oldValue, newValue)
        boolean replaced = map.replace(Week.THURSDAY, "Gym", "Gardening");
        System.out.println("Attempt replace THURSDAY Gym -> Gardening: " + replaced);

        // computeIfAbsent()
        map.computeIfAbsent(Week.FRIDAY, day -> "Party");
        System.out.println("After computeIfAbsent FRIDAY: " + map);

        // computeIfPresent()
        map.computeIfPresent(Week.MONDAY, (day, activity) -> activity + " & Yoga");
        System.out.println("After computeIfPresent MONDAY: " + map);

        // remove()
        map.remove(Week.TUESDAY);
        System.out.println("After remove TUESDAY: " + map);

        // remove(key, value)
        boolean removed = map.remove(Week.FRIDAY, "Work"); // False, value is "Party"
        System.out.println("Attempt remove FRIDAY=Work: " + removed);

        // size(), isEmpty()
        System.out.println("Size: " + map.size());
        System.out.println("Is empty? " + map.isEmpty());

        // keySet(), values(), entrySet()
        System.out.println("Keys: " + map.keySet());
        System.out.println("Values: " + map.values());
        System.out.println("Entries: " + map.entrySet());

        // forEach()
        System.out.println("forEach print:");
        map.forEach((day, activity) -> System.out.println(day + ": " + activity));

        // replaceAll()
        map.replaceAll((day, activity) -> activity.toUpperCase());
        System.out.println("After replaceAll toUpperCase: " + map);

        // clone()
        @SuppressWarnings("unchecked")
        EnumMap<Week, String> clonedMap = (EnumMap<Week, String>) map.clone();
        System.out.println("Cloned map: " + clonedMap);

        // clear()
        map.clear();
        System.out.println("After clear, is empty? " + map.isEmpty());
    }
}