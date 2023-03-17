package homework.hw6_game3;

public interface RobotInterface {
   
    public void changeDirection(Direction direction);
    public void move();
    public void deleteRobot(Long robotId);
    public Long getID();
    public Point getPoint();
}
