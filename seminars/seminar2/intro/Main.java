package seminars.seminar2.intro;

import java.time.LocalDate;
import java.time.LocalDateTime;

import seminars.seminar2.MyAbstr.DefaultStringDateConverter;
import seminars.seminar2.MyAbstr.IsoStringDateConverter;
import seminars.seminar2.MyInterf.DateConverter;
import seminars.seminar2.MyInterf.DateTimeConverter;
import seminars.seminar2.MyInterf.DefaultDateConverter;
// import seminars.seminar2.MyInterf.IsoDateConverter;

public class Main {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(new DefaultStringDateConverter(now).dateAsString());
        System.out.println(new IsoStringDateConverter(now).dateAsString());

        DateConverter dateConverter1 = new DefaultDateConverter();
        DateTimeConverter dateTimeConverter1 = new DefaultDateConverter();

        System.out.println(dateConverter1.convert(now));
        System.out.println(dateTimeConverter1.convert(now1));
    }

}
