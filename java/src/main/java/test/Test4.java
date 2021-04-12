package test;

public class Test4 {

    public static class A {
        public Number hello(Number i) {
            System.out.println("A hello int");
            return 0;
        }
    }

    public static class B extends A {
        public Integer hello(Number i) {
            System.out.println("B hello int");
            return 0;
        }
    }

    public static void main(String[] args) {
        A a = new B();
        a.hello(1);
    }
}
