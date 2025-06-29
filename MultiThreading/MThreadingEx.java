package MultiThreading;

class MultiThread extends Thread {
    public void run() {
//        try {
//            System.out.println("Thred: " + Thread.currentThread().getId());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        for (int i = 0; i < 30; i++) {
            //System.out.println("Hello World");
            System.out.println(Thread.currentThread().getName());
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
        MultiThread MThread = new MultiThread();
        MThread.start();
        for (int i = 0; i < 50; i++) {
//            MultiThread obj = new MultiThread();
//            obj.start();
//            Thread object = new Thread(new MultiRunnable());
//            object.start();
            //System.out.println("MULTI THREADING!!");
            System.out.println(Thread.currentThread().getName());
        }
    }
}
