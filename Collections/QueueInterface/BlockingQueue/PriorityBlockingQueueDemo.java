// Thread-safe, priority-based queue that supports blocking retrieval operations.
// It combines the behavior of a PriorityQueue with the concurrency features of the BlockingQueue interface.
// Non-fair: No FIFO guarantee for same-priority elements.
// Null elements not allowed.

package Collections.QueueInterface.BlockingQueue;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class Task {
    String name;
    int priority;
    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}

public class PriorityBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue2 = new PriorityBlockingQueue<>(11, Comparator.reverseOrder());
        // unbounded
        // Binary Heap as array and can grow dynamically
        // Head is based on their natural ordering or a provided Comparator like priority queue
        // Producers never block (since unbounded), put() won't be blocked
        // Consumers (take(), poll(timeout)) block when empty.
        queue2.add("apple");
        queue2.add("apple");  // Built on linked nodes — each insertion dynamically allocates a new node.
        queue2.add("banana");
        queue2.add("cherry");
        System.out.println(queue2);  // Elements are ordered by insertion order (First-In-First-Out)

        Comparator<Task> comparator = Comparator.comparingInt(t -> t.priority);
        PriorityBlockingQueue<Task> tasks = new PriorityBlockingQueue<>(10, comparator);
        tasks.put(new Task("Low", 3));
        tasks.put(new Task("High", 1));
        tasks.put(new Task("Medium", 2));
        System.out.println("Tasks in queue (priority order):");
        while (!tasks.isEmpty()) {
            System.out.println(tasks.take());  // Retrieves and removes value at head, waits if queue empty.
        }
    }
}
