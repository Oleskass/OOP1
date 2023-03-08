package ex1;

public class Presenter {
    // класс знает, что он будет работать с какой-то моделью и с каким-то конкретным
    // представлением (абстрактно)
    View view;
    Model model;

    // в качестве конструктора мы передаём эти компоненты (уже конкретные)
    public Presenter(Model m, View v) {
        model = m;
        view = v;
    }

    // нажимая на эту кнопку польз-ль запускает весь процесс
    public void buttonClick() {
        int a = view.getValue("a: ");
        int b = view.getValue("b: ");
        // презентер связывает данные, которые пришли из View с данными, которые нужно
        // положить в нашу модель
        model.setX(a);
        model.setY(b);
        int res = model.result();
        // данные из модели переходят во View
        view.print(res, "Sum: ");

    }
}
