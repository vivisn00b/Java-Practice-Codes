package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

class ATMlock {
    private int balance = 10000;
    private final Lock lock = new ReentrantLock();

    public void withdraw(String user, int amount) {
        lock.lock();
        try {
            System.out.println(user + " is withdrawing...");
            if (balance >= amount) {
                Thread.sleep(2000);
                balance -= amount;
                System.out.println(user + " completed withdrawal... Remaining: " + balance);
            } else {
                System.out.println(user + " has insufficient balance!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void withdrawTryLock(String user, int amount) {
        try {
            if (lock.tryLock(4, TimeUnit.SECONDS)) {
                try {
                    System.out.println(user + " got the lock using tryLock()");
                    if (balance >= amount) {
                        Thread.sleep(2000);
                        balance -= amount;
                        System.out.println(user + " completed withdrawal... Remaining: " + balance);
                    } else {
                        System.out.println(user + " has insufficient balance!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            } else
                System.out.println(user + " couldn't acquire lock using tryLock(). Skipping...");
        } catch (Exception e) {
            Thread.currentThread().interrupt();;
        }
        if(Thread.currentThread().isInterrupted())
            System.out.println("Do something if thread is interrupted");
    }

    public void WithdrawInterruptibly(String user, int amount) {
        try {
            System.out.println(user + " is waiting for the lock (interruptibly)...");
            lock.lockInterruptibly();

            try {
                System.out.println(user + " acquired lock using lockInterruptibly().");
                Thread.sleep(2000);

                if (balance >= amount) {
                    balance -= amount;
                    System.out.println(user + " completed withdrawal. Remaining balance: ₹" + balance);
                } else {
                    System.out.println(user + " has insufficient balance.");
                }
            } finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            System.out.println(user + " was interrupted while waiting for the lock.");
            Thread.currentThread().interrupt();
        }
    }
}

class LockExample {
    public static void main(String[] args) {
        ATMlock atm = new ATMlock();

        Thread t1 = new Thread(() -> atm.withdraw("Amit", 400));
        Thread t2 = new Thread(() -> atm.WithdrawInterruptibly("VIPuser", 100));
        Thread t3 = new Thread(() -> atm.withdrawTryLock("Vivy", 500));
        t1.start();
        t2.start();
        t3.start();
    }
}

//        | Concept                      | Explanation                                                                |
//        | ---------------------------- | -------------------------------------------------------------------------- |
//        | ReentrantLock                | A flexible lock with advanced features like interruptibility and fairness. |
//        | lock()                       | Acquires the lock, waits indefinitely.                                     |
//        | tryLock(timeout)             | Tries for a limited time; returns `false` if not acquired.                 |
//        | lockInterruptibly()          | Waits for the lock but can be interrupted while waiting.                   |
//        | finally { lock.unlock(); }   | Always used to release the lock to prevent deadlocks.                      |
//        | Thread.sleep()               | Simulates delay, here acting as the transaction time.                      |
