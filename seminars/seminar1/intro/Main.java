package seminars.seminar1.intro;

public class Main {
    public static void main(String[] args) {
        // User user1 = new User();
        // user1.rename(" Olesya");
        // System.out.println(user1);

        // инкапсуляция
        Cat cat1 = new Cat("cat's name");
        Dog dog1 = new Dog("dog's name");
        System.out.println(cat1);
        System.out.println(dog1);

        Animal animal1 = new Animal("animal's name");
        Animal animal2 = new Animal("animal's 2 name", 4);
        System.out.println(animal1);
        System.out.println(animal2);

    }
}
