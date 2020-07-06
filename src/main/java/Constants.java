public final class Constants {

    public static final String FILE_NAME = "students_list.txt";
    public static final String STUDENT_DELIMITER = "STUDENT";
    public static final String STUDENT_SEPARATOR = ":";
    public static final String CURRICULUM_SEPARATOR = "CURRICULUM:";
    public static final String START_DATE_SEPARATOR = "START_DATE";
    public static final String STUDENTS_COURSES_SEPARATOR = "--------------------------------------------";
    public static final String COURSE_NAME_REGEXP = "[^A-Za-z$]";
    public static final String COURSE_NAME_FROM_LIST_REGEXP = "[A-Za-z]+";
    public static final String NEW_LINE_REGEXP = "\n";
    public static final String DASH_REGEXP = "-";
    public static final String EMPTY_LINE_REGEXP = "";
    public static final String SPACE_REGEXP = " ";
    public static final String ZERO = "0";
    public static final String DATE_FORMAT = "dd' 'MMMM' 'YYYY,' 'EEEE,' 'HH:mm";

    public static final int HOURS_PER_DAY = 24;
    public static final int MINUTES_PER_HOUR = 60;
    public static final int SECONDS_PER_MINUTE = 60;
    public static final int MILLISECONDS_PER_SECOND = 1000;
    public static final int QTY_WORKING_HOURS_PER_DAY = 8;
    public static final int QTY_WORKING_HOURS_PER_WEEK = 40;

    public static final String FULL_TYPE_OF_REPORT_TEMPLATE = "Full (Generating report date - %s) :\n";
    public static final String WORKING_TIME = "from 10 to 18 (Monday - Friday)";
    public static final String TRAINING_FINISHED_STATUS_FULL_TEMPLATE = "\tTraining completed. %s have passed after the end.\n";
    public static final String TRAINING_NOT_FINISHED_STATUS_FULL_TEMPLATE = "\tTraining is not finished. %s are left until the end. \n";
    public static final String SHORT_TYPE_OF_REPORT_TEMPLATE = "Short (Generating report date - %s) :\n";
    public static final String NAME_AND_PROGRAM_TEMPLATE = "• %s (%s) - ";
    public static final String TRAINING_FINISHED_STATUS_SHORT_TEMPLATE = "Training completed. %s have passed after the end.\n";
    public static final String TRAINING_NOT_FINISHED_STATUS_SHORT_TEMPLATE = "Training is not finished. %s are left until the end. \n";
    public static final String COURSE_STATUS_TIME_TEMPLATE = "%s day(s) %s hour(s)";

    public static final String PLACEHOLDER_NAME = "\\{\\{NAME\\}\\}";
    public static final String PLACEHOLDER_PROGRAM = "\\{\\{PROGRAM\\}\\}";
    public static final String PLACEHOLDER_DURATION = "\\{\\{DURATION\\}\\}";
    public static final String PLACEHOLDER_HOURS = "\\{\\{HOURS\\}\\}";
    public static final String PLACEHOLDER_START_DATE = "\\{\\{START_DATE\\}\\}";
    public static final String PLACEHOLDER_END_DATE = "\\{\\{END_DATE\\}\\}";
    public static final String PLACEHOLDER_WORKING_HOURS = "\\{\\{WORKING_HOURS\\}\\}";

    public static final String FULL_REPORT_TEMPLATE = "•\tStudent name - {{NAME}} \n" +
            "\tWorking time - {{WORKING_HOURS}}\n" +
            "\tProgram name - {{PROGRAM}}\n" +
            "\tProgram duration - {{DURATION}} \n" +
            "\tHours - {{HOURS}}\n" +
            "\tStart date - {{START_DATE}}\n" +
            "\tEnd date - {{END_DATE}}\n";

}
