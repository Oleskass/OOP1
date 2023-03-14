package homework.hw5_game2;

public enum Direction {
    TOP, RIGHT, BOTTOM, LEFT;

    public static Direction ofString(String string) {
        Direction[] values = values();
        for (Direction value : values) {
            if (string.equals(value.name())) { // name возвращает н/р TOP как строку
                return value;
            }
        }
        return null;
    }
}
