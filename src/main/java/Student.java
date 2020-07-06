import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class Student {
    private String name;
    private String curriculum;
    private Date startDate;
    private Map<String, List<String>> courseList;

    /**
     * Method parses Map<String, List<String>> with all courses list.
     * @return sum of courses duration.
     */
    public int getCoursesDuration() {
        int courseDuration = 0;
        for (int i = 1; i <= getCourseList().size(); i++) {
            List<String> courses = getCourseList().get(String.valueOf(i));
            for (String course : courses) {
                courseDuration += Integer.parseInt(course
                        .replaceAll(Constants.COURSE_NAME_FROM_LIST_REGEXP, Constants.EMPTY_LINE_REGEXP).trim());
            }
        }
        return courseDuration;
    }
}
