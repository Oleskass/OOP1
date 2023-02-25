package homework.hw1_game;

public class GameMain {

    public static void main(String[] args) {

        // HOMEWORK
        // 0. Разобраться с проектом. Подготовить вопросы к следующему семинару, если
        // возникнут. V
        // 1. Добавить валидацию параметров при создании карты V
        // 2. Реализовать возможность задать ограничение по количеству создаваемых
        // на карте роботов (в конструкторе карты) V
        // При этом если параметр не указан, то используем значение по-умолчанию: 5 V
        // 3*. Реализовать возможность вызова метода move с параметром - количество
        // шагов вперед V
        // Подсказка: можно несколько раз вызвать метод #move

        RobotMap map1 = new RobotMap(5, 5, 4);

        RobotMap.Robot robot1 = map1.createRobot(new Point(5, 3));
        RobotMap.Robot robot2 = map1.createRobot(new Point(5, 5));
        RobotMap.Robot robot3 = map1.createRobot(new Point(4, 5));
        RobotMap.Robot robot4 = map1.createRobot(new Point(4, 1));
        // RobotMap.Robot robot5 = map1.createRobot(new Point(1, 1));
        // RobotMap.Robot robot6 = map1.createRobot(new Point(1, 4));

        System.out.println(robot1);
        System.out.println(robot2);
        robot1.move(3);
        System.out.println(robot1);
        robot1.changeDirection(Direction.BOTTOM);
        robot1.move();
        robot1.changeDirection(Direction.LEFT);
        robot1.move();
        System.out.println(robot1);
        System.out.println(robot3);
        System.out.println(robot4);
    }

}