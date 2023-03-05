package seminars.seminar4;

// import java.util.ArrayList;
// import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // NumberStorage<String> stringNumberStorage = new NumberStorage<>();
        // NumberStorage<Integer> integerNumberStorage = new NumberStorage<>();
        // NumberStorage<Long> longNumberStorage = new NumberStorage<>();
        // NumberStorage<Double> doubleNumberStorage = new NumberStorage<>();
        //
        // doubleNumberStorage.add(2.3);
        // doubleNumberStorage.add(2.4);
        // doubleNumberStorage.add(1.1);
        // System.out.println(doubleNumberStorage.sum());
        //
        // NumberStorage numberStorage = new NumberStorage();
        // numberStorage.add(2.3);
        // numberStorage.add(2L);
        // numberStorage.add(5);
        //
        //
        // List<Integer> byteArrayList = new ArrayList<>();

        // Stream - это абстракция, представлена в виде интерфейса; поток данных. Его
        // можно создать с какого-нибудь источника,
        IntStream intStreamRange = IntStream.range(0, 50); // поток примитивов; от 0 до 49
        Stream<Integer> boxed = intStreamRange.boxed(); // потом параметризован чем-то (здесь Integer)
        // filter принимает интерфейс Predicat
        // Stream<T> filter(Predicate<? super T> predicate);
        // он тожн super потому что consumer - обрабатывает, принимает переменные
        Stream<Integer> filtered = boxed.filter(it -> it < 10);
        // лямбда:
        Stream<String> stringStream = filtered.map(integer -> String.valueOf(integer)); // метод map принимает интерфейс
                                                                                        // Function (у нас принимает
                                                                                        // целое число, а возвращает
                                                                                        // строку)
        // <R> Stream<R> map(Function<? super T, ? extends R> mapper);
        // в методе map стрима есть ограничение: принимаемое значение у нас super T
        // (consumer)(принимает как и Integer, так и Number. В обратную сторону так не
        // работало бы), а возвращаемое extends К (например из строки получаем Number, а
        // если так, то и Integer можем получить)
        Stream<String> stringStream1 = stringStream.map(it -> "T" + it);
        String result = stringStream1.collect(Collectors.joining(", "));

        System.out.println(result);

    }

}
