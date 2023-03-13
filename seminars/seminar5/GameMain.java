package seminars.seminar5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

        final CommandManager manager = new CommandManager(map1);
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
            manager.acceptCommand(command);

        }
    }

    // часть кода с if выделим в отдельный компонент, который будет отвечать за
    // обработку команд: (перместили из main код с if-ами)
    // далее чтобы if не разрастался, на каждую команду (create, move, etc.) должен
    // быть отдельный внутренний обработчик (отвечает только за одну команду!)
    // а CommandMeneger будет управлять этими обработчиками.
    // в acceptCommand добавили отдельный массив для аргументов наших команд, теперь
    // наша команда всегда состоит из имени команды и массива аргументов, для этого
    // создадим отдельный интерфейс (CommandHandler).
    // создадим список комманд-хэндлеров в CommandManager - private final
    // List<CommandHandler> handlers (и в констр-р пока пустой добавляем) и
    // проходимся по каждому хэндлеру
    // создаём метод для создания первого хэндлера initHandlers
    // initCreateCommandHandle и др. можно вынести в отдельный файл, но мы не делаем
    // интерфейс CommandHandleк тоже можно вынести в отдельный файл
    // добавим initHandlers в ComandManager (1:07 - проходимся по всей программе)
    // (CommandManager управляет, CommandHandler обрабатывает, контроллер работает с консолью (main)) 1:18 помощь по дз

    private static class CommandManager {

        private final RobotMap map1;
        private final List<CommandHandler> handlers;

        public CommandManager(RobotMap map1) {
            this.map1 = map1;
            handlers = new ArrayList<>();
            initHandlers();
        }

        private void initHandlers() {
            initCreateCommandHandler();
            initListCommandHandler();
            initMoveCommandHandler();
        }

        private void initCreateCommandHandler() {
            handlers.add(new CommandHandler() {
                @Override
                // наименование команды
                public String name() {
                    return "create";
                }

                @Override
                // метод команды create (беру код из ранее созданного doCreate)
                public void handle(String[] args) {
                    int x = Integer.parseInt(args[0]);
                    int y = Integer.parseInt(args[1]);
                    RobotMap.Robot robot1 = map1.createRobot(new Point(x, y));
                    System.out.println("Робот" + robot1 + " успешно создан");

                }
            });
        }

        private void initListCommandHandler() {
            handlers.add(new CommandHandler() {
                @Override
                // наименование команды
                public String name() {
                    return "list";
                }

                @Override
                // метод команды list (беру код из ранее созданного doList)
                public void handle(String[] args) {
                    map1.acceptRobots(System.out::println);
                }
            });
        }

        private void initMoveCommandHandler() {
            handlers.add(new CommandHandler() {
                @Override
                // наименование команды
                public String name() {
                    return "move";
                }

                @Override
                // метод команды move (беру код из ранее созданного doMove)
                public void handle(String[] args) {
                    Long robotId = Long.parseLong(args[0]);
                    Optional<RobotMap.Robot> robot = map1.getById(robotId);

                    robot.ifPresentOrElse(RobotMap.Robot::move,
                            () -> System.out.println("Робот с id: " + robotId + " не найден"));
                }
            });
        }

        public void acceptCommand(String command) {
            String[] split = command.split(" ");
            String commandName = split[0];
            String[] commandArgs = Arrays.copyOfRange(split, 1, split.length);

            // сделаем флажок для ситуации "Команда не найдена"
            boolean found = false;
            for (CommandHandler handler : handlers) {
                if (commandName.equals(handler.name())) {
                    found = true;
                    try {
                        handler.handle(commandArgs);
                    } catch (Exception e) {
                        System.err.println(
                                "Во время обработки команды \"" + commandName + "\" произошла ошибка: " +
                                        e.getMessage());
                    }
                }
            }

            if (!found) {
                System.out.println("Команда не найдена");
            }

            // try {
            // if ("create".equals(commandName)) {
            // // создаём робота
            // doCreate(map1, commandArgs);

            // } else if ("list".equals(commandName)) {
            // // печатаем всех роботов
            // doList(map1);
            // } else if ("move".equals(commandName)) {
            // // ищем робота и передвигаем его
            // doMove(map1, commandArgs);
            // } else if ("exit".equals(commandName)) {
            // // завершаем программу
            // // break; - теперь не работает
            // System.exit(0);
            // } else {
            // // команда не найдена
            // System.out.println("Команда не найдена");
            // }
            // } catch (Exception e) {
            // System.err.println(
            // "Во время обработки команды \"" + commandName + "\" произошла ошибка: " +
            // e.getMessage());
            // }
        }
    }

    private interface CommandHandler {
        String name();

        void handle(String[] args);
    }

    // private static void doCreate(RobotMap map, String[] args) {
    // int x = Integer.parseInt(args[0]);
    // int y = Integer.parseInt(args[1]);
    // RobotMap.Robot robot1 = map.createRobot(new Point(x, y));
    // System.out.println("Робот" + robot1 + " успешно создан");
    // }

    // private static void doList(RobotMap map) {
    // // map1.acceptRobots(new Consumer<RobotMap.Robot>() {
    // // @Override
    // // public void accept(RobotMap.Robot robot) {
    // // System.out.println(robot);
    // // }
    // // });

    // // код выше можно свернуть до:
    // // map.acceptRobots(robot -> System.out.println(robot));

    // // код выше можно свернуть до:
    // map.acceptRobots(System.out::println);
    // }

    // public static void doMove(RobotMap map, String[] args) {
    // Long robotId = Long.parseLong(args[0]);
    // Optional<RobotMap.Robot> robot = map.getById(robotId);

    // // свернули нижний код до следующего:
    // robot.ifPresentOrElse(RobotMap.Robot::move, () -> System.out.println("Робот с
    // id: " + robotId + " не найден"));
    // } // если есть робот, то код до стрелки, если нет, то код после стрелки

    // // // развёрнутый вариант написания с Optional
    // // robot.ifPresentOrElse(new Consumer<RobotMap.Robot>() {
    // // // если есть робот это сработает
    // // @Override
    // // public void accept(RobotMap.Robot robot) {
    // // robot.move();
    // // }
    // // }, new Runnable() {
    // // // runnable это интерфейс
    // // // если нет робота, то этот код сработает
    // // @Override
    // // public void run() {
    // // System.out.println("Робот с id: " + robotId + " не найден");
    // // }
    // // });

    // // // код с null, до Optional
    // // if (robot != null){
    // // robot.move();
    // // } else {
    // // System.out.println("Робот с id: " + robotId + " не найден");
    // // }
}
