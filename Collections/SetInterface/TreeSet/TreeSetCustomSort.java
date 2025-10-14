package Collections.SetInterface.TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetCustomSort {
    public static void main(String[] args) {
        // Natural Order
        Comparator<String> naturalOrder = (a, b) -> a.compareTo(b);

        // Reverse alphabetical order
        Comparator<String> reverseOrder = (a, b) -> b.compareTo(a);

        // Comparator for sorting by string length
        Comparator<String> lengthComparator = (a, b) -> Integer.compare(a.length(), b.length());

        //TreeSet<String> set = new TreeSet<>(lengthComparator);
        TreeSet<String> set = new TreeSet<>(reverseOrder);
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Date");
        System.out.println("Custom sorted TreeSet: " + set);
    }
}
