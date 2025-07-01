package MultiThreading;

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;   // Only one thread modifies count at a time.
    }

    public int getCount() {
        return count;
    }
}

class Synchronization extends Thread{
    private Counter counter;

    public Synchronization(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Synchronization sync = new Synchronization(counter);
        Synchronization sync2 = new Synchronization(counter);
        sync.start();
        sync2.start();
        try {
            sync.join();
            sync2.join();
        } catch (Exception e) {
            System.out.println();
        }
        System.out.println(counter.getCount());
    }
}
