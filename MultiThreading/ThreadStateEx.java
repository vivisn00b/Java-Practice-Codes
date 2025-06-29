package MultiThreading;

class ThreadStateEx extends Thread {
    @Override
    public void run() {
        //System.out.println(Thread.currentThread().getName());
        System.out.println("RUNNING LESSSGOOOOO!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Thread finishing: " + Thread.currentThread().getState());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadStateEx t1 = new ThreadStateEx();
        //System.out.println(Thread.currentThread().getName());
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        Thread.sleep(150);
        System.out.println(t1.getState());
        t1.join();  // Main thread waits for t1 to finish
        System.out.println(t1.getState());
        // When you move main() into a different class, the JVM might terminate the main() thread before the final System.out.println(t1.getState()) runs
        // especially if t1.join() returns just after the thread finishes and before the print executes.
    }
}