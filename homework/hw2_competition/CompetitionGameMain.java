package homework.hw2_competition;

public class CompetitionGameMain {
    public static void main(String[] args) {
        // Homework!!!
        // 0. Ознакомиться с кодом урока 2, подготовить вопросы к следующему уроку! V
        // 1. Дописать адаптеры для бассейна V
        // 2. *Придумать собственный тип препятствий и прикрутить его в проект по
        // аналогии/ V

        // 3. *Есть интерфейс RoundHole - описание круглое отверстия (имеет радиус)
        // double getRadius()
        // Есть интерфейс RoundPeg - описание круглого колышка (тоже есть радиус)
        // Есть класс RoundHoleMachine, у которой метод, принмает RoundPeg, возвращает
        // RoundHole
        // Есть интерфейс SquarePeg - описание квадратного колышка (имеет длину стороны
        // кварата)
        // Реализовать адаптер для SquarePeg в RoundHoleMachine

        Obstacle[] obstacles1 = createObstacles();
        Participant[] participants1 = createParticipants();
        for (Participant participant : participants1) {
            for (Obstacle obstacle : obstacles1) {

                boolean result = obstacle.pass(participant);
                if (result) {
                    System.out.println(
                            "Участник #" + participant.getName() + " преодолел препятствие");
                } else {
                    System.out.println("Участник #" + participant.getName() + " НЕ преодолел препятствие");
                }
            }

        }
    }

    private static Obstacle[] createObstacles() {
        return new Obstacle[] {
                new RoadObstacleAdapter(new Road(100)),
                new RoadObstacleAdapter(new Road(45)),
                new WallObstacleAdapter(new Wall(40)),
                new SwimObstacleAdapter(new SwimmingPool(20)),
                new HitTargetObstacleAdapter(new Target(8)),
        };
    }

    private static Participant[] createParticipants() {
        return new Participant[] {
                new StandardParticipant("Igor", 50, 30, 20, 9),
                new Cat("Murzik", 60, 50),
                new Cheater("Cheater"),
                new StandardParticipant("Tolik", 50, 30, 20, 7),
        };

    }
}
