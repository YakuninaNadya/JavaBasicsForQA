import java.util.*;

public class Handler implements Constants {
    private Date startDate;
    private List<String> courseDurations;

    public Date getStartDate() {
        return startDate;
    }

    public List<Student> getStudents(String stringFromFile) {
        List<Student> students = new ArrayList<>();
        List<String> list = Arrays.asList(stringFromFile.split(STUDENT_DELIMITER));
        for (int i = 1; i < list.size(); i++) {
            String item = list.get(i);
            item = STUDENT_DELIMITER + item;
            list.set(i, item);
            Student student = new Student(getStudentName(list.get(i)),
                    getStudentCurriculum(list.get(i)),
                    getCourseStartDate(list.get(i)),
                    getStudentCourseList(list.get(i)));
            students.add(student);
        }
        return students;
    }

    private String getStudentName(String studentData) {
        return studentData.split(STUDENT_SEPARATOR)[1].split(NEW_LINE_REGEXP)[0].trim();
    }

    private String getStudentCurriculum(String studentData) {
        return studentData.split(CURRICULUM_SEPARATOR)[1].split(NEW_LINE_REGEXP)[0].trim();
    }

    private Date getCourseStartDate(String studentData) {
        String studentCourseStartDate = studentData.split(START_DATE_SEPARATOR)[1].split(DASH_REGEXP)[0];
        startDate = new Date(studentCourseStartDate);
        startDate.setHours(10);
        return startDate;
    }

    private List<List<String>> getStudentCourseList(String studentData) {
        List<String> courseNames = new ArrayList<>();
        courseDurations = new ArrayList<>();
        String studentCourses = studentData.split(STUDENTS_COURSES_SEPARATOR)[1];

        List<String> course = Arrays.asList(studentCourses.split(NEW_LINE_REGEXP));
        for (int i = 1; i < course.size(); i++) {
            String courseName = course.get(i).replaceAll(COURSE_NAME_REGEXP, EMPTY_LINE_REGEXP);
            courseNames.add(courseName);
            String courseDuration = course.get(i).substring(course.get(i).length() - 3).trim();
            courseDurations.add(courseDuration);
        }

        List<List<String>> courses = new ArrayList<>();
        courses.add(courseNames);
        courses.add(courseDurations);
        return courses;
    }

    public Date getEndDate(Student student) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);

        int days = student.getCoursesDuration() / QTY_WORKING_HOURS_PER_DAY;
        int hours = student.getCoursesDuration() - (days * QTY_WORKING_HOURS_PER_DAY);

        if (student.getCoursesDuration() % QTY_WORKING_HOURS_PER_WEEK == 0) {
            calendar.roll(Calendar.DATE, days - 1);
            calendar.roll(Calendar.HOUR_OF_DAY, QTY_WORKING_HOURS_PER_DAY);
        } else if (student.getCoursesDuration() % QTY_WORKING_HOURS_PER_DAY == 0 & student.getCoursesDuration() % QTY_WORKING_HOURS_PER_WEEK != 0) {
            calendar.roll(Calendar.DATE, days + 1);
            calendar.roll(Calendar.HOUR_OF_DAY, QTY_WORKING_HOURS_PER_DAY);
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

    public boolean isCompleted(Calendar date, Student student) {
        if (date.getTimeInMillis() > getEndDate(student).getTime()) {
            return true;
        } else if (date.getTimeInMillis() < getEndDate(student).getTime()) {
            return false;
        }
        return false;
    }
}
