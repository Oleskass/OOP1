package Ex003Math.Mathematics.Shapes;

import Ex003Math.Mathematics.Exceptions.UnacceptableValueException;

public class Circle extends Shape {
    
    public static Circle create(double radius, String name) throws UnacceptableValueException {
        // ???...
        if (radius < 0)
            throw new UnacceptableValueException("radius < 0");

        var instance = new Circle();
        instance.name = name;
        instance.radius = radius;
        return instance;
    }
// базовый функционал
    public double radius;
//конструктор приватный
    private Circle() {
    }
// возможность получения радиуса
    public double getRadius() {
        return radius;
    }
// перегрузка метода получения площади
    @Override
    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }
// возможно доделать, улучшить
    // @Override
    // public String toString() {
    // // ???...
    // return String.format("Name: %s radius: %s", name, radius);
    // }

}
