package Collections.LinkedList;

import java.util.*;

public class LinkedListFunctions {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        System.out.println("=== Adding Elements ===");
        list.add("Apple");                 // add at end
        list.addFirst("Mango");            // add at beginning
        list.addLast("Banana");            // add at end
        list.add(1, "Grapes");             // add at index
        list.offer("Orange");              // add at end (queue-style)
        list.offerFirst("Pineapple");      // add at beginning
        list.offerLast("Strawberry");      // add at end
        System.out.println(list);

        System.out.println("\n=== Accessing Elements ===");
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        System.out.println("At index 2: " + list.get(2));
        System.out.println("Peek (head): " + list.peek());
        System.out.println("Peek First: " + list.peekFirst());
        System.out.println("Peek Last: " + list.peekLast());

        System.out.println("\n=== Removing Elements ===");
        System.out.println("Removed First: " + list.removeFirst());
        System.out.println("Removed Last: " + list.removeLast());
        System.out.println("Removed 'Banana': " + list.remove("Banana"));
        System.out.println("Poll (head): " + list.poll());
        System.out.println("Poll First: " + list.pollFirst());
        System.out.println("Poll Last: " + list.pollLast());
        System.out.println("List after removals: " + list);

        System.out.println("\n=== Searching & Modifying ===");
        list.add("Mango");
        list.add("Apple");
        list.add("Mango");
        System.out.println("List: " + list);
        System.out.println("Contains 'Apple'? " + list.contains("Apple"));
        System.out.println("Index of 'Mango': " + list.indexOf("Mango"));
        System.out.println("Last Index of 'Mango': " + list.lastIndexOf("Mango"));
        list.set(1, "Kiwi"); // replace element at index 1
        System.out.println("After set(1, 'Kiwi'): " + list);

        System.out.println("\n=== Iterating ===");
        System.out.println("For-each loop:");
        for (String fruit : list) {
            System.out.print(fruit + " ");
        }
        System.out.println("\nUsing Iterator:");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("\nUsing Descending Iterator:");
        Iterator<String> dit = list.descendingIterator();
        while (dit.hasNext()) {
            System.out.print(dit.next() + " ");
        }
        System.out.println("\nUsing forEach Lambda:");
        list.forEach(item -> System.out.print(item + " "));

        System.out.println("\n\n=== Conversion ===");
        Object[] arr = list.toArray();
        System.out.println("Array: " + Arrays.toString(arr));

        String[] strArr = list.toArray(new String[0]);
        System.out.println("String Array: " + Arrays.toString(strArr));

        System.out.println("\n=== Size & Clearing ===");
        System.out.println("Size before clear: " + list.size());
        list.clear();
        System.out.println("List after clear: " + list);
    }
}
