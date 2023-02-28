package seminars.seminar2.game;

public class CompetitionGameMain {
    public static void main(String[] args) {
        // Реализуем соревнования
        // Должны быть участники и препятствия
        // У участника есть параметры: возможности бега (длина), прыжка (высота),
        // плавание (длина)
        // 3 типа препятствия: беговая дорожка, стена и бассейн
        // 3 типа участников: обычный, кот, читер
        // Обычный участник умеет все в зависимости от параметров
        // Кот не умеет плавать
        // Читер всегда преодолевает препятствия, какими бы они не были
        // =========
        // CompetitionGameMain [Participant, Obstacle]
        // WallAdapter, RoadAdapter, ...

        // Wall(CanJump), Road(CanRun) ...]

        // AnotherSubSystem
        // WallCardAdapter(Wall) <-> Car
        // [WallAdapter(xxxx

        // Mouse
        // MouseBluetoothAdapter

        // Computer [Bluetooth, USB]
        // =========

        // в main создаём массив препятствий и участников
        Obstacle[] obstacles1 = createObstacles();
        Participant[] participants1 = createParticipants();
        for (Participant participant : participants1) {
            for (Obstacle obstacle : obstacles1) {
                // или participant.overcome(obstacle) - а здесь надо было бы знать, как участник
                // преодолевает препятствие
                // или obstacle.pass(participant) - лучше это, препятствие будет принимать
                // участника
                boolean result = obstacle.pass(participant);
                if (result) {
                    System.out.println("Участник #" + participant.getName() + " преодолел препятствие");
                } else {
                    System.out.println("Участник #" + participant.getName() + " НЕ преодолел препятствие");
                }
            }

        }
    }

    // создадим массив препятствий и массив участников
    private static Obstacle[] createObstacles() {
        return new Obstacle[] {
                new RoadObstacleAdapter(new Road(100)),
                new RoadObstacleAdapter(new Road(45)),
                new WallObstacleAdapter(new Wall(40)),
                new SwimmingPool(20),
        };
    }

    private static Participant[] createParticipants() {
        return new Participant[] {
                new StandardParticipant("Igor", 50, 30, 20),
                new Cat("Murzik", 60, 25),
                new Cheater("Cheater")
        };

    }
}
