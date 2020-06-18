import java.util.Calendar;

public class Report implements Constants {
    private final StringBuilder sb = new StringBuilder();
    private final Reader reader = new Reader();
    private final Handler handler = new Handler();

    public String generateReport(Calendar reportDate, String reportType) {
        String report;
        if (reportType.equals(ZERO)) {
            report = generateShortReport(reportDate);
        } else {
            report = generateFullReport(reportDate);
        }
        return report;
    }

    public String generateReport(Calendar reportDate) {
        return generateShortReport(reportDate);
    }

    private String generateFullReport(Calendar reportDate) {
        sb.append(String.format(FULL_TYPE_OF_REPORT_TEMPLATE, Utils.formatDate(reportDate.getTime())));
        for (Student student : handler.getStudents(reader.readFromFile())) {
            String report = String.format(STUDENT_NAME_TEMPLATE, student.getName()) +
                    WORKING_TIME +
                    String.format(PROGRAM_NAME_TEMPLATE, student.getCurriculum()) +
                    String.format(PROGRAM_DURATION_TEMPLATE, Utils.toPrettyView(student.getCourseList())) +
                    String.format(HOURS_TEMPLATE, student.getCoursesDuration()) +
                    String.format(START_DATE_TEMPLATE, Utils.formatDate(handler.getStartDate())) +
                    String.format(END_DATE_TEMPLATE, Utils.formatDate(handler.getEndDate(student)));
            sb.append(report);

            long time = Math.abs(handler.getEndDate(student).getTime() - reportDate.getTimeInMillis());

            if (handler.isCompleted(reportDate, student)) {
                sb.append(String.format(TRAINING_FINISHED_STATUS_FULL_TEMPLATE, Utils.getTimeFromMillis(time)));
            } else {
                sb.append(String.format(TRAINING_NOT_FINISHED_STATUS_FULL_TEMPLATE, Utils.getTimeFromMillis(time)));
            }
        }
        return String.valueOf(sb);
    }

    private String generateShortReport(Calendar reportDate) {
        sb.append(String.format(SHORT_TYPE_OF_REPORT_TEMPLATE, Utils.formatDate(reportDate.getTime())));
        for (Student student : handler.getStudents(reader.readFromFile())) {
            sb.append(String.format(NAME_AND_PROGRAM_TEMPLATE, student.getName(), student.getCurriculum()));

            long time = Math.abs(handler.getEndDate(student).getTime() - reportDate.getTimeInMillis());

            if (handler.isCompleted(reportDate, student)) {
                sb.append(String.format(TRAINING_FINISHED_STATUS_SHORT_TEMPLATE, Utils.getTimeFromMillis(time)));
            } else {
                sb.append(String.format(TRAINING_NOT_FINISHED_STATUS_SHORT_TEMPLATE, Utils.getTimeFromMillis(time)));
            }
        }
        return String.valueOf(sb);
    }
}
