package homework.hw5_game2;

import java.util.Optional;

public enum Direction {
    TOP, RIGHT, BOTTOM, LEFT;

    public static Optional<Direction> ofString(String string) {
        Direction[] values = values();
        for (Direction value : values) {
            if (string.equals(value.name())) { // name возвращает н/р TOP как строку
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }
}
