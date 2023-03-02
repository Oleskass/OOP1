package lectures.lecture2.aboutStatic;

public class Program {
    static void A() {
        System.out.println("A()");
    }

    public static void main(String[] args) {
        Foo f1 = new Foo();
        f1.value = 123;
        // System.out.println(f1.value);
        f1.printCount();

        Foo.count = 12345;

        Foo f2 = new Foo();
        f2.value = 245;
        // System.out.println(f2.value);
        f1.printCount();

        Foo f3 = new Foo();
        f3.value = 788;
        // System.out.println(f3.value);
        f1.printCount();

    }

}
