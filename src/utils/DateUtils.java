package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DateUtils {

    public static List<Long> toDateList(String dateRange) {
        List<Long> dates = new ArrayList<>();
        String[] tokens = dateRange.replaceAll("\\[|\\]|\"", "").split(",");
        for (String token : tokens)
            dates.add(LocalDate.parse(token.replaceAll("T.*", ""), DateTimeFormatter.ofPattern("yyyy-MM-dd")).toEpochDay());
        return dates;
    }

    public static boolean isWithinRange(Long date, Long startDate, Long endDate) {
        return !(date < startDate || date > (endDate));
    }

}
