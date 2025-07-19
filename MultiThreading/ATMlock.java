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

    public void withdraw2(String user, int amount) {
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
}

class LockExample {
    public static void main(String[] args) {
        ATMlock atm = new ATMlock();

        Thread t1 = new Thread(() -> atm.withdraw("Amit", 400));
        Thread t2 = new Thread(() -> atm.withdraw2("Vivy", 500));
        t1.start();
        t2.start();
    }
}