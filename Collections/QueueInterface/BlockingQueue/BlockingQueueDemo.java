// It is a specialized Queue implementation designed to handle thread-safe operations in concurrent environments
// BlockingQueue is commonly used in Producer-Consumer patterns
// Has blocking behavior if the queue is full (for producers) or empty (for consumers)
// Queue has a fixed size, specified during creation
// No Null Elements

package Collections.QueueInterface.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

    // Bounded BlockingQueue: Fixed capacity, blocking producers when full.
    // Unbounded BlockingQueue: Expands as needed (e.g., backed by a LinkedList), though subject to memory constraints.

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        // 1. put() - blocks if full
        queue.put("A");
        queue.put("B");
        queue.put("C");
        System.out.println("After put: " + queue);

        // 2. offer() + timeout - waits up to timeout if capacity is full
        boolean added = queue.offer("D", 2, TimeUnit.SECONDS);
        System.out.println("Offer with timeout successful? " + added);

        // 3. take() - retrieves and removes head, blocks if empty
        System.out.println("Take: " + queue.take());
        System.out.println("Queue after take: " + queue);

        // 4. peek() - examines head without removal
        System.out.println("Peek: " + queue.peek());

        // 5. poll() - retrieves and removes head, null if empty
        System.out.println("Poll: " + queue.poll());
        System.out.println("Queue after poll: " + queue);

        // 6. remainingCapacity()
        System.out.println("Remaining capacity: " + queue.remainingCapacity());

        // 7. drainTo() - transfer to another collection
        BlockingQueue<String> queue2 = new ArrayBlockingQueue<>(3);
        int moved = queue.drainTo(queue2);
        // int drainTo(Collection<? super E> c, int maxElements) - Removes at most the given number of elements and adds to collection.
        System.out.println("Elements moved: " + moved);
        System.out.println("Queue1: " + queue + ", Queue2: " + queue2);

        // 8. clear()
        queue2.clear();
        System.out.println("After clear: " + queue2);
    }
}
