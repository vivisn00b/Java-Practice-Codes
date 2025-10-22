package Collections;

import java.util.*;

public class IterableInterface {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Collections");
        list.add("Framework");
        list.add("by Vivek");

        System.out.println("Original collection: ");
        // 1. Using for-each loop
        for (String item : list) {
            System.out.println(item);
        }  // When using a for-each loop, you do not have direct access to the Iterator's state or methods
           // Any modification to the structure of the collection disrupts the internal consistency of the collection during iteration and triggers a ConcurrentModificationException

        // 2. Using Iterator
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.equals("by Vivek")) {
                System.out.print("Removed while iterating: ");
                it.remove();  // remove elements safely during traversal
            }
            System.out.println(it.next());
        }  // Provides a controlled mechanism for removing elements via its remove() method
           // Maintains the internal state of the collection safely during traversal

        System.out.println("Modified list: ");
        // 3. Using forEach() method with lambda
        list.forEach(element -> System.out.println(element));
    }
}
