package Collections.QueueInterface.ConcurrentLinkedQueue;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CLQMethods {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        // add(E e): Adds elements to the queue
        queue.add("Java");
        queue.add("Python");
        queue.add("C++");
        queue.add("Go");
        System.out.println("After add(): " + queue);

        // offer(E e): Inserts element (same as add)
        queue.offer("Kotlin");
        System.out.println("After offer(): " + queue);

        // peek(): Retrieves the head without removing
        System.out.println("Peek element: " + queue.peek());

        // poll(): Retrieves and removes head
        System.out.println("Polled element: " + queue.poll());
        System.out.println("After poll(): " + queue);

        // contains(Object o)
        System.out.println("Contains 'Python'? " + queue.contains("Python"));
        System.out.println("Contains 'Ruby'? " + queue.contains("Ruby"));

        // isEmpty()
        System.out.println("Is queue empty? " + queue.isEmpty());

        // size()
        System.out.println("Queue size: " + queue.size());

        // iterator(): Iterating elements
        System.out.println("\nIterating through queue:");
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // remove(Object o): Removes specific element
        queue.remove("C++");
        System.out.println("\nAfter remove('C++'): " + queue);

        // removeIf(Predicate<? super E> filter): Removes elements conditionally
        queue.removeIf(lang -> lang.startsWith("K"));
        System.out.println("After removeIf(lang -> lang.startsWith('K')): " + queue);

        // retainAll(Collection<?> c): Keeps only specified elements
        List<String> retainList = Arrays.asList("Go");
        queue.retainAll(retainList);
        System.out.println("After retainAll(['Go']): " + queue);

        // addAll(Collection<? extends E> c): Adds all elements from another collection
        List<String> newLangs = Arrays.asList("Rust", "Swift", "Scala");
        queue.addAll(newLangs);
        System.out.println("After addAll(newLangs): " + queue);

        // toArray(): Convert queue to Object array
        Object[] array = queue.toArray();
        System.out.println("\nQueue elements via toArray(): " + Arrays.toString(array));

        // toArray(T[] a): Convert to typed array
        String[] strArray = queue.toArray(new String[0]);
        System.out.println("Typed array (String[]): " + Arrays.toString(strArray));

        // spliterator(): Splitting iterator for stream operations
        System.out.println("\nUsing spliterator():");
        Spliterator<String> spliterator = queue.spliterator();
        spliterator.forEachRemaining(System.out::println);

        // forEach(Consumer<? super E> action): Print all elements with lambda
        System.out.println("\nUsing forEach():");
        queue.forEach(System.out::println);
    }
}
