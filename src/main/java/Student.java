import java.util.Date;
import java.util.List;

public class Student {
    private String name;
    private String curriculum;
    private Date startDate;
    private List<List<String>> courseList;

    public Student(String name, String curriculum, Date startDate, List<List<String>> courseList) {
        this.name = name;
        this.curriculum = curriculum;
        this.startDate = startDate;
        this.courseList = courseList;
    }

    public String getName() {
        return name;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public List<List<String>> getCourseList() {
        return courseList;
    }

    public int getCoursesDuration(){
        int courseDuration = 0;
        for (String duration: getCourseList().get(1)) {
            courseDuration += Integer.parseInt(duration);
        }
        return courseDuration;
    }

    @Override
    public String toString() {
        return "Student:" +
                "name='" + name + '\'' +
                ", curriculum='" + curriculum + '\'' +
                ", startDate=" + startDate +
                ", courseList=" + courseList;
    }
}
