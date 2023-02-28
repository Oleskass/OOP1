package seminars.seminar2.game;

public class Wall implements Obstacle {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean pass(Participant participant1) {
        return participant1.getJump() >= height;
    }

}
