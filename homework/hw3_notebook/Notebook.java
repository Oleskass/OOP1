package homework.hw3_notebook;

import java.util.ArrayList;
import java.util.Comparator;
// import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Notebook implements Comparable<Notebook> {

    // Homework:
    // Создать класс Notebook с полями (price(double), ram(int))
    // 1. Сгенерировать список объектов типа Notebook с разными значениям price и
    // ram
    // 2. Релизовать 3 сортировки: 1 - по цене, 2 - по памяти, 3 - сначала по
    // памяти, потом по цене (компэрэбл - по умолч, он только один, а компараторов
    // мб много)
    // 3. Отсортировать тремя способами стандартными средствами (Collections#sort
    // или List#sort)
    int ram;
    double price;

    public Notebook(int ram, double price) {
        this.ram = ram;
        this.price = price;
    }

    // ?? итератор
    // @Override
    // public Iterator<String> iterator() {
    // return new NotebookIterator(Arrays.copyOf(ram, price));
    // }
    // public static class NotebookIterator implements Iterator<String>{

    // }

    @Override
    public int compareTo(Notebook o) {
        return Double.compare(this.price, o.price);
    }

    public static Comparator<Notebook> ramComparator = new Comparator<Notebook>() {

        @Override
        public int compare(Notebook o1, Notebook o2) {
            return (o1.ram - o2.ram);
        }
    };

    public static Comparator<Notebook> ramPriceComparator = new Comparator<Notebook>() {

        @Override
        public int compare(Notebook o1, Notebook o2) {
            int res = (o1.ram - o2.ram);
            if (res != 0) {
                return res;
            } else {
                return Double.compare(o1.price, o2.price);
            }
        }
    };

    @Override
    public String toString() {
        return String.format("Память: %d Цена: %.0f.\n", this.ram, this.price);
    }

    public static Integer randRam() {
        Random rand = new Random();
        List<Integer> givenRam = new ArrayList<>(List.of(2, 3, 4, 6, 8, 12, 16, 20, 24, 32, 64));
        return givenRam.get(rand.nextInt(3));
        // return givenRam.get(rand.nextInt(givenRam.size()));

    }

    public static Double randPrice() {
        Random rand = new Random();
        return rand.nextDouble(20000, 90000);
    }

}
