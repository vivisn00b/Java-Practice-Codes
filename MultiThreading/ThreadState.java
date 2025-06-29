package MultiThreading;

class TicketBook implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("State of bookingThread while mainThread is waiting: " + TicketSystem.mainThread.getState());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TicketSystem implements Runnable {
    public static Thread mainThread;
    public static TicketSystem ticketSystem;

    @Override
    public void run() {
        TicketBook booking = new TicketBook();
        Thread bookingThread = new Thread(booking);
        System.out.println("State after creating bookingThread: " + bookingThread.getState());

        bookingThread.start();
        System.out.println("State after starting bookingThread: " + bookingThread.getState());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State after sleeping bookingThread: " + bookingThread.getState());

        try {
           // Moves mainThread to waiting state
            bookingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("State after bookingThread finishes: " + bookingThread.getState());
    }
}

public class ThreadState {
    public static void main(String[] args) {
        TicketSystem.ticketSystem = new TicketSystem();
        TicketSystem.mainThread = new Thread(TicketSystem.ticketSystem);
        System.out.println("State after creating mainThread: " + TicketSystem.mainThread.getState());
        TicketSystem.mainThread.start();
        System.out.println("State after starting mainThread: " + TicketSystem.mainThread.getState());
    }
}
