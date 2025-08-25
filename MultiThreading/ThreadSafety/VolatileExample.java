package MultiThreading.ThreadSafety;

import java.util.concurrent.*;

class SharedObj {
    private volatile boolean flag = false; // reads the value directly from the main memory

    public void setFlag() {
        System.out.println("Writer thread made the flag true...");
        flag = true;
    }

    public void printIfTrue() {
        while (!flag) {  // If the variable wasn't set to volatile, the cached value of flag would've been used, and the loop would've been infinite
            // do nothing
        }
        System.out.println("Flag is true!");
    }
}

public class VolatileExample {
    public static void main(String[] args) {
        SharedObj sharedObj = new SharedObj();
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            sharedObj.setFlag();
        });
        Thread readerThread = new Thread(() -> sharedObj.printIfTrue());
        writerThread.start();
        readerThread.start();
    }
}
