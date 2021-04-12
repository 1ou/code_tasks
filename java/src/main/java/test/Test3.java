package test;

import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        String[] a = new String[5];
        Arrays.fill(a, "Hello");
        System.out.println(a[2]);
        new Test3();
    }
    public Test3() {
        new K().kk();
    }

    public static class K {
        static String kk = "dffdf";
        public static void kk() {
            System.out.println("hiii");
            System.out.println(K.kk);
            float H = 222.222_444F;
        }
    }
}
