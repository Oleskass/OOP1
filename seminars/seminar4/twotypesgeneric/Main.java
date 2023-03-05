package seminars.seminar4.twotypesgeneric;

public class Main {

    public static void main(String[] args) {
//        Box<FooClass> fooClassBox = new Box<FooClass>();
//        Box<BarClass> barClassBox = new Box<BarClass>();
        // Box<FooBarClass> fooBarClassBox = new Box<>();
    }

    static class BarClass implements BarInterface {
        @Override
        public void bar() {

        }
    }

    static class FooClass implements FooInterface {
        @Override
        public void foo() {

        }
    }

    static class FooBarClass implements FooInterface, BarInterface {
        @Override
        public void bar() {

        }

        @Override
        public void foo() {

        }
    }

}
