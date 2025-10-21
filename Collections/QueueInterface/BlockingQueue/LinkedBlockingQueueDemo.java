// It provides a thread-safe, bounded, or unbounded queue used for managing tasks in a producer-consumer scenario.
// If no capacity → unbounded (internally Integer.MAX_VALUE)

package Collections.QueueInterface.BlockingQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(3);
        // Optionally bounded backed by LinkedList
        // Uses two separate locks for enqueue and dequeue operations
        // Higher concurrency between producers and consumers

        // put() – blocks if full
        queue.put("A");
        queue.put("B");
        queue.put("C");
        System.out.println("After put(): " + queue);

        // offer() – try to add without blocking
        System.out.println("offer(D): " + queue.offer("D")); // false since full

        // offer() with timeout
        System.out.println("offer(E, 2s): " + queue.offer("E", 2, TimeUnit.SECONDS));

        // take() – removes head; blocks if empty
        System.out.println("take(): " + queue.take());
        System.out.println("Queue after take(): " + queue);

        // peek() – view head (no removal)
        System.out.println("peek(): " + queue.peek());

        // poll() – removes head if available
        System.out.println("poll(): " + queue.poll());
        System.out.println("Queue after poll(): " + queue);

        // add() – throws exception if full
        queue.add("X");
        System.out.println("After add(X): " + queue);

        // remainingCapacity()
        System.out.println("Remaining capacity: " + queue.remainingCapacity());

        // contains() – check if element present
        System.out.println("Contains B? " + queue.contains("B"));

        // drainTo() – move elements to another collection
        List<String> list = new ArrayList<>();
        queue.drainTo(list);
        System.out.println("Drained list: " + list);

        // clear() – remove all
        queue.clear();
        System.out.println("After clear(), empty? " + queue.isEmpty());
    }
}
