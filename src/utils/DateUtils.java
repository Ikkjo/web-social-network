package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DateUtils {

    public static List<LocalDate> toDateList(String dateRange) {
        List<LocalDate> dates = new ArrayList<>();
        String[] tokens = dateRange.replaceAll("\\[|\\]|\"", "").split(",");
        for (String token : tokens)
            dates.add(LocalDate.parse(token.replaceAll("T.*", ""), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return dates;
    }

    public static boolean isWithinRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return !(date.isBefore(startDate) || date.isAfter(endDate));
    }

}
