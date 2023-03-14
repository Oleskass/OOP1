package homework.hw5_game2;

import java.util.Optional;

public class StringToDirectionExample {

    public static void main(String[] args) {
        Optional<Direction> direction = Direction.ofString("LEFT");
        System.out.println(direction);
    }

}
