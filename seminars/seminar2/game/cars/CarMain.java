package seminars.seminar2.game.cars;

import seminars.seminar2.game.CanRun;
import seminars.seminar2.game.Road;

public class CarMain {
    public static void main(String[] args) {
        Road road1 = new Road(50);
        Car car1 = new Car();

        road1.pass(car1);
    }

    public static class Car implements CanRun {
        // кол-во бензина
        public int getDistance() {
            // высчитываем расстояние на основе кол-ва бензина, сокрости и тд
            return 20;
        }

        @Override
        public int getRun() {
            return getDistance();
        }

    }
}
