package MultiThreading.ThreadSafety;

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;   // Only one thread modifies count at a time.
    }

//    public void increment() {
//        synchronized (this){
//            count++;
//        }
//    }

    public int getCount() {
        return count;
    }
}

class Sync extends Thread{
    private Counter counter;

    public Sync(Counter counter) {
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
        Sync sync1 = new Sync(counter);
        Sync sync2 = new Sync(counter);
        sync1.start();
        sync2.start();
        try {
            sync1.join();
            sync2.join();
        } catch (Exception e) {
            System.out.println();
        }
        System.out.println(counter.getCount());
    }
}
