package lectures.lecture3.ex0;

public class Program {
    public static void main(String[] args) {
        // если так сделаем, то проблемка:
        // Foo foo = new Foo();

        // поэтому создаем экземпляр и прописываем так:
        Foo foo1 = new Foo() {
            @Override
            public void m1() {
                System.out.println("m1");
            }

            @Override
            public void m2() {
                System.out.println("m2");
            }
        };
        foo1.m1();
        // если нужен другой экземпляр с др.поведением:
        Foo foo2 = new Foo() {
            @Override
            public void m1() {
                System.out.println("---m1---");
            }

            @Override
            public void m2() {
                System.out.println("---m2---");
            }
        };
        foo2.m2();

    }
}