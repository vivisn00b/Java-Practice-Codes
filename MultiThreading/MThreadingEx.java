package MultiThreading;

class MultiThread extends Thread {
    public void run() {
        try {
            System.out.println("Thred: " + Thread.currentThread().getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class MultiRunnable implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class MThreadingEx {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
//            MultiThread obj = new MultiThread();
//            obj.start();
            Thread object = new Thread(new MultiRunnable());
            object.start();
        }
    }
}
