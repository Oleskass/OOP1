package seminars.seminar3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain {

    public static void main(String[] args) {
        // Создать класс Notebook с полями (price(double), ram(int))
        // 1. Сгенерировать список объектов типа Notebook с разными значениям price и
        // ram
        // 2. Релизовать 3 сортировки: 1 - по цене, 2 - по памяти, 3 - сначала по
        // памяти, потом по цене
        // 3. Отсортировать тремя способами стандартными средствами (Collections#sort
        // или List#sort)

        List<Integer> integers = new ArrayList<>(List.of(5, 3, 10, 4, 6, 7, -9));
        List<String> strings = new ArrayList<>(List.of("first", "abcdek", "Igor", "geekbrains", "aa", "AA", "xzy"));

        Collections.sort(integers);
        System.out.println(integers);

        // сортировка строк встроенная, по лексикографичекому принципу
        Collections.sort(strings);
        System.out.println(strings);

        // // сортировка строк по нашему принципу - по длине слова
        // Comparator<String> strComparator = new StringLengthComparator();
        // Collections.sort(strings, strComparator);
        // System.out.println(strings);

        // // тк этот интерефейс имеет только один абстрактный метод, мы может объявить
        // его
        // // как лямбду:
        // Comparator<String> strComparator = (o1, o2) -> {
        // if (o1.length() < o2.length()) {
        // return -1; // здесь мб любое отриц.число
        // } else if (o1.length() > o2.length()) {
        // return 1;
        // } else {
        // return 0;
        // }
        // };
        // // ИЛИ! ещё короче:
        // Comparator<String> strComparator = (s1, s2) -> {
        // int diff = s1.length() - s2.length(); // получим или отриц, или 0, или
        // положит. - всё как нам и надо
        // return diff;
        // };
        // ИЛИ! сразу в return, без переменной diff: (а если! в лямбде всего одна
        // функция, то можно не писать return и скобочки не писать)
        Comparator<String> strComparator = (s1, s2) -> s1.length() - s2.length();

        // И!

        Collections.sort(strings, strComparator);
        System.out.println(strings);

        String x = "asdfg";
        String y = "foo";
        int compare = strComparator.compare(x, y);
        // if (compare > 0) {
        // String tmp = x;
        // x = y;
        // y = tmp;
        // }

    }

    public static class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() < o2.length()) {
                return -1;
            } else if (o1.length() > o2.length()) {
                return 1;
            } else {
                return 0;
            }
        }
    }

}
