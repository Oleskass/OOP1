package seminars.seminar2.game;

public class WallObstacleAdapter implements Obstacle {

    // адаптер взаимодействует с одной стороны со стеной,
    // а с другой стороны должен быть препятствием
    private final Wall wall1;

    public WallObstacleAdapter(Wall wall1) {
        this.wall1 = wall1;
    }

    @Override
    public boolean pass(Participant participant1) {
        return wall1.pass(participant1);
    }

}