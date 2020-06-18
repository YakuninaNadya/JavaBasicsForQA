import java.text.SimpleDateFormat;
import java.util.*;

public class Utils implements Constants {
    public static String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH);
        return format.format(date);
    }

    public static String toPrettyView(List<List<String>> courseList) {
        StringBuilder result = new StringBuilder();
        for (int j = 0; j <= courseList.size(); j++) {
            for (List<String> strings : courseList) {
                result.append(strings.get(j)).append(SPACE_REGEXP);
            }
        }
        return result.toString();
    }

    public static String getTimeFromMillis(long time) {
        long days = time / MILLISECONDS_PER_SECOND / SECONDS_PER_MINUTE / MINUTES_PER_HOUR / HOURS_PER_DAY;
        long hours = time / MILLISECONDS_PER_SECOND / SECONDS_PER_MINUTE / MINUTES_PER_HOUR - days * HOURS_PER_DAY;
        return String.format(COURSE_STATUS_TIME_TEMPLATE, days, hours);
    }

    public static Calendar generateDateFromString(String stringDate) {
        Calendar reportDate = new GregorianCalendar();
        int year = Integer.parseInt(stringDate.split(DASH_REGEXP)[0]) - 1900;
        int month = Integer.parseInt(stringDate.split(DASH_REGEXP)[1]) - 1;
        int date = Integer.parseInt(stringDate.split(DASH_REGEXP)[2].split(SPACE_REGEXP)[0]);
        int hours = Integer.parseInt(stringDate.split(SPACE_REGEXP)[1]);

        reportDate.setTime(new Date(year, month, date, hours, Integer.parseInt(ZERO)));
        return reportDate;
    }
}
