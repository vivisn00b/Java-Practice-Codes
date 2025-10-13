package Collections.ListInterface.Vector;

import java.util.Vector;

public class ThreadSafetyInVector {
    public static void main(String[] args) {
        Vector<Integer> list = new Vector<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Size of vector: " + list.size());  // 2000
    }
}

class VectorThread implements Runnable {
    private Vector<Integer> vector;
    private int start;

    public VectorThread(Vector<Integer> vector, int start) {
        this.vector = vector;
        this.start = start;
    }

    @Override
    public void run() {
        for (int i = start; i < start + 5; i++) {
            vector.add(i);
            System.out.println(Thread.currentThread().getName() + " added: " + i);
            try {
                Thread.sleep(50); // simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class VectorThreadSafetyDemo {
    public static void main(String[] args) throws InterruptedException {
        Vector<Integer> sharedVector = new Vector<>();

        Thread t1 = new Thread(new VectorThread(sharedVector, 0), "Thread-1");
        Thread t2 = new Thread(new VectorThread(sharedVector, 100), "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Contents of Vector after threads finish: " + sharedVector);
    }
}