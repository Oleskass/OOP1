package seminars.seminar2.MyInterf;

import java.time.LocalDate;

public interface DateConverter {
    // абстрактный метод, который класс должен реализовать
    String convert(LocalDate date);
}
