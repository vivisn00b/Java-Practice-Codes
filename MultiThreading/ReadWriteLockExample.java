//Read-Write Lock is a concurrency control mechanism that allows multiple threads to read shared data simultaneously while restricting write access to a single thread at a time.

package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    private  int count =0;
    private final ReadWriteLock RWlock = new ReentrantReadWriteLock();
    private final Lock Rlock = RWlock.readLock();
    private final Lock Wlock = RWlock.writeLock();

    public void increment() {
        Wlock.lock();
        try {
            count++;
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            Wlock.unlock();
        }
    }

    public int getCount() {
        Rlock.lock();
        try {
            return count;
        } finally {
            Rlock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockExample RWcounter = new ReadWriteLockExample();
        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " read: " + RWcounter.getCount());
                }
            }
        };
        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    RWcounter.increment();
                    System.out.println(Thread.currentThread().getName() + " write");
                }
            }
        };

        Thread writerThread1 = new Thread(writeTask);
        Thread writerThread2 = new Thread(writeTask);
        Thread readerThread1 = new Thread(readTask);
        Thread readerThread2 = new Thread(readTask);
        writerThread1.start();
        readerThread1.start();
        writerThread2.start();
        readerThread2.start();
        System.out.println("Final count: " + RWcounter.getCount());
    }
}
