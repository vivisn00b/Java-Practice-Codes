// ConcurrentLinkedQueue is a non-blocking, thread-safe, unbounded queue based on a singly linked list
// Unlike blocking queues, it does not lock threads instead it uses CAS (Compare-And-Swap) operations to achieve concurrency.

package Collections.QueueInterface.ConcurrentLinkedQueue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueDemo {

    private static ConcurrentLinkedQueue<String> taskQueue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {

        Thread producer = new Thread(() -> {
            while (true) {
                try {
                    taskQueue.add("Task " + System.currentTimeMillis());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    String task = taskQueue.poll();
                    System.out.println("Processing: " + task);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        consumer.start();
    }
}