package test;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Test8 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("A", "E", "I", "O", "U"));
        if(verify(list, l -> l.remove("I"))) //Line n1
            if(verify(list, l -> l.add("I"))){} //Line n2

        System.out.println(list);
    }

    private static boolean verify(List<String> list, Predicate<List<String>> predicate) {
        return predicate.test(list); //Line n3
    }
}