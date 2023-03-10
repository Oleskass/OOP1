package seminars.seminar2.game;

public class Wall {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    // CanJump - это интерфейс, по которому можно взаимодействовать с Wall
    public boolean pass(CanJump canJump) {
        return canJump.getJump() >= height;
    }

}
