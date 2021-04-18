package test;

import java.util.ArrayList;

public class Test11 {
    public static void main(String[] args) {
        ArrayList<Integer> original = new ArrayList<>(); //Line n1
        original.add(10); //Line n2

        ArrayList<Integer> cloned = (ArrayList<Integer>) original.clone();
        Integer i1 = cloned.get(0);
        ++i1;

        System.out.println(cloned);
    }
}
