package homework.hw2_competition;

public class HitTargetObstacleAdapter implements Obstacle {

    private final Target target1;

    public HitTargetObstacleAdapter(Target target1) {
        this.target1 = target1;
    }

    @Override
    public boolean pass(Participant participant1) {
        return target1.pass(participant1);
    }

}