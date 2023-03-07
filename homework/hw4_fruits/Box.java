package homework.hw4_fruits;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    // Нужно реализовать хранение фруктов в коробке Box
    private final List<T> fruits = new ArrayList<>();

    public void add(T fruit) {
        fruits.add(fruit);
        // throw new UnsupportedOperationException();
    }

    public void remove(T fruit) {
        fruits.remove(fruit);
    }

    public int count() {
        return fruits.size();
    }

    public T get(Integer index) {
        return fruits.get(index);
    }

    double sum = 0;

    public double getWeight() {
        for (T fruit : fruits) {
            sum += fruit.getWeight();
        }
        return sum;
    }

    public void moveTo(Box<? super T> anotherBox) {
        int len = this.count();
        for (int i = 0; i < len; i++) {
            anotherBox.add(this.get(i));
        }
        for (int i = 0; i < len; i++) {
            this.remove(get(i));
            // }
            // for (T fruit : fruits) {
            // anotherBox.add(fruit);
            // this.remove(fruit);
            // }
        }

    }
}
