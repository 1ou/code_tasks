package test;

public class Task19 {
    public static void main(String[] args) throws InterruptedException {
        Object common = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (common) {
                try {
                    System.out.println("t1 waiting monitor has been released");
                    common.wait();
                    System.out.println("t1 waiting acquires monitor (FINISHES)");
                } catch (InterruptedException e) {
                    System.out.println("t1 interrupted");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (common) {
                System.out.println("t2 acuire monitor");
                common.notify();
                System.out.println("t2 finish");
                t1.interrupt();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
