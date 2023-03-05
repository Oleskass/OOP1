package lectures.lecture4.ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        // коллекция, наполненная какими-то эл-тами, в данном случае - примитивными типами
        List<Integer> data = new ArrayList<>(Arrays.asList(1,2,3,4));
        List<String> data2 = new ArrayList<>(Arrays.asList("1,2,3,4", "cat", "mouse", "6"));
        

        Integer t = Methods.getElementFromUCollection(data, 1);
        System.out.println(t);
        String s = Methods.getElementFromUCollection(data2, 0);
        String s2 = Methods.getElementFromUCollection(data2, 2);
        System.out.println(s);
        System.out.println(s2);
        // var el = Methods.getElementFromIntegerCollection(data, 1);
        // System.out.println(el);
        // el = Methods.<Integer>getElementFromUCollection(data, 2);
        // el = Methods.getElementFromUCollection(data, 2);
        // System.out.println(el);

    }
}
