package Collections.Vector;

import java.util.Vector;
import java.util.Iterator;
import java.util.Enumeration;

public class VectorFunctions {
    public static void main(String[] args) {
        Vector<Integer> numbers = new Vector<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(20);
        System.out.println("Is the vector empty: " + numbers.isEmpty());
        // Insert an element at index 1
        numbers.insertElementAt(15, 1);
        // Set element at index 2
        numbers.set(2, 25);
        // Remove element by index
        numbers.remove(3);
        // Remove element by value
        numbers.removeElement(Integer.valueOf(10));

        // Add all elements from another collection
        Vector<Integer> moreNumbers = new Vector<>();
        moreNumbers.add(100);
        moreNumbers.add(200);
        numbers.addAll(moreNumbers);
        System.out.println("Element at index 1: " + numbers.get(1));

        // Check vector size and capacity
        System.out.println("Size before trimToSize(): " + numbers.size());
        System.out.println("Capacity before trimToSize(): " + numbers.capacity());
        // Trim capacity to current size
        numbers.trimToSize();
        System.out.println("Capacity after trimToSize(): " + numbers.capacity());

        // Index of an element
        System.out.println("First index of 20: " + numbers.indexOf(20));
        System.out.println("Last index of 20: " + numbers.lastIndexOf(20));

        // Check if vector contains an element
        System.out.println("Contains 100? " + numbers.contains(100));
        System.out.println("Contains 999? " + numbers.contains(999));

        // Set size to 5 (pad with null if needed)
        System.out.println("Before setSize(): " + numbers);
        numbers.setSize(5);
        System.out.println("After setSize(5): " + numbers);

        // Use retainAll to keep only elements from another vector
        Vector<Integer> retainSet = new Vector<>();
        retainSet.add(15);
        retainSet.add(100);
        numbers.retainAll(retainSet);
        System.out.println("After retainAll(retainSet): " + numbers);

        // Remove all elements in retainSet from numbers
        numbers.removeAll(retainSet);
        System.out.println("After removeAll(retainSet): " + numbers);

        // Access first and last elements
        numbers.add(42);
        System.out.println("First Element: " + numbers.firstElement());
        System.out.println("Last Element: " + numbers.lastElement());

        // Clone vector
        Vector<Integer> cloneVec = (Vector<Integer>) numbers.clone();
        System.out.println("Cloned Vector: " + cloneVec);

        // Iterate using Iterator
        System.out.print("Iteration using Iterator: ");
        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // Iterate using Enumeration (legacy)
        System.out.print("Iteration using Enumeration: ");
        Enumeration<Integer> en = numbers.elements();
        while (en.hasMoreElements()) {
            System.out.print(en.nextElement() + " ");
        }
        System.out.println();

        // Clear the vector
        numbers.clear();
        System.out.println("After clear(), is empty: " + numbers.isEmpty());
    }
}
