package Ex003Math.Client;

import Ex003Math.Mathematics.Exceptions.UnacceptableValueException;
import Ex003Math.Mathematics.CalculateArea.CalculateArea;
import Ex003Math.Mathematics.Shapes.Canvas;
import Ex003Math.Mathematics.Shapes.Circle;
import Ex003Math.Mathematics.Shapes.Rectangle;
import Ex003Math.Mathematics.Shapes.Shape;

public class Program {
    /*
     * Задача 3
     * Напишите программу для поставки внешним клиентам, которая умеет вычислять
     * площадь круга по радиусу и прямоугольника по трем сторонам.
     * Дополнительно к работоспособности оценим:
     * - легкость добавления других фигур
     * - вычисление площади фигуры без знания типа фигуры
     * - обработку возникающих проблем при создании фигур
     * И подешевле!
     */
    /*
     * 1 Shapes - Shape
     * далее можем продумывать какую-то архитектуру в конкретных фигурах (square, triangle, etc.)
     * и иерархию наших фигур (Circle extends Shape)
     * В Circle есть статический метод create (с обработкой мсключений) 
     * 2 Mathematics - Exceptions
     * Собственные исключения (extends Exception) со своей иерархией (в Circle они используются)
     * 3 Shapes - Rectangle
     * есть 2 поля - ширина и высота, метод create, конструктор, вычисление площади (getArea), toString
     * 4 Shapes - Square, Triangle - добавить самим
     * 5 Shapes - Canvas
     * 6 CalculateArea - ICalculate
     * интерфейс, который будет содержать лишь один метод, принимающий фигуру
     * и дальше будет конкретный представитель CalculateArea, метод visit будет проходить по всем фигуркам, и calculate считать их площадь.
     * там RefInt - это класс внутри класса (необяз для этой программы, но для нас новое,)
     * 7 Core - стр-ра MVP
     * Infrastructure содержит в себе обёртку над генератором случ.чисел (необяз)
     * Model - позволяет взаимодействовать с нашими фигурками
     * там механизм добавления abuwhs (append)
     * IView
     * Presenter 
     * 9 ConsoleView - осталось описать конкретного представителя View 
     * 10 App - осталось собирает всё приложение в кучу: создаёт презентер, создаёт вью, модель, вконтрукторе всё это инициализируется, подставляются нужные, конкретные инстансы
     * *Паттерн Синглтон
     * start - делает менюшку, затем в бесокнечном цикле: нажмите 1 чтобы добавить фигуру, 2 -... и тд
     * 11 Program - точка входа
     * 
     */
    public static void main(String[] args) throws UnacceptableValueException {
        new App().start();

        // #region

        // Shape shape1 = Circle.create(1, "Circle_1");
        // Shape shape2 = Rectangle.create(2, 3, "Rectangle_2");
        // Shape shape3 = Circle.create(4, "Circle_3");
        // Shape shape4 = Rectangle.create(5, 6, "Rectangle_4");
        // Shape shape5 = Rectangle.create(7, 8, "Rectangle_5");
        // Shape shape6 = Circle.create(9, "Circle_6");

        // Canvas canvas = new Canvas("Canvas");

        // shape2.shapes.add(shape1);
        // shape4.shapes.add(shape2);
        // shape4.shapes.add(shape3);
        // shape6.shapes.add(shape4);
        // shape6.shapes.add(shape5);

        // canvas.shapes.add(shape6);

        // System.out.println(canvas);

        // #endregion
    }
}
