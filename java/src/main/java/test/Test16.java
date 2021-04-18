package test;

@FunctionalInterface
interface ITester {
    void test();
}

public class Test16 {
    public static void main(String[] args) {
        ITester obj = () -> System.out.println("KEEP CALM");
    }
}