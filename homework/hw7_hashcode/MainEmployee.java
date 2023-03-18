package homework.hw7_hashcode;

public class MainEmployee {

    public static void main(String[] args) {
        Employee worker1 = new Employee("Ivan", "Petrov", "dep1", 80000);
        Employee worker2 = new Employee("Ivan", "Petrov", "dep2", 60000);
        Employee worker3 = new Employee("Nikolay", "Petrov", "dep1", 80000);
        Employee worker4 = new Employee("Ivan", "Somov", "dep1", 60000);

        System.out.println(worker1.equals(worker2)); // true
        System.out.println(worker1.equals(worker3));
        System.out.println(worker1.equals(worker4));
        System.out.println(worker1.equals(worker1)); // true
        System.out.println(worker2.equals(worker1)); // true
        System.out.println(worker2.equals(worker3));
        System.out.println(worker2.equals(worker4));
        System.out.println(worker3.equals(worker4));
        System.out.println(worker4.equals(worker2));
    }
}
