package Collections.SetInterface;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class SetOverview {
    public static void main(String[] args) {
        //  Set is a collection that cannot contain duplicate elements
        // faster operations
        // Map --> HashMap, LinkedHashMap, TreeMap, EnumMap
        // Set --> HashSet, LinkedHashSet, TreeSet, EnumSet
        NavigableSet<Integer> set = new TreeSet<>();
        set.add(12);
        set.add(1);
        set.add(1);
        set.add(67);
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        System.out.println(set);
        System.out.println(set.contains(12));
        System.out.println(set.remove(67));
        // NavigableSet methods
        System.out.println("Ceiling(25): " + set.ceiling(25));
        System.out.println("Floor(25): " + set.floor(25));
        System.out.println("Higher(20): " + set.higher(20));
        System.out.println("Lower(20): " + set.lower(20));
        System.out.println("HeadSet(30, true): " + set.headSet(30, true));
        System.out.println("TailSet(20, false): " + set.tailSet(20, false));
        System.out.println("SubSet(10, true, 40, false): " + set.subSet(10, true, 40, false));
        System.out.println("Poll First: " + set.pollFirst());
        System.out.println("Poll Last: " + set.pollLast());
        System.out.println("After polls: " + set);

        set.clear();
        System.out.println(set.isEmpty());
        for(int i: set){
            System.out.println(i);
        }

        // for thread safety
        Set<Integer> integers = Collections.synchronizedSet(set); // entire set is locked for every operation so only one thread can access methods of the synchronized set at a time, reducing concurrency and parallelism so not recommended
        // iterators returned by the synchronized set are not synchronized internally
        // to iterate safely, you must manually synchronize on the set
        synchronized (integers) {
            Iterator<Integer> it = integers.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }

        // thread-safe, sorted set implementation
        // internally backed by a ConcurrentSkipListMap
        ConcurrentSkipListSet<Integer> set1 =  new ConcurrentSkipListSet<>(); // recommended for thread safety
        set1.add(78);
        set1.add(64);
        set1.add(12);
        set1.add(45);
        set1.add(8);
        System.out.println("ConcurrentSkipListSet: " + set1);
        // Get highest and lowest elements
        System.out.println("Highest: " + set1.last());
        System.out.println("Lowest: " + set1.first());
        // Poll first and last elements (retrieve and remove)
        System.out.println("Poll First: " + set1.pollFirst());
        System.out.println("Poll Last: " + set1.pollLast());
        System.out.println("Set after polls: " + set1);
        // Get set in reverse order
        System.out.println("Set in descending order: " + set1.descendingSet());
        Iterator<Integer> iterator = set1.descendingIterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        // unmodifiable
        Set<Integer> intSet = Set.of(1, 2, 3,4,5,6,7,8,9,54,4323,545,4545); // unlike Map.of() here we can give more than 10 values
        Collections.unmodifiableSet(set);

        SortedSet<String> sortedSet = new TreeSet<>();
        sortedSet.add("Banana");
        sortedSet.add("Apple");
        sortedSet.add("Grapes");
        sortedSet.add("Mango");
        System.out.println("SortedSet: " + sortedSet);        // [Apple, Banana, Grapes, Mango]
        System.out.println("First: " + sortedSet.first());    // Apple
        System.out.println("Last: " + sortedSet.last());      // Mango
        System.out.println("HeadSet (to Banana): " + sortedSet.headSet("Banana")); // [Apple]
        System.out.println("TailSet (from Grapes): " + sortedSet.tailSet("Grapes")); // [Grapes, Mango]
        System.out.println("SubSet (Apple, Mango): " + sortedSet.subSet("Apple", "Mango")); // [Apple, Banana, Grapes]
        System.out.println("Comparator: " + sortedSet.comparator()); // null (uses natural order)
        // Custom comparator
        SortedSet<String> compareSet1 = new TreeSet<>(new Comparator<String>() {
            public int compare(String a, String b) {
                // Sort in reverse order
                return b.compareTo(a);
            }
        }); // anonymous inner class
        SortedSet<String> compareSet2 = new TreeSet<>((a, b) -> b.compareTo(a));  // lambda expression
        SortedSet<String> compareSet3 = new TreeSet<>(Comparator.reverseOrder());
        SortedSet<String> compareSet4 = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        SortedSet<String> compareSet5 = new TreeSet<>(Comparator.comparingInt(String::length));
        // Comparator.comparingInt is a static method that takes a key extractor function and returns a Comparator which compares elements based on the int values extracted by that function.
    }
}