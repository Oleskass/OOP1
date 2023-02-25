package seminars.seminar2.MyInterf;

import java.time.LocalDate;
// import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DefaultDateConverter implements DateConverter {
    @Override
    public String convert(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

}
