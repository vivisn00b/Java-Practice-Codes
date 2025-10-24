package Collections.QueueInterface.ConcurrentLinkedDeque;

import java.util.concurrent.ConcurrentLinkedDeque;

public class CLDMethods {
    public static void main(String[] args) {
        ConcurrentLinkedDeque<Integer> deque = new ConcurrentLinkedDeque<>();

        // Adding elements
        deque.addFirst(1);
        deque.addLast(2);
        deque.offerFirst(0);
        deque.offerLast(3);
        System.out.println("Deque after additions: " + deque);

        // Accessing elements
        System.out.println("peekFirst(): " + deque.peekFirst());
        System.out.println("peekLast(): " + deque.peekLast());

        // Removing elements
        System.out.println("pollFirst(): " + deque.pollFirst());
        System.out.println("pollLast(): " + deque.pollLast());
        System.out.println("Deque after removals: " + deque);

        // Push/Pop (stack behavior)
        deque.push(10);
        System.out.println("After push(10): " + deque);
        System.out.println("Pop(): " + deque.pop());
        System.out.println("After pop(): " + deque);

        // Iterating
        System.out.println("Iterating deque:");
        deque.forEach(System.out::println);
    }
}
