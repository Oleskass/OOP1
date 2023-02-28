package seminars.seminar2.MyInterf;

import java.time.LocalDateTime;

public interface DateTimeConverter {
    // абстрактный метод, который класс должен реализовать
    String convert(LocalDateTime date);
}
