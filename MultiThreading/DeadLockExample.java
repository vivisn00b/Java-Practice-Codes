package MultiThreading;

class Pen {
    public synchronized void writeWithPenAndPaper(Paperr paperr) {
        System.out.println(Thread.currentThread().getName() + " is using pen " + this + " and trying to use paper " + paperr);
        paperr.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " finished using pen " + this);
    }
}

class Paperr {
    public synchronized void writeWithPaperAndPen(Pen pen) {
        System.out.println(Thread.currentThread().getName() + " is using paper " + this + " and trying to use pen " + pen);
        pen.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " finished using paper " + this);
    }
}

class Task1 implements Runnable {
    private Pen pen;
    private Paperr paperr;

    public Task1(Pen pen, Paperr paperr) {
        this.pen = pen;
        this.paperr = paperr;
    }

    @Override
    public void run() {
        pen.writeWithPenAndPaper(paperr); // thread1 locks pen and tries to lock paper
    }
}

class Task2 implements Runnable {
    private Pen pen;
    private Paperr paperr;

    public Task2(Pen pen, Paperr paperr) {
        this.pen = pen;
        this.paperr = paperr;
    }

    @Override
    public void run() {
//        synchronized (pen){
//            paperr.writeWithPaperAndPen(pen);
//        }
        paperr.writeWithPaperAndPen(pen); // thread2 locks paper and tries to lock pen
    }
}


class DeadlockExample {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paperr paperr = new Paperr();

        Thread thread1 = new Thread(new Task1(pen, paperr), "Thread-1");
        Thread thread2 = new Thread(new Task2(pen, paperr), "Thread-2");

        thread1.start();
        thread2.start();
    }
}