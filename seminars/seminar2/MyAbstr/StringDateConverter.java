package seminars.seminar2.MyAbstr;

import java.time.LocalDate;

public abstract class StringDateConverter {

    protected final LocalDate date;

    public StringDateConverter(LocalDate date) {
        this.date = date;
    }

    public abstract String dateAsString();

}
