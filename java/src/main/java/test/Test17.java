package test;

import java.util.Arrays;

public class Test17 {
    public static void main(String [] args) {
        A a = new A();
        new Thread(() -> {
            while (!a.isReady) {

            }
            System.out.println("isReady true t1");
            for (int i = 0; i < a.arr.length; i++) {
                System.out.print(a.arr[i] + " ");
            }
            System.out.println();
        }).start();

        new Thread(() -> {
            Arrays.sort(a.arr);
            System.out.println("array sorted t2");
            a.isReady = true;
            System.out.println("isReady true t2");
        }).start();

    }
}