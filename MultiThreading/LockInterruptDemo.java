package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class LockInterruptDemo {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("[t1 - lock()] Trying to acquire lock...");
            lock.lock(); //not interruptible
            try {
                System.out.println("[t1 - lock()] Acquired lock!");
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("[t2 - tryLock()] Trying to acquire lock...");
            try {
                boolean gotLock = lock.tryLock(); // NOT interruptible
                //boolean gotLock = lock.tryLock(5, TimeUnit.SECONDS); // interruptible
                if (gotLock) {
                    try {
                        System.out.println("[t2 - tryLock()] Acquired lock!");
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println("[t2 - tryLock()] Could not acquire lock (timeout).");
                }
            } catch (Exception e) {
                System.out.println("[t2 - tryLock()] Interrupted while waiting.");
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                System.out.println("[t3 - lockInterruptibly()] Trying to acquire lock...");
                lock.lockInterruptibly(); // CAN be interrupted!
                try {
                    System.out.println("[t3 - lockInterruptibly()] Acquired lock!");
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                System.out.println("[t3 - lockInterruptibly()] Interrupted while waiting!");
            }
        });

        // Main thread acquires lock to block others
        lock.lock();
        System.out.println("[Main] Lock acquired to block others...");

        t1.start();
        t2.start();
        t3.start();

        // Sleep to ensure all threads are waiting for the lock
        Thread.sleep(2000);

        // Try to interrupt all threads
        System.out.println("\n[Main] Interrupting t1, t2, t3...\n");
        t1.interrupt(); // No effect on lock()
        t2.interrupt(); // No effect during tryLock()
        t3.interrupt(); // Will interrupt lockInterruptibly()

        // Release the lock so any non-interrupted thread can continue
        Thread.sleep(3000);
        lock.unlock();
        System.out.println("[Main] Lock released.");
    }
}


//        | Method                     | Waits? | Interruptible? | What happens                                    |
//        | -------------------------- | ------ | -------------- | ----------------------------------------------- |
//        | lock() (used by t1)        | Yes    | ❌ No          | Waits until lock is free, **ignores** interrupt |
//        | tryLock() (used by t2)     | No     | ❌ No          | Immediately returns false if lock not available |
//        | lockInterruptibly() (t3)   | Yes    | ✅ Yes         | Interrupted while waiting, throws exception     |
