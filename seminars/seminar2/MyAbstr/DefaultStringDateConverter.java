package seminars.seminar2.MyAbstr;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DefaultStringDateConverter extends StringDateConverter {

    public DefaultStringDateConverter(LocalDate date) {
        super(date);
    }

    @Override
    public String dateAsString() {
        // dd.mm.yyyy
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    }

}
