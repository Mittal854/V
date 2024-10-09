
class MyThread1 extends Thread {

    public void run() {
        for (int i = 0; i < 190; i++) {
            System.out.println("Thread 1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}

class MyThread2 implements Runnable {

    Thread t = new Thread(this);

    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("Thread 2 for " + i + " times");
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class Threading {

    public static void main(String[] args) {
        MyThread1 mt1 = new MyThread1();
        MyThread2 mt2 = new MyThread2();
        System.err.println("Thread.CurrentThread().getName() = " + Thread.currentThread().getName());
        mt1.start();
        System.out.println(mt1.isAlive());
        mt2.t.start();
        try {
            mt1.join();
            System.out.println("Starting");
            mt2.t.join();
            System.out.println(mt1.isAlive());

            System.out.println("Ending");

        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

}
