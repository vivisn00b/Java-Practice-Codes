package Collections.QueueInterface.PriorityQueue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueMethods {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(6);
        pq.add(5);
        pq.add(10);
        pq.add(6);
        pq.add(41);
        pq.add(19);
        pq.add(3);
        System.out.println("After add(): " + pq);

        // offer() - inserts the specified element (like add, returns false if fails)
        pq.offer(2);
        pq.offer(4);
        System.out.println("After offer(): " + pq);

        // peek() - retrieves, but does not remove, the head (lowest element)
        System.out.println("peek(): " + pq.peek());

        // poll() - retrieves and removes the head of the queue
        System.out.println("poll(): " + pq.poll());
        System.out.println("After poll(): " + pq);

        // remove() - retrieves and removes the head (similar to poll but throws exception if empty)
        System.out.println("remove(): " + pq.remove());
        System.out.println("After remove(): " + pq);

        // remove(Object o) - removes a single instance of the specified element, if it exists
        boolean removed = pq.remove(4);
        System.out.println("remove(4) successful? " + removed);
        System.out.println("After remove(4): " + pq);

        // removeIf()
        pq.removeIf(n -> (n%2==0));  // remove even elements

        // removeAll() - Removes all of this collection's elements that are also contained in the queue
        pq.removeAll(Arrays.asList(41, 19));

        // retainAll() - opposite of removeAll()

        // element() - Retrieves, but does not remove, the head of this queue
        System.out.println(pq.element());

        // contains(Object o) - checks if specified element is in the queue
        boolean contains3 = pq.contains(3);
        System.out.println("Contains 3? " + contains3);

        // size() - returns the number of elements in the queue
        System.out.println("Size: " + pq.size());

        // isEmpty() - checks if the queue is empty
        System.out.println("Is empty? " + pq.isEmpty());

        // iterator() - returns iterator over elements (in no specific order)
        Iterator<Integer> itr = pq.iterator();
        System.out.print("Iterator elements: ");
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

        // toArray() - returns an Object[] containing all elements
        Object[] arr = pq.toArray();
        System.out.println("toArray(): ");
        for (Object o : arr) {
            System.out.print(o + " ");
        }
        System.out.println();

        // clear() - removes all elements from the queue
        pq.clear();
        System.out.println("After clear(), is empty? " + pq.isEmpty());
    }
}
