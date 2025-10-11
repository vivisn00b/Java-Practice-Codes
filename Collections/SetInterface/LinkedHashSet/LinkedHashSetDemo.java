// A LinkedHashSet is an implementation of the Set interface that stores its elements in a hash table like a HashSet, but also maintains a doubly-linked list across all entries.
// It preserves insertion order when iterating
// No duplicates values are allowed
// Allows single null value
// Memory overhead: Requires more memory than HashSet because it stores ordering information using a doubly-linked list.

package Collections.SetInterface.LinkedHashSet;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Arrays;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        // Create a LinkedHashSet
        LinkedHashSet<String> set = new LinkedHashSet<>();

        // add()
        set.add("Banana");
        set.add("Apple");
        set.add("Mango");
        set.add("Banana"); // Duplicate, will be ignored
        set.add(null);     // One null allowed

        // toString()
        System.out.println("Initial set: " + set);

        // addAll()
        List<String> list = Arrays.asList("Cherry", "Banana", "Date");
        set.addAll(list);
        System.out.println("After addAll: " + set);

        // contains(), containsAll()
        System.out.println("Contains 'Apple'? " + set.contains("Apple"));
        System.out.println("Contains all [Apple, Mango]? " + set.containsAll(Arrays.asList("Apple", "Mango")));

        // remove(), removeAll()
        set.remove("Date");
        System.out.println("After remove 'Date': " + set);
        set.removeAll(Arrays.asList("Mango", "Grape"));
        System.out.println("After removeAll [Mango, Grape]: " + set);

        // retainAll()
        set.retainAll(Arrays.asList("Apple", "Cherry", null));
        System.out.println("After retainAll [Apple, Cherry, null]: " + set);

        // isEmpty(), size()
        System.out.println("Is empty? " + set.isEmpty());
        System.out.println("Size: " + set.size());

        // iterator(), forEach()
        System.out.print("Iteration:");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(" " + iterator.next());
        }
        System.out.println();

        // forEach with lambda
        System.out.print("forEach: ");
        set.forEach(e -> System.out.print(e + " "));
        System.out.println();

        // toArray()
        Object[] arr1 = set.toArray();
        System.out.println("toArray(): " + Arrays.toString(arr1));

        String[] arr2 = set.toArray(new String[0]);
        System.out.println("toArray(new String[0]): " + Arrays.toString(arr2));

        // removeIf()
        set.removeIf(s -> s == null || s.startsWith("C"));
        System.out.println("After removeIf (null or startsWith C): " + set);

        // clone()
        LinkedHashSet<String> cloned = (LinkedHashSet<String>) set.clone();
        System.out.println("Cloned set: " + cloned);

        // clear(), isEmpty()
        set.clear();
        System.out.println("After clear: " + set + " | Is empty? " + set.isEmpty());
    }
}
