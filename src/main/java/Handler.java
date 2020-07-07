import lombok.Data;

import java.util.*;
import java.util.stream.IntStream;

@Data
public class Handler {
    private Date startDate;
    private List<String> courseDurations;

    /**
     * The method parses data which were read from file.
     *
     * @param stringFromFile
     * @return List of Students.
     */
    public List<Student> parseDataFileContent(String stringFromFile) {
        List<Student> students = new ArrayList<>();
        List<String> list = Arrays.asList(stringFromFile.split(Constants.STUDENT_DELIMITER));
        IntStream.range(1, list.size())
                .forEach(i -> students.add(Student.builder()
                        .name(getStudentName(list.get(i)))
                        .curriculum(getStudentCurriculum(list.get(i)))
                        .startDate(getCourseStartDate(list.get(i)))
                        .courseList(getStudentCourseList(list.get(i)))
                        .build()));
        return students;
    }

    private String getStudentName(String studentData) {
        return studentData.split(Constants.STUDENT_SEPARATOR)[1].split(Constants.NEW_LINE_REGEXP)[0].trim();
    }

    private String getStudentCurriculum(String studentData) {
        return studentData.split(Constants.CURRICULUM_SEPARATOR)[1].split(Constants.NEW_LINE_REGEXP)[0].trim();
    }

    private Date getCourseStartDate(String studentData) {
        String studentCourseStartDate = studentData.split(Constants.START_DATE_SEPARATOR)[1].split(Constants.DASH_REGEXP)[0];
        startDate = new Date(studentCourseStartDate);
        startDate.setHours(10);
        return startDate;
    }

    private Map<String, List<String>> getStudentCourseList(String studentData) {
        List<String> courseNames = new ArrayList<>();
        courseDurations = new ArrayList<>();
        String studentCourses = studentData.split(Constants.STUDENTS_COURSES_SEPARATOR)[1];

        List<String> course = Arrays.asList(studentCourses.split(Constants.NEW_LINE_REGEXP));
        IntStream.range(1, course.size())
                .forEach(i -> {
                    courseNames.add(course.get(i)
                            .replaceAll(Constants.COURSE_NAME_REGEXP, Constants.EMPTY_LINE_REGEXP));
                    courseDurations.add(course.get(i).substring(course.get(i).length() - 3).trim());
                });

        Map<String, List<String>> courses = new HashMap<>();
        IntStream.range(0, courseNames.size()).forEach(i -> {
            List<String> courseItem = new ArrayList<>();
            courseItem.add(courseNames.get(i) + " " + courseDurations.get(i));
            courses.put(String.valueOf(i + 1), courseItem);
        });
        return courses;
    }

    /**
     * The method gets end of courses date. It considers working hours and working days.
     *
     * @param student
     * @return finish date.
     */
    public Date getEndDate(Student student) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);

        int days = student.getCoursesDuration() / Constants.QTY_WORKING_HOURS_PER_DAY;
        int hours = student.getCoursesDuration() - (days * Constants.QTY_WORKING_HOURS_PER_DAY);

        if (student.getCoursesDuration() % Constants.QTY_WORKING_HOURS_PER_DAY == 0
                && student.getCoursesDuration() != Constants.QTY_WORKING_HOURS_PER_DAY
                && student.getCoursesDuration() <= Constants.QTY_WORKING_HOURS_PER_WEEK) {
            calendar.roll(Calendar.DATE, days - 1);
            calendar.roll(Calendar.HOUR_OF_DAY, Constants.QTY_WORKING_HOURS_PER_DAY);
        } else if (student.getCoursesDuration() == Constants.QTY_WORKING_HOURS_PER_DAY) {
            calendar.roll(Calendar.HOUR_OF_DAY, Constants.QTY_WORKING_HOURS_PER_DAY);
        } else if (student.getCoursesDuration() > Constants.QTY_WORKING_HOURS_PER_WEEK
                && student.getCoursesDuration() % Constants.QTY_WORKING_HOURS_PER_DAY == 0) {
            calendar.roll(Calendar.DATE, days + 1);
            calendar.roll(Calendar.HOUR_OF_DAY, Constants.QTY_WORKING_HOURS_PER_DAY);
        } else if (student.getCoursesDuration() > Constants.QTY_WORKING_HOURS_PER_WEEK
                && student.getCoursesDuration() % Constants.QTY_WORKING_HOURS_PER_DAY != 0) {
            calendar.roll(Calendar.DATE, days + 2);
            calendar.roll(Calendar.HOUR_OF_DAY, hours);
        } else {
            calendar.roll(Calendar.DATE, days);
            calendar.roll(Calendar.HOUR_OF_DAY, hours);
        }

        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            calendar.roll(Calendar.DATE, 2);
        } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            calendar.roll(Calendar.DATE, 1);
        }
        return calendar.getTime();
    }

    /**
     * Method shows information finished course or not on the date, which is in parameter.
     *
     * @param date
     * @param student
     * @return boolean value.
     */
    public boolean isCompleted(Calendar date, Student student) {
        if (date.getTimeInMillis() > getEndDate(student).getTime()) {
            return true;
        } else if (date.getTimeInMillis() < getEndDate(student).getTime()) {
            return false;
        }
        return false;
    }
}
