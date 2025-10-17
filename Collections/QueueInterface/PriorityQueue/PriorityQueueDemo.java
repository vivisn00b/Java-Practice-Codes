// PriorityQueue class lets us process elements based on their priority instead of the usual FIFO order of a normal queue
// By default, it uses natural ordering (min-heap), but a custom comparator can be used to define different priorities
// Uses Heap Data Structure internally
// Dynamic sizing
// Does not allow null elements

package Collections.QueueInterface.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Collections;

class PriorityTask {
    String name;
    int priority;

    PriorityTask(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", priority=" + priority;
    }
}

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(40);
        pq.add(10);
        pq.add(30);
        pq.add(20);
        System.out.println("PriorityQueue: " + pq);
        System.out.println("Peek (top priority): " + pq.peek());
        System.out.println("Polling elements (in priority order):");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        //PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> b - a);  // descending order
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue.offer(4);
        priorityQueue.offer(1);
        priorityQueue.offer(7);
        priorityQueue.offer(3);
        System.out.println("PriorityQueue (Max-Heap): " + priorityQueue);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

        // PriorityTask
        PriorityQueue<PriorityTask> ptq = new PriorityQueue<>(Comparator.comparingInt(t -> t.priority));

        ptq.add(new PriorityTask("Code", 3));
        ptq.add(new PriorityTask("Eat", 1));
        ptq.add(new PriorityTask("Sleep", 2));

        System.out.println("Tasks by priority:");
        while (!ptq.isEmpty()) {
            System.out.println(ptq.poll());
        }
    }
}
