package homework.hw3_notebook;

import java.security.spec.RSAMultiPrimePrivateCrtKeySpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Notebook {

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

    public static void main(String[] args) {

        List<Integer> givenRam = new ArrayList<>(List.of(2, 3, 4, 6, 8, 12, 16, 20, 24, 32, 64));

        List<Integer> ramList = new ArrayList<>();
        List<Double> priceList = new ArrayList<>();

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            ramList.add(givenRam.get(rand.nextInt(givenRam.size())));
        }

        System.out.println(ramList);
    }
}
