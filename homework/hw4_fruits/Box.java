package homework.hw4_fruits;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Box<T extends Fruit> implements Iterable<T> {

    // Нужно реализовать хранение фруктов в коробке Box
    private final List<T> fruits = new ArrayList<>();

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public double getWeight() {
        double sum = 0;
        for (T fruit : fruits) {
            sum += fruit.getWeight();
        }
        return sum;
    }

    public void moveTo(Box<? super T> anotherBox) {
        for (int i = 0; i < fruits.size(); i++) {
            anotherBox.add(fruits.get(i));
        }
        fruits.clear();
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iter = new Iterator<T>() {
            int i = 0;

            public boolean hasNext() {
                return i < fruits.size();
            }

            public T next() {
                return fruits.get(i);
            }
        };
        return iter;
    }

}
