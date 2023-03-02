package lectures.lecture2.ex4;

public abstract class BaseHero {

    // конструктор с двумя эл-тами
    public BaseHero(String name, int hp) {
        System.out.println("Вызван BaseHero(String name, int hp)");
    }

    // конструктор по умолчанию
    public BaseHero() {
        this("", 0);
        System.out.println("Вызван BaseHero()");
    }
}