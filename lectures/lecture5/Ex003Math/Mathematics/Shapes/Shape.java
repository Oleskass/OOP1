package Ex003Math.Mathematics.Shapes;

import java.util.ArrayList;
import java.util.List;

// асбтрактный класс Shape
public abstract class Shape {
    // указываем наличие площади и имени нашей фигуры
    protected double area;
    protected String name;
// возможность получения площади
    public double getArea() {
        return area;
    }
// изменение площади, должен быть скрыт от польз-ля
    protected void setArea(double value) {
        area = value;
    }
    public void setName(String value) {
        name = value;
    }
    public String getName() {
        return name;
    }
// идея в том,что фигура может содержать в себе другие фигуры (перечень таких же фигур)
    public List<Shape> shapes = new ArrayList<Shape>();
// механика печати
    private void Print(StringBuilder sb, String indent) {
        sb.append(String.format("%s %s %s\n", indent, name, getArea()));

        for (Shape shape : shapes)
            shape.Print(sb, indent + "  ");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Print(sb, "");
        return sb.toString();
    }
}
