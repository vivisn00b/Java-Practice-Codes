package MultiThreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " processing withdrawal ");
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();         // always put this in case of locks
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "insufficient balance");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try later");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        if(Thread.currentThread().isInterrupted())
            System.out.println("Do something if thread is interrupted");
    }
}

public class ThreadLock {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                acc1.withdraw(50);
            }
        };
        Thread t1 = new Thread(task, "Thread - Acc1 - 1");
        Thread t2 = new Thread(task, "Thread - Acc1 - 2");
        t1.start();
        t2.start();
    }
}
