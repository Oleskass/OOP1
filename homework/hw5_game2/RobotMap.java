package homework.hw5_game2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class RobotMap {
    private final int n;
    private final int m;

    private final List<Robot> robots; // final - внутреннее состояние списка может
    // меняться, а ссылка на переменную роботов не может меняться

    public RobotMap(int n, int m) {
        this.n = n;
        this.m = m;
        this.robots = new ArrayList<>();
    }

    /*
     * Все возможности робота будут описаны внутри класса Robot.
     * Так как робот не имеет смысла без карты, создадим внутренний класс - класс
     * внутри другого класса. Также создадим метод для создания робота
     */

    public Robot createRobot(Point startPoint) {
        validatePoint(startPoint);
        Robot newRobot = new Robot(startPoint);
        robots.add(newRobot);
        return newRobot;
    }

    public void acceptRobots(Consumer<Robot> robotAcceptor){
        for (Robot robot : robots) {
            robotAcceptor.accept(robot);
        }
    }

    public Optional<Robot> getById(Long id) {
        for (Robot robot : robots) {
            if (id.equals(robot.id)){
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
        // нужно пройтись по всем роботам на этой карте и сравнить их положение
        // метод equals необходимо переопределить (в классе Point)
        for (Robot robot : robots) {
            if (robot.point.equals(point)) {
                throw new IllegalStateException("Точка " + point + " занята.");
            }

        }

    }

    public class Robot {
        
        public static final Direction DEFAULT_DIRECTION = Direction.TOP; // константа для направления по умолчанию

        // id робота добавили на сем5 (также в конструктор и в метод toString)
        // static значит, что переменная общая на все объекты, которые создаются
        private static Long idCounter = 1L;
        private final Long id;
        private Direction direction;
        private Point point;

        public Robot(Point point) {
            this.id = idCounter++;
            this.direction = DEFAULT_DIRECTION; // направление по умолчанию
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
            this.point = newPoint; // если точка валидная, то обновим её новым значением

        }

        @Override
        public String toString() {
            return "[" + id + "]" + point.toString() + " [" + direction + "]";
        }
    }

}
