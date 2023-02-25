package homework.hw1_game;

public class GameMain {

    public static void main(String[] args) {

        // HOMEWORK
        // 0. Разобраться с проектом. Подготовить вопросы к следующему семинару, если
        // возникнут.
        // 1. Добавить валидацию параметров при создании карты
        // 2. Реализовать возможность задать ограничение по количеству создаваемых
        // на карте роботов (в конструкторе карты)
        // При этом если параметр не указан, то используем значение по-умолчанию: 5
        // 3*. Реализовать возможность вызова метода move с параметром - количество
        // шагов вперед
        // Подсказка: можно несколько раз вызвать метод #move

        RobotMap map1 = new RobotMap(5, 5);

        RobotMap.Robot robot1 = map1.createRobot(new Point(2, 3));
        RobotMap.Robot robot2 = map1.createRobot(new Point(5, 5));

        System.out.println(robot1); // [2, 3], [TOP]
        System.out.println(robot2); // [2, 3], [TOP]
        robot1.move();
        System.out.println(robot1); // [1, 3], [TOP]
        robot1.changeDirection(Direction.BOTTOM);
        robot1.move();
        robot1.move();
        robot1.changeDirection(Direction.LEFT);
        robot1.move();
        System.out.println(robot1); // [3, 2], [LEFT]
    }

}