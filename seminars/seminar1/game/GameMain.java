package seminars.seminar1.game;

public class GameMain {

    public static void main(String[] args) {
        // Карта с роботами.
        // Карта имеет nxm, где n и m - положительные целые числа.
        // Должна быть возможность создания робота на какой-то точке на карте.
        // Точка на карте описывается двумя целочисленными координатами.
        // Роботы могут перемещаться по карте вперед.
        // В одной точке не может находиться несколько роботов.

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

        /*
         * * * * *
         * * * * *
         * * * * *
         * * * * *
         * * * * *
         */

        RobotMap map1 = new RobotMap(5, 5); // создали карту

        RobotMap.Robot robot1 = map1.createRobot(new Point(2, 3));
        RobotMap.Robot robot2 = map1.createRobot(new Point(5, 5));
        // при создании робота указываем точку, где он находится, для чего лучше создать
        // отдельный класс Point
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