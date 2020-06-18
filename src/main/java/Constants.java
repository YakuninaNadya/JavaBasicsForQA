public interface Constants {

    String PATH_TO_FILE = "src/main/resources/students_list.txt";
    String STUDENT_DELIMITER = "STUDENT";
    String STUDENT_SEPARATOR = "STUDENT:";
    String CURRICULUM_SEPARATOR = "CURRICULUM:";
    String START_DATE_SEPARATOR = "START_DATE";
    String STUDENTS_COURSES_SEPARATOR = "--------------------------------------------";
    String COURSE_NAME_REGEXP = "[^A-Za-z$]";
    String NEW_LINE_REGEXP = "\n";
    String DASH_REGEXP = "-";
    String EMPTY_LINE_REGEXP = "";
    String SPACE_REGEXP = " ";
    String ZERO = "0";
    String DATE_FORMAT = "dd' 'MMMM' 'YYYY,' 'EEEE,' 'HH:mm";

    int HOURS_PER_DAY = 24;
    int MINUTES_PER_HOUR = 60;
    int SECONDS_PER_MINUTE = 60;
    int MILLISECONDS_PER_SECOND = 1000;
    int QTY_WORKING_HOURS_PER_DAY = 8;
    int QTY_WORKING_HOURS_PER_WEEK = 40;

    String FULL_TYPE_OF_REPORT_TEMPLATE = "Full (Generating report date - %s) :\n";
    String STUDENT_NAME_TEMPLATE = "•" + "\tStudent name - %s \n";
    String WORKING_TIME = "\tWorking time - from 10 to 18 (Monday - Friday)\n";
    String PROGRAM_NAME_TEMPLATE = "\tProgram name - %s\n";
    String PROGRAM_DURATION_TEMPLATE = "\tProgram duration - %s\n";
    String HOURS_TEMPLATE = "\tHours - %s\n";
    String START_DATE_TEMPLATE = "\tStart date - %s\n";
    String END_DATE_TEMPLATE = "\tEnd date - %s\n";
    String TRAINING_FINISHED_STATUS_FULL_TEMPLATE = "\tTraining completed. %s have passed after the end.\n";
    String TRAINING_NOT_FINISHED_STATUS_FULL_TEMPLATE = "\tTraining is not finished. %s are left until the end. \n";
    String SHORT_TYPE_OF_REPORT_TEMPLATE = "Short (Generating report date - %s) :\n";
    String NAME_AND_PROGRAM_TEMPLATE = "• %s (%s) - ";
    String TRAINING_FINISHED_STATUS_SHORT_TEMPLATE = "Training completed. %s have passed after the end.\n";
    String TRAINING_NOT_FINISHED_STATUS_SHORT_TEMPLATE = "Training is not finished. %s are left until the end. \n";
    String COURSE_STATUS_TIME_TEMPLATE = "%s day(s) %s hour(s)";
}
