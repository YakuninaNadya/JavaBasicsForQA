import java.util.Calendar;

public class Report {
    private final StringBuilder sb = new StringBuilder();
    private final Reader reader = new Reader();
    private final Handler handler = new Handler();

    /**
     * Method generates report with report type parameter.
     *
     * @param reportDate
     * @param reportType
     * @return String with information about students courses and status.
     */
    public String generateReport(Calendar reportDate, ReportType reportType) {
        String report;
        switch (reportType.toString()) {
            case "FULL":
                report = generateFullReport(reportDate);
                break;
            case "SHORT":
                report = generateShortReport(reportDate);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + reportType);
        }
        return report;
    }

    /**
     * Method generates report without report type parameter.
     *
     * @param reportDate
     * @return String with information about students courses and status.
     */
    public String generateReport(Calendar reportDate) {
        return generateShortReport(reportDate);
    }

    private String generateFullReport(Calendar reportDate) {
        sb.append(String.format(Constants.FULL_TYPE_OF_REPORT_TEMPLATE, Utils.formatDate(reportDate.getTime())));
        for (Student student : handler.parseDataFileContent(reader.readFromFile())) {
            String report = Constants.FULL_REPORT_TEMPLATE
                    .replaceAll(Constants.PLACEHOLDER_NAME, student.getName())
                    .replaceAll(Constants.PLACEHOLDER_WORKING_HOURS, Constants.WORKING_TIME)
                    .replaceAll(Constants.PLACEHOLDER_PROGRAM, student.getCurriculum())
                    .replaceAll(Constants.PLACEHOLDER_DURATION, Utils.toPrettyView(student.getCourseList()))
                    .replaceAll(Constants.PLACEHOLDER_HOURS, String.valueOf(student.getCoursesDuration()))
                    .replaceAll(Constants.PLACEHOLDER_START_DATE, Utils.formatDate(handler.getStartDate()))
                    .replaceAll(Constants.PLACEHOLDER_END_DATE, Utils.formatDate(handler.getEndDate(student)));
            sb.append(report);

            long time = Math.abs(handler.getEndDate(student).getTime() - reportDate.getTimeInMillis());

            if (handler.isCompleted(reportDate, student)) {
                sb.append(String.format(Constants.TRAINING_FINISHED_STATUS_FULL_TEMPLATE, Utils.getTimeFromMillis(time)));
            } else {
                sb.append(String.format(Constants.TRAINING_NOT_FINISHED_STATUS_FULL_TEMPLATE, Utils.getTimeFromMillis(time)));
            }
        }
        return String.valueOf(sb);
    }

    private String generateShortReport(Calendar reportDate) {
        sb.append(String.format(Constants.SHORT_TYPE_OF_REPORT_TEMPLATE, Utils.formatDate(reportDate.getTime())));
        for (Student student : handler.parseDataFileContent(reader.readFromFile())) {
            sb.append(String.format(Constants.NAME_AND_PROGRAM_TEMPLATE, student.getName(), student.getCurriculum()));

            long time = Math.abs(handler.getEndDate(student).getTime() - reportDate.getTimeInMillis());

            if (handler.isCompleted(reportDate, student)) {
                sb.append(String.format(Constants.TRAINING_FINISHED_STATUS_SHORT_TEMPLATE, Utils.getTimeFromMillis(time)));
            } else {
                sb.append(String.format(Constants.TRAINING_NOT_FINISHED_STATUS_SHORT_TEMPLATE, Utils.getTimeFromMillis(time)));
            }
        }
        return String.valueOf(sb);
    }
}
