package homework.hw2_competition;

public class SwimObstacleAdapter implements Obstacle {

    private final SwimmingPool swimmingPool1;

    public SwimObstacleAdapter(SwimmingPool swimmingPool1) {
        this.swimmingPool1 = swimmingPool1;
    }

    @Override
    public boolean pass(Participant participant1) {
        return swimmingPool1.pass(participant1);
    }

}