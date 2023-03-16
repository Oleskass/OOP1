package seminars.seminar6.l;

public class LiskovMain {

    public static void main(String[] args) {
        // F(T) => S extends T, F(S)
        //

        Rectangle r = new Rectangle(5, 10);
        System.out.println(r.volume());

        Square square = new Square(10);
//        square.setX(5);
//        square.setY(10);
        System.out.println(square.volume()); // 100
    }

//    private static void foo(T t) {
//        if (t instanceof S1) {
//            //
//        }
//    }

    static class Rectangle {
        private int x;
        private int y;

        public Rectangle(int x, int y) {
            this.x = x;
            this.y = y;
        }

        //        public void setX(int x) {
//            this.x = x;
//        }
//
//        public void setY(int y) {
//            this.y = y;
//        }

        public int volume() {
            return x * y;
        }
    }

    static class Square extends Rectangle {
        public Square(int x) {
            super(x, x);
        }
    }

}
