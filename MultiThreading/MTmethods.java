// start, run, sleep, join, setPriority, interrupt, yield, setDaemon

package MultiThreading;

public class MTmethods extends Thread {
    @Override
    public void run() {
//        try {
//            Thread.sleep(1000);
//            System.out.println("Thread is running");
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }

//        for (int i = 0; i < 5; i++) {
//            System.out.println(Thread.currentThread().getName() + " is running");
//            Thread.yield();    // provides a hint to the thread scheduler that the current thread is willing to temporarily pause its execution and allow other threads of the same or higher priority to run
//        }

        while (true) {
            System.out.println("Thread running in daemon function");
        }
    }

    public static void main(String[] args) {
        MTmethods t1 = new MTmethods();
        // Daemon threads runs in background
        t1.setDaemon(true);
        t1.start();
        System.out.println("Main thread execution is done...");
//        t1.interrupt();
//        MTmethods t2 = new MTmethods();
//        MTmethods t3 = new MTmethods();
//        t2.start();
//        t3.start();
    }
}
