package homework.hw1_game;

import java.util.ArrayList;
import java.util.List;

public class RobotMap {
    private final int n;
    private final int m;

    private final List<Robot> robots;

    public RobotMap(int n, int m) {
        this.n = n;
        this.m = m;
        this.robots = new ArrayList<>();
    }

    public Robot createRobot(Point startPoint) {
        validatePoint(startPoint);
        Robot newRobot = new Robot(startPoint);
        robots.add(newRobot);
        return newRobot;

    }

    private void validatePoint(Point point) {
        validatePointIsCorrect(point);
        validatePointIsFree(point);
    }

    private void validatePointIsCorrect(Point point) {
        if (point.x() < 0 || point.x() > n || point.y() < 0 || point.y() > m) {
            throw new IllegalStateException("Некорректное значение точки");
        }

    }

    private void validatePointIsFree(Point point) {
        for (Robot robot : robots) {
            if (robot.point.equals(point)) {
                throw new IllegalStateException("Точка " + point + " занята.");
            }

        }

    }

    public class Robot {

        private Direction direction;
        private Point point;

        public Robot(Point point) {
            this.direction = Direction.TOP;
            this.point = point;
        }

        public void changeDirection(Direction direction) {
            this.direction = direction;
        }

        public void move() {
            Point newPoint = switch (direction) {
                case TOP -> new Point(point.x() - 1, point.y());
                case RIGHT -> new Point(point.x(), point.y() + 1);
                case BOTTOM -> new Point(point.x() + 1, point.y());
                case LEFT -> new Point(point.x(), point.y() - 1);
            };
            validatePoint(newPoint);

            System.out.println("Робот переместился с " + point + " на " + newPoint);
            this.point = newPoint;

        }

        @Override
        public String toString() {
            return point.toString() + ", [" + direction + "]";
        }
    }

}
