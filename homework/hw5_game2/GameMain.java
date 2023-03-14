package homework.hw5_game2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Consumer;

public class GameMain {

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в игру!");

        System.out.println("Введите размер карты:");
        int n = iScanner.nextInt();
        int m = iScanner.nextInt();
        iScanner.nextLine();
        final RobotMap map1 = new RobotMap(n, m);
        System.out.println("Карта успешно создана");

        final CommandManager manager = new CommandManager(map1);
        while (true) {
            System.out.println(
                    """
                                * * *
                            Доступные действия:
                            1. Для создания робота введите create x y, где x и y - координаты для нового робота
                            2. Для вывода списка всех созданных роботов, введите list
                            3. Для перемещения робота введите move id, где id - идентификатор робота
                            4. Для изменения направления введите changedir id DIRECTION, где id - идентификатор робота, DIRECTION - одно из значений {TOP, RIGHT, BOTTOM, LEFT}
                            5. Для удаления робота введите delete id, где id - идентификатор робота
                            6. Для выхода напишите exit
                            * * *
                                """);

            String command = iScanner.nextLine();
            manager.acceptCommand(command);
        }
    }

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
            initChangeDirCommandHandler();
            initDeleteCommandHandler();
            initExitCommandHandler();
        }

        private void initCreateCommandHandler() {
            handlers.add(new CommandHandler() {
                @Override
                public String name() {
                    return "create";
                }

                @Override
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
                public String name() {
                    return "list";
                }

                @Override
                public void handle(String[] args) {
                    map1.acceptRobots(System.out::println);
                }
            });
        }

        private void initMoveCommandHandler() {
            handlers.add(new CommandHandler() {
                @Override
                public String name() {
                    return "move";
                }

                @Override
                public void handle(String[] args) {
                    Long robotId = Long.parseLong(args[0]);
                    Optional<RobotMap.Robot> robot = map1.getById(robotId);

                    robot.ifPresentOrElse(RobotMap.Robot::move,
                            () -> System.out.println("Робот с id: " + robotId + " не найден"));
                }
            });
        }

        private void initChangeDirCommandHandler() {
            handlers.add(new CommandHandler() {
                @Override
                public String name() {
                    return "changedir";
                }

                @Override
                public void handle(String[] args) {
                    Long robotId = Long.parseLong(args[0]);
                    Optional<RobotMap.Robot> robot = map1.getById(robotId);
                    Direction direction = Direction.ofString(args[1]);

                    robot.ifPresentOrElse(new Consumer<RobotMap.Robot>() {
                        @Override
                        public void accept(RobotMap.Robot robot) {
                            robot.changeDirection(direction);
                            System.out.println("Робот с id: " + robotId + " изменил своё направление");
                        }
                    }, new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Робот с id: " + robotId + " не найден");
                        }
                    });
                }
            });
        }

        private void initDeleteCommandHandler() {
            handlers.add(new CommandHandler() {
                @Override
                public String name() {
                    return "delete";
                }

                @Override
                public void handle(String[] args) {
                    Long robotId = Long.parseLong(args[0]);
                    Optional<RobotMap.Robot> robot = map1.getById(robotId);

                    robot.ifPresentOrElse(new Consumer<RobotMap.Robot>() {
                        @Override
                        public void accept(RobotMap.Robot robot) {
                            robot.deleteRobot(robotId);
                            System.out.println("Робот с id: " + robotId + " удалён");
                        }
                    }, new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Робот с id: " + robotId + " не найден");
                        }
                    });
                }
            });
        }

        private void initExitCommandHandler() {
            handlers.add(new CommandHandler() {
                @Override
                public String name() {
                    return "exit";
                }

                @Override
                public void handle(String[] args) {
                    System.out.println("Всего доброго!");
                    System.exit(0);
                }
            });
        }

        public void acceptCommand(String command) {
            String[] split = command.split(" ");
            String commandName = split[0];
            String[] commandArgs = Arrays.copyOfRange(split, 1, split.length);

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
        }
    }

    private interface CommandHandler {
        String name();
        void handle(String[] args);
    }
}
