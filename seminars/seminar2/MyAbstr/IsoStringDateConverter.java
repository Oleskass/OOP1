package seminars.seminar2.MyAbstr;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IsoStringDateConverter extends StringDateConverter {

    public IsoStringDateConverter(LocalDate date) {
        super(date);
    }

    @Override
    public String dateAsString() {
        // yyyy-MM-dd
        return date.format(DateTimeFormatter.ISO_DATE);
    }

}
