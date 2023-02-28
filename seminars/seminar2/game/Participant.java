package seminars.seminar2.game;

public interface Participant extends CanJump, CanRun, CanSwim {
    // здесь описали, что умеет делать участник - было int getJump(); и прочее стало
    // наследование от интерфейсов CanJump и тд

    String getName();
}
