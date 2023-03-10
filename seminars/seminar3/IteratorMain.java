package seminars.seminar3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
// import java.util.concurrent.ThreadLocalRandom;
// import java.util.stream.IntStream;

public class IteratorMain {

    public static class IntStorage implements Iterable<Integer> {

        private final int[] data;

        public IntStorage(int[] data) {
            this.data = data;
        }

        // прописали implements Iterable<Integer> и затем нужно реализовать интерфейс
        // Iterable, который заключается в создании итератора
        @Override
        public Iterator<Integer> iterator() {
            return new IntStorageIterator(Arrays.copyOf(data, data.length));
        }

        // в отдельном классе реализуем методы hasNext и next
        private static class IntStorageIterator implements Iterator<Integer> {

            private final int[] data;
            private int cursor = 0;

            public IntStorageIterator(int[] data) {
                this.data = data;
            }

            @Override
            public boolean hasNext() {
                return cursor < data.length;
            }

            @Override
            public Integer next() {
                // int next = data[cursor];
                // cursor++;
                // return next;
                return data[cursor++];
            }

            @Override
            public void remove() {
                if (cursor == 0) {
                    throw new IllegalStateException();
                }

                data[cursor - 1] = 0;
            }
        }

    }

    public static void main(String[] args) {
        // iteratorDemo();
        // customIterator();

        // =======
        // List<Integer> randomIntegers = IntStream.generate(() ->
        // ThreadLocalRandom.current().nextInt(20)).limit(20)
        // .boxed().toList();

        // System.out.println(randomIntegers);

        // int sum = 0;
        // Iterator<Integer> randomIntegersIterator = randomIntegers.iterator();
        // while (randomIntegersIterator.hasNext()) {
        // Integer x = randomIntegersIterator.next();
        // sum += x;
        // }
        // // for (Integer integer : randomIntegers) {
        // // System.out.println(integer);
        // // }
        // System.out.println("Sum = " + sum);
        // ========

        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next % 2 != 0) {
                iterator.remove(); // эл-ты прям удалилилсь из коллекции
            }
        }
        // тот же код, но короче (лямбда-выражение)
        // removeIf принимает предикат, который удалит всё, что под этот предикат
        // попадёт
        // integers.removeIf(x -> x % 2 != 0);

        System.out.println(integers);
        iteratorDemo();
        customIterator();

    }

    private static void customIterator() {
        int[] arrays = { 1, 2, 3, 4, 5 };
        IntStorage storage = new IntStorage(arrays);

        storage.iterator().forEachRemaining(it -> System.out.println(it));
        storage.iterator().forEachRemaining(System.out::println);
        // for (int x : storage) {
        // System.out.println(x);
        // }
    }

    private static void iteratorDemo() {
        List<Integer> randomIntegers = List.of(1, 2, 3, 4, 5);
        // IntStream.generate(() -> ThreadLocalRandom.current().nextInt(20))
        // .limit(20)
        // .boxed()
        // .toList();

        // System.out.println(randomIntegers);

        int sum = 0;
        Iterator<Integer> randomIntegersIterator = randomIntegers.iterator();
        // [^ 1, 2, 3, 4, 5]

        while (randomIntegersIterator.hasNext()) {
            Integer x = randomIntegersIterator.next();
            sum += x;
        }

        System.out.println("Sum = " + sum);
    }

}
