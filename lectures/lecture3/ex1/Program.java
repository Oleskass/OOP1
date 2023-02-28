package lectures.lecture3.ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        // создаём коллекцию чисел и наполняем её
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(12);
        nums.add(123);
        nums.add(1234);
        nums.add(12345);
        // используем итератор и образаемся к методу .iterator
        Iterator<Integer> iter = nums.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        // Worker worker = new Worker(
        // "Имя", "Фамилия", 23, 4567);

        // Iterator<Object> components = worker.iterator();

    }
}
