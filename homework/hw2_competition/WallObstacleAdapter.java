package homework.hw2_competition;

public class WallObstacleAdapter implements Obstacle {

    private final Wall wall1;

    public WallObstacleAdapter(Wall wall1) {
        this.wall1 = wall1;
    }

    @Override
    public boolean pass(Participant participant1) {
        return wall1.pass(participant1);
    }

}