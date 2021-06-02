package test;

import java.util.concurrent.atomic.AtomicLong;

public class Test18 {
    private  static AtomicLong ii = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("t1");
            for (int i = 0; i < 100000; i++) {
                ii.incrementAndGet();
            }
        });
        Thread t2 = new Thread(() -> {
            System.out.println("t2");
            for (int i = 0; i < 100000; i++) {
                ii.incrementAndGet();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(ii);
    }
}
