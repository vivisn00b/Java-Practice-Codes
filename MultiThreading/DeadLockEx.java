package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TicketCounter {
    private int totalTickets;
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public TicketCounter(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public void bookTicket() {
        lock1.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is booking ticket");
            Thread.sleep(1000);
            lock2.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " is trying to make payment");
            } finally {
                lock2.unlock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock1.unlock();
        }
    }

    public void makePayment() {
        lock2.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is making payment");
            Thread.sleep(1000);
            lock1.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " trying to lock booking");
            } finally {
                lock1.unlock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock2.unlock();
        }
    }
}

class Thread1 extends Thread {
    private TicketCounter ticketCounter;

    public Thread1(TicketCounter ticketCounter) {
        this.ticketCounter = ticketCounter;
    }

    @Override
    public void run() {
        //synchronized (ticketCounter) {
            ticketCounter.bookTicket();
        //}
    }
}

class Thread2 extends Thread {
    private TicketCounter ticketCounter;

    public Thread2(TicketCounter ticketCounter) {
        this.ticketCounter = ticketCounter;
    }

    @Override
    public void run() {
        //synchronized (ticketCounter) {
            ticketCounter.makePayment();
        //}
    }
}

public class DeadLockEx {
    public static void main(String[] args) {
        TicketCounter ticketCounter = new TicketCounter(1);
        Thread1 t1 = new Thread1(ticketCounter);
        Thread2 t2 = new Thread2(ticketCounter);
        t1.start();
        t2.start();
    }
}
