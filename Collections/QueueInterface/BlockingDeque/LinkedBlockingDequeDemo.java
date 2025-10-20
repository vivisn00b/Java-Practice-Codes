// A LinkedBlockingDeque is a thread-safe (uses ReentrantLock for concurrency control), optionally bounded, blocking double-ended queue.
// It allows insertion and removal of elements from both ends and provides blocking behavior for concurrent producers and consumers.
// Implements BlockingDeque<E> which extends BlockingQueue<E> and Deque<E>
// Internally implements doubly linked list
// Works as both queue (FIFO) and stack (LIFO)

package Collections.QueueInterface.BlockingDeque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDequeDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<Integer> deque = new LinkedBlockingDeque<>();

        // Adding elements from both ends
        deque.offerFirst(1);
        deque.offerLast(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        System.out.println("Deque after offers: " + deque);

        // Peek elements without removal
        System.out.println("peekFirst: " + deque.peekFirst());
        System.out.println("peekLast: " + deque.peekLast());

        // Remove elements
        System.out.println("pollFirst: " + deque.pollFirst()); // removes from front
        System.out.println("pollLast: " + deque.pollLast());   // removes from end
        System.out.println("Deque after polls: " + deque);

        // Blocking operations (won’t block here since queue not full/empty)
        deque.putLast(5); // putLast() == put()
        System.out.println("After putLast(5): " + deque);

        // Drain into another collection
        LinkedBlockingDeque<Integer> deque2 = new LinkedBlockingDeque<>();
        deque.drainTo(deque2);
        System.out.println("Deque2 after drainTo: " + deque2);
    }
}

//addFirst(e)	Inserts at front; throws if full (for bounded deque).
//addLast(e)	Inserts at end; throws if full.
//offerFirst(e)	Inserts at front, returns false if full.
//offerLast(e)	Inserts at end, returns false if full.
//putFirst(e)	Inserts at front, blocks if full.
//putLast(e)	Inserts at end, blocks if full.

//takeFirst()	Removes and returns first element; blocks if empty.
//takeLast()	Removes and returns last element; blocks if empty.
//pollFirst()	Retrieves and removes first element; returns null if empty.
//pollLast()	Retrieves and removes last element; returns null if empty.
//removeFirst()	Removes first; throws exception if empty.
//removeLast()	Removes last; throws exception if empty.

//peekFirst()	Returns first element without removing; null if empty.
//peekLast()	Returns last element without removing; null if empty.