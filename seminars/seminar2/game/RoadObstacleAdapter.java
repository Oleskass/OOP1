package seminars.seminar2.game;

public class RoadObstacleAdapter implements Obstacle {
    private final Road road1;

    public RoadObstacleAdapter(Road road1) {
        this.road1 = road1;
    }

    @Override
    public boolean pass(Participant participant1) {
        return road1.pass(participant1);
    }

}