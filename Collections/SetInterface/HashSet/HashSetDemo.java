// Implements the Set interface of Collections Framework. Uses HashMap (implementation of hash table data structure) internally.
// It is used to store the unique elements and it doesn't maintain any specific order of elements.
// Not thread-safe
// Can store null values

package Collections.SetInterface.HashSet;

import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String[] args) {
        //HashSet<String> hashSet = new HashSet<>();
        Set<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");
        fruits.add("Banana"); // Duplicate, will be ignored
        // Add a null
        fruits.add(null); // HashSet allows one null
        System.out.println("Initial HashSet: " + fruits);

        // Remove an element
        fruits.remove("Mango");
        System.out.println("After removing 'Mango': " + fruits);
        // Remove null
        fruits.remove(null);
        System.out.println("After removing null: " + fruits);

        // Check if element exists
        System.out.println("Contains 'Apple'? " + fruits.contains("Apple"));

        // Set size and empty check
        System.out.println("Set size: " + fruits.size());
        System.out.println("Is empty? " + fruits.isEmpty());

        // Add all elements from another collection (Union)
        HashSet<String> moreFruits = new HashSet<>();
        moreFruits.add("Kiwi");
        moreFruits.add("Banana");
        fruits.addAll(moreFruits);
        System.out.println("After union (addAll): " + fruits);

        // Retain only specified elements (Intersection)
        HashSet<String> tropical = new HashSet<>();
        tropical.add("Banana");
        tropical.add("Kiwi");
        fruits.retainAll(tropical);
        System.out.println("After intersection (retainAll): " + fruits);

        // Remove all elements from another collection (Difference)
        fruits.removeAll(moreFruits);
        System.out.println("After difference (removeAll): " + fruits);

        // Clear all elements
        fruits.clear();
        System.out.println("After clear: " + fruits);

        // Add new elements for iteration demo
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        // Iterate using enhanced for-loop
        System.out.print("For-each iteration: ");
        for (String item : fruits) {
            System.out.print(item + " ");
        }
        System.out.println();

        // Iterate using Iterator
        Iterator<String> iterator = fruits.iterator();
        System.out.print("Iterator: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Convert to array
        Object[] fruitArray = fruits.toArray();
        System.out.println("Array: " + Arrays.toString(fruitArray));
    }
}
