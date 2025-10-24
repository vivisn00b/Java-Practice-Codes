// ConcurrentLinkedDeque is a thread-safe, non-blocking, and unbounded double-ended queue
// It is the deque counterpart of ConcurrentLinkedQueue, allowing insertion and removal from both ends concurrently.
// Internally it implements Doubly linked list

package Collections.QueueInterface.ConcurrentLinkedDeque;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequeDemo {
    public static void main(String[] args) {
        Deque<Integer> deque = new ConcurrentLinkedDeque<>();

        // Thread 1 - Producer (adds elements)
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 25; i++) {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    deque.addLast(i);
                    System.out.println("Producer added: " + i);
                }
            }
        });

        // Thread 2 - Consumer (removes elements)
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 25; i++) {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    Integer val = deque.pollFirst();
                    System.out.println("Consumer removed: " + val);
                }
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The Deque is: " + deque);
    }
}
