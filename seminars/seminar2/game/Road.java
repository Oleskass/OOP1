package seminars.seminar2.game;

public class Road implements Obstacle {
    private final int distance;

    public Road(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean pass(Participant participant1) {
        return participant1.getRun() >= distance;
    }

}