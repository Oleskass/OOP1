package seminars.seminar5;

import java.util.Scanner;
// import java.util.function.Consumer;

// import seminars.seminar5.RobotMap.Robot;

public class GameMain {

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);

        // TODO: приветствие

        System.out.println("Введите размер карты:");
        int n = iScanner.nextInt();
        int m = iScanner.nextInt();
        iScanner.nextLine();
        // создаём карту
        final RobotMap map1 = new RobotMap(n, m);
        System.out.println("Карта успешно создана");

        while (true) {
            System.out.println(
                    """
                            Доступные действия:
                            1. Для создания робота введите create x y, где x и y - координаты для нового робота
                            2. Для вывода списка всех созданных роботов, введите list
                            3. Для перемещения робота введите move id, где id - идентификатор робота
                            4. Для изменения направления введите changedir id DIRECTION, где id - идентификатор робота, DIRECTION - одно из значений {TOP, RIGHT, BOTTOM, LEFT}
                            5. Для удаления робота введите delete id, где id - идентификатор робота
                            6. Для выхода напишите exit
                            ... список будет пополняться
                                """);

            String command = iScanner.nextLine();
            String[] commandArgs = command.split(" ");
            String commandName = commandArgs[0];

            if ("create".equals(commandName)) {
                // создаём робота
                doCreate(map1, commandArgs);

            } else if ("list".equals(commandName)) {
                // печатаем всех роботов
                doList(map1);
            } else if ("move".equals(commandName)) {
                // ищем робота и передвигаем его
                doMove(map1, commandArgs);
            } else if ("exit".equals(commandName)) {
                // завершаем программу
                break;
            } else {
                // команда не найдена
            }
        }
    }

    private static void doCreate(RobotMap map, String[] args) {
        int x = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        RobotMap.Robot robot1 = map.createRobot(new Point(x, y));
        System.out.println("Робот" + robot1 + " успешно создан");
    }

    private static void doList(RobotMap map) {
        // map1.acceptRobots(new Consumer<RobotMap.Robot>() {
        // @Override
        // public void accept(RobotMap.Robot robot) {
        // System.out.println(robot);
        // }
        // });

        // код выше можно свернуть до:
        // map.acceptRobots(robot -> System.out.println(robot));

        // код выше можно свернуть до:
        map.acceptRobots(System.out::println);
    }

    public static void doMove(RobotMap map, String[] args) {
        Long robotId = Long.parseLong(args[1]);
        RobotMap.Robot robot = map.getById(robotId);
        if (robot != null){
            robot.move();
        } else {
            System.out.println("Робот с id: " + robotId + " не найден");
        }
    }
}