package seminars.seminar1.game;

import java.util.ArrayList;
import java.util.List;

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
        /*
         * чтобы робот мог премещаться, создаём метод move, для этого надо понимать,
         * куда робот смотрит в данный момент. Для этого создаём класс Direction.
         * И прописываем его в свойства классу Robot. Помимо этого робот должен хранить
         * внутри себя координаты. В коснтрукторе передаём точку, тк не можем создать
         * робота без координат. Переопределим toString в Point, а здесь переопределим
         * toString обратившись к Point. Прописали метод move. Также должны создать
         * метод для изменения направления, создаём changeDirection. Так как сейчас
         * можно создать точку за границами карты, нужно сделать валидацию в классе
         * RobotMap. И этот метод мы будет вызывать перед созданием нового робота
         * в методе createRobot, и после присваивания новой точки в методе move. Добавим
         * лоигрование в метод move для отслеживания exception.
         * Чтобы в одной точке не находилось несколько роботов, для начала нам
         * необходимо сохранять роботов, создадим для этого list в классе RobotMap,
         * и добавим в конструктор и в метод createRobot. А также перед тем как сделать
         * шаг вперёд (в методе move) и при создании робота (в методе createRobot),
         * нужно проверить, не занята ли точка, иначе вывести exception. Для этого
         * добавляем ещё один метод в класс RobotMap - validatePointIsFree. Так как у
         * нас
         * в двух местах подряд выполняются два метода: validatePointIsCorrect и
         * validatePointIsFree объединим их в один метод validatePoint.
         */
        public static final Direction DEFAULT_DIRECTION = Direction.TOP; // константа для направления по умолчанию

        private Direction direction;
        private Point point;

        public Robot(Point point) {

            this.direction = DEFAULT_DIRECTION; // направление по умолчанию
            this.point = point;
        }

        public void changeDirection(Direction direction) {
            this.direction = direction;
        }

        public void move() {
            /*
             * Меняем координату, тк робот ходит только вперёд, важно понимать,
             * в каком направлении он сейчас смотрит
             */

            // // один вариант написания:
            // final Point newPoint;
            // switch (direсtion) {
            // case TOP -> newPoint = new Point(point.x() - 1, point.y());
            // case RIGHT -> newPoint = new Point(point.x(), point.y() + 1);
            // case BOTTOM -> newPoint = new Point(point.x() + 1, point.y());
            // case LEFT -> newPoint = new Point(point.x(), point.y() - 1);
            // }

            // this.point = newPoint;

            // второй вариант покороче, стало можно так делать с новой версией Java:
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
            return point.toString() + ", [" + direction + "]";
        }
    }

}
