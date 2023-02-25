package seminars.seminar2;

import java.time.LocalDate;

import seminars.seminar2.MyAbstr.DefaultStringDateConverter;
import seminars.seminar2.MyAbstr.IsoStringDateConverter;
import seminars.seminar2.MyInterf.DefaultDateConverter;
import seminars.seminar2.MyInterf.IsoDateConverter;

public class Main {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(new DefaultStringDateConverter(now).dateAsString());
        System.out.println(new IsoStringDateConverter(now).dateAsString());

        System.out.println(new DefaultDateConverter().convert(now));
        System.out.println(new IsoDateConverter().convert(now));
    }

}
