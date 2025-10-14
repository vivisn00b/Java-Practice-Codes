// TreeSet in Java is a collection that stores unique elements in sorted order. It implements the Set interface and extends AbstractSet.
// It is based on a NavigableSet, which is backed by a balanced tree (Red-Black tree).
// Stores unique elements (no duplicates).
// Keeps elements sorted either by natural order or by a custom comparator.
// Supports operations like add, remove, and contains efficiently
// Supports navigation like headSet(), tailSet(), subSet(), lower(), floor(), ceiling(), higher().

package Collections.SetInterface.TreeSet;

import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();

        // Add elements
        set.add(40);
        set.add(10);
        set.add(30);
        set.add(20);
        set.add(10); // Duplicate, ignored

        System.out.println("Initial TreeSet: " + set);  // Sorted: [10, 20, 30, 40]

        // First and Last
        System.out.println("First: " + set.first());   // 10
        System.out.println("Last: " + set.last());     // 40

        // HeadSet (elements < to element)
        System.out.println("HeadSet (<30): " + set.headSet(30)); // [10, 20]
        System.out.println("HeadSet (inclusive 30): " + set.headSet(30, true)); // [10, 20, 30]

        // TailSet (elements >= to element)
        System.out.println("TailSet (>=20): " + set.tailSet(20)); // [20, 30, 40]
        System.out.println("TailSet (>20): " + set.tailSet(20, false)); // [30, 40]

        // subSet(fromElement, toElement)
        System.out.println("SubSet (20 to 40): " + set.subSet(20, 40)); // [20, 30]

        // Navigational methods
        System.out.println("lower(25): " + set.lower(25));  // 20
        System.out.println("floor(25): " + set.floor(25));  // 20
        System.out.println("ceiling(25): " + set.ceiling(25)); // 30
        System.out.println("higher(30): " + set.higher(30));  // 40

        // pollFirst() and pollLast()
        System.out.println("Poll First: " + set.pollFirst()); // 10
        System.out.println("Poll Last: " + set.pollLast());   // 40
        System.out.println("Remaining set: " + set);          // [20, 30]

        // contains and remove
        System.out.println("Contains 20? " + set.contains(20)); // true
        set.remove(20);
        System.out.println("After remove 20: " + set); // [30]

        // size and clear
        System.out.println("Size: " + set.size()); // 1
        set.clear();
        System.out.println("After clear: " + set); // []
    }
}

class SortedSetMethods {
    public static void main(String[] args) {
        SortedSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(50);
        sortedSet.add(10);
        sortedSet.add(40);
        sortedSet.add(30);
        sortedSet.add(20);
        System.out.println("SortedSet: " + sortedSet);

        // Accessing first and last
        System.out.println("First Element: " + sortedSet.first());
        System.out.println("Last Element: " + sortedSet.last());

        // Using headSet (elements less than 30)
        SortedSet<Integer> headSet = sortedSet.headSet(30);
        System.out.println("HeadSet (<30): " + headSet);

        // Using tailSet (elements greater or equal 30)
        SortedSet<Integer> tailSet = sortedSet.tailSet(30);
        System.out.println("TailSet (>=30): " + tailSet);

        // Using subSet (elements from 20 inclusive to 40 exclusive)
        SortedSet<Integer> subSet = sortedSet.subSet(20, 40);
        System.out.println("SubSet [20, 40): " + subSet);

        // Getting comparator (null means natural ordering)
        System.out.println("Comparator: " + sortedSet.comparator());
    }
}