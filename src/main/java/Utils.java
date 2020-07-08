import java.text.SimpleDateFormat;
import java.util.*;

public class Utils {

    /**
     * Method formats the date to "DD Month YYYY, Weekday, HH:MM".
     * @param date
     * @return formatted date string.
     */
    public static String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.ENGLISH);
        return format.format(date);
    }

    /**
     * Method formats the array to pretty view string.
     * @param courseList
     * @return formatted array string.
     */
    public static String toPrettyView(Map<String, List<String>> courseList) {
        StringBuilder result = new StringBuilder();
        for (int j = 1; j <= courseList.size(); j++) {
            for (String strings : courseList.get(String.valueOf(j))) {
                result.append(strings).append(Constants.SPACE_REGEXP);
            }
        }
        return result.toString();
    }

    /**
     * The method gets time from milliseconds and converts in to days and hours.
     * @param time
     * @return String with time.
     */
    public static String getTimeFromMillis(long time) {
        long days = time / Constants.MILLISECONDS_PER_SECOND / Constants.SECONDS_PER_MINUTE / Constants.MINUTES_PER_HOUR / Constants.HOURS_PER_DAY;
        long hours = time / Constants.MILLISECONDS_PER_SECOND / Constants.SECONDS_PER_MINUTE / Constants.MINUTES_PER_HOUR - days * Constants.HOURS_PER_DAY;
        return String.format(Constants.COURSE_STATUS_TIME_TEMPLATE, days, hours);
    }

    /**
     * Methods generates date from string "YYYY-MM-DD HH" format.
     * @param stringDate
     * @return Calendar date.
     */
    public static Calendar generateDateFromString(String stringDate) {
        Calendar reportDate = new GregorianCalendar();
        int year = Integer.parseInt(stringDate.split(Constants.DASH_REGEXP)[0]) - 1900;
        int month = Integer.parseInt(stringDate.split(Constants.DASH_REGEXP)[1]) - 1;
        int date = Integer.parseInt(stringDate.split(Constants.DASH_REGEXP)[2].split(Constants.SPACE_REGEXP)[0]);
        int hours = Integer.parseInt(stringDate.split(Constants.SPACE_REGEXP)[1]);

        reportDate.setTime(new Date(year, month, date, hours, Integer.parseInt(Constants.ZERO)));
        return reportDate;
    }
}
