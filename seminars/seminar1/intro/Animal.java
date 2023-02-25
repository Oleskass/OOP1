package seminars.seminar1.intro;

public class Animal {
    private String name;
    private int age;

    // конструктор, который принимает и имя, и возраст
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // конструктор, который принимает только имя
    public Animal(String name) {
        this.name = name;
        this.age = 1;
    }

    @Override
    public String toString() {
        return name + ", " + age + " year(s)";
    }
}
