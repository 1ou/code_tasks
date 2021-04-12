package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        System.out.println("hi");
        try {
            t();
            t2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void t() {
        Stream<Integer> numStream = Stream.of(10, 20, 30);
        numStream.map(n -> n + 10).peek(s -> System.out.print(s));
//        numStream.forEach(s -> System.out.println(s));
    }

    public static void t2() {
        var lst = Arrays.asList(1, 2, 3, 4);
        lst.replaceAll(x -> x + 100);
        System.out.println("-Completed-");
    }
}
