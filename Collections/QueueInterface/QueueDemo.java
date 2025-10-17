// It stores and processes the data in an order where elements are added at the rear and removed from the front (FIFO order)
// Unlike List, elements cannot be accessed directly by index
package Collections.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueDemo {
    public static void main(String[] args) {
        // LinkedList as queue
        LinkedList<Integer> queueList = new LinkedList<>();
        queueList.addLast(1);  //enqueue = adding of elements
        queueList.addLast(2);
        queueList.addLast(3);
        queueList.addLast(4);
        Integer i= queueList.removeFirst();  //dequeue = removing of elements
        System.out.println(queueList.getFirst());  // peek

        Queue<Integer> queue1 = new LinkedList<>();  // LinkedList implements Deque which extends Queue
        queue1.add(1);
        System.out.println(queue1.size());
        System.out.println(queue1.remove(1)); // throws exception if empty
        System.out.println(queue1.poll());
//        System.out.println(queue1.element());  // throws exception if empty
        System.out.println(queue1.peek());

        Queue<Integer> queue2 =  new ArrayBlockingQueue<>(2);
        System.out.println(queue2.add(1)); // true
        System.out.println(queue2.offer(2)); // true
//         System.out.println(queue2.add(3)); // throws exception
        System.out.println(queue2.offer(3)); // false
    }
}
