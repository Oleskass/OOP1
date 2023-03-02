package lectures.lecture2.ex4;

public class Druid extends BaseHero {

    int mp;

    public Druid(String name, int hp, int mp) {
        super(name, hp);
        System.out.println("Вызван Druid(String name, int hp)");
        this.mp = mp;
    }

    public Druid() {
        this("", 0, 0);
        // super("", 0);
        System.out.println("Вызван Druid()");
    }
}