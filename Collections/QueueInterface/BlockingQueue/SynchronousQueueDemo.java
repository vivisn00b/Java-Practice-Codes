// Use Case: Thread synchronization and direct data handoff between producer and consumer threads
// Concurrency Mechanism: Internally uses TransferStack (LIFO) or TransferQueue (FIFO) depending on fairness setting

package Collections.QueueInterface.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> queue =  new SynchronousQueue<>();
        // each insert operation must wait for a corresponding remove operation by another thread and vice versa.
        // it cannot store elements, capacity of at most one element
        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producer is waiting to transfer...");
                queue.put("Hello from producer!");
                System.out.println("Producer has transferred the message.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Producer was interrupted.");
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Consumer is waiting to receive...");
                String message = queue.take();
                System.out.println("Consumer received: " + message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Consumer was interrupted.");
            }
        });
        producer.start();
        consumer.start();
    }
}
