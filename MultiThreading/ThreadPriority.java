package MultiThreading;

public class ThreadPriority extends Thread {

    ThreadPriority(String name) {
        super(name);      //custom thread name
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            StringBuilder test = new StringBuilder();
            test.append("lmao".repeat(50000));
            System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority() + " - Count: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        //ThreadPriority t1 = new ThreadPriority("Viv");
        ThreadPriority l = new ThreadPriority("Low");
        ThreadPriority m = new ThreadPriority("Normal");
        ThreadPriority h = new ThreadPriority("High");
        l.setPriority(Thread.MIN_PRIORITY);
        m.setPriority(Thread.NORM_PRIORITY);
        h.setPriority(Thread.MAX_PRIORITY);
        l.start();
        m.start();
        h.start();
    }
}
