package MultiThreading;

class SharedResources {
    private int data;
    private boolean hasData;

    public synchronized void produce(int value) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println(Thread.currentThread().getName() + " produced data: " + value);
        notify();
    }

    public synchronized int consume() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println(Thread.currentThread().getName() + " consumed data: " + data);
        notify();
        return data;
    }
}

class Producer implements Runnable {
    private SharedResources resources;

    public Producer(SharedResources resources){
        this.resources = resources;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            resources.produce(i);
        }
    }
}

class Consumer implements Runnable {
    private SharedResources resources;

    public Consumer(SharedResources resources) {
        this.resources = resources;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int value = resources.consume();
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResources resources = new SharedResources();
        Thread tProducer = new Thread(new Producer(resources));
        Thread tCosumer = new Thread(new Consumer(resources));
        tProducer.start();
        tCosumer.start();
    }
}

// wait() - Makes the current thread pause execution and release the lock it holds on the object.
// notify() -  Wakes up ONE thread that is waiting on this object's monitor.
// notifyAll() - Wakes up ALL threads waiting on this object's monitor.