package lectures.lecture3.ex2.ExBeverage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//абстрактный класс Напиток имплементирует итератор
public abstract class Beverage implements Iterator<Ingredient> {
    List<Ingredient> components;
    int index;

    public Beverage() {
        components = new ArrayList<>();
        index = 0;
    }

    public void addComponent(Ingredient component) {
        components.add(component);
    }

    // реализация методов итератора
    @Override
    public boolean hasNext() {
        return index < components.size();
    }

    @Override
    public Ingredient next() {
        return components.get(index++);
    }
}
