package homework.hw5_game2;

import java.util.Objects;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // точки можно будет посомтреть через эти геттеры
    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override // нужно сравнить по полям и затем переопрделеить хеш-код
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false; // если классы не равны, возвращает false
        Point point = (Point) o;
        return x == point.x && y == point.y; // сравниваем по координатам
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    // if o1.equals(o2) => o1.hashCode() == o2.hashCode()
    // if o1.hashCode() != o2.hashCode() => !o1.equals(o2)
}
