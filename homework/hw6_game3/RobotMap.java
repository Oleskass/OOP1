package homework.hw6_game3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class RobotMap {
    private final int n;
    private final int m;

    private final List<RobotInterface> robots;


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

    public void acceptRobots(Consumer<RobotInterface> robotAcceptor) {
        for (RobotInterface robot : robots) {
            robotAcceptor.accept(robot);
        }
    }

    public Optional<RobotInterface> getById(Long id) {
        for (RobotInterface robot : robots) {
            if (id.equals(robot.getID())) {
                return Optional.of(robot);
            }
        }
        return Optional.empty();
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
        for (RobotInterface robot : robots) {
            if (robot.getPoint().equals(point)) {
                throw new IllegalStateException("Точка " + point + " занята.");
            }
        }
    }

    public class Robot implements RobotInterface {
        public static final Direction DEFAULT_DIRECTION = Direction.TOP;

        private static Long idCounter = 1L;
        private final Long id;
        private Direction direction;
        private Point point;
        

        public Robot(Point point) {
            this.id = idCounter++;
            this.direction = DEFAULT_DIRECTION; // направление по умолчанию
            this.point = point;
        }

        @Override
        public void changeDirection(Direction direction) {
            this.direction = direction;
        }
        @Override
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
        public void deleteRobot(Long id) {
            for (RobotInterface robot : robots) {
                if (robot.getID().equals(this.id)) {
                    robots.remove(robot);
                }
            }
        }

        @Override
        public String toString() {
            return "[" + id + "]" + point.toString() + " [" + direction + "]";
        }

        @Override
        public Long getID() {
            return id;
        }

        @Override
        public Point getPoint() {
            return point;
        }

    }

}
