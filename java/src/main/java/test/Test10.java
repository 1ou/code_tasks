package test;

public class Test10 {
    public static void main(String [] args) {
        var a = 3; //Line n1
        var b = 5; //Line n2
        var c = 7; //Line n3
        var d = 9; //Line n4
        boolean res = --a + --b < 1 && c++ + d++ > 1;
        System.out.printf("a = %d, b = %d, c = %d, d = %d, res = %b", a, b, c, d, res);
    }
}
