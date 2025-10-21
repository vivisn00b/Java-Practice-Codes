// ArrayBlockingQueue class implements the BlockingQueue interface.
// The queue has a fixed size, specified during creation.

package Collections.QueueInterface.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    private BlockingQueue<Integer> queue;
    private int value = 0;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Producer produced: " + value);
                queue.put(value++);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted");
            }
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer value = queue.take();
                System.out.println("Consumer consumed: " + value);
                Thread.sleep(2000);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted");
            }
        }
    }
}

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<Integer> fairQueue = new ArrayBlockingQueue<>(5, true);
        // When fairness is true , it ensures waiting threads access FIFO order
        // Threads acquiring locks or queue access are granted in arrival (FIFO) order.
        //Prevents thread starvation.
        //Comes at a small performance cost.

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        // thread-safe queue
        // wait for queue to become non-empty / wait for space
        // simplify concurrency problems like producer-consumer
        // standard queue --> immediately
        // empty --> remove ( no waiting )
        // full --> add ( no waiting )
        // Blocking queue
        // put -->  Blocks if the queue is full until space becomes available
        // take --> Blocks if the queue is empty until an element becomes available
        // offer --> Waits for space to become available, up to the specified timeout

        // A bounded, blocking queue backed by circular array
        // low memory overhead
        // uses a single lock for both enqueue and dequeue operations
        // more threads --> problem
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();
    }
}