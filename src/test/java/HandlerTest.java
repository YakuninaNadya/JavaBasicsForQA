import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

class HandlerTest {
    Handler handler = new Handler();
    Map<String, List<String>> map = new HashMap<>();
    List<String> list = new ArrayList<>();

    @ParameterizedTest
    @ValueSource(strings = {"Tue Jun 09 13:00:00 MSK 2020"})
    void getEndDateTest1(String expected) {
        handler.setStartDate(new Date("06 June 2020, Saturday, 10:00"));
        String course = "Java 11";
        list.add(course);
        map.put("1", list);
        Student student = Student.builder()
                .startDate(handler.getStartDate())
                .name("Ivan")
                .courseList(map)
                .curriculum("QA").build();

        String actual = handler.getEndDate(student).toString();
        Assertions.assertEquals(expected, actual, expected + " was expected, but end date is another");
    }
    @ParameterizedTest
    @ValueSource(strings = {"Mon Jun 08 18:00:00 MSK 2020"})
    void getEndDateTest2(String expected) {
        handler.setStartDate(new Date("06 June 2020, Saturday, 10:00"));
        String course = "Java 8";
        list.add(course);
        map.put("1", list);
        Student student = Student.builder()
                .startDate(handler.getStartDate())
                .name("Ivan")
                .courseList(map)
                .curriculum("QA").build();

        String actual = handler.getEndDate(student).toString();
        Assertions.assertEquals(expected, actual, expected + " was expected, but end date is another");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Mon Jun 08 18:00:00 MSK 2020"})
    void getEndDateTest3(String expected) {
        handler.setStartDate(new Date("08 June 2020, Monday, 10:00"));
        String course = "Java 8";
        list.add(course);
        map.put("1", list);
        Student student = Student.builder()
                .startDate(handler.getStartDate())
                .name("Ivan")
                .courseList(map)
                .curriculum("QA").build();

        String actual = handler.getEndDate(student).toString();
        Assertions.assertEquals(expected, actual, expected + " was expected, but end date is another");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Fri Jun 12 18:00:00 MSK 2020"})
    void getEndDateTest5(String expected) {
        handler.setStartDate(new Date("08 June 2020, Monday, 10:00"));
        String course = "Java 40";
        list.add(course);
        map.put("1", list);
        Student student = Student.builder()
                .startDate(handler.getStartDate())
                .name("Ivan")
                .courseList(map)
                .curriculum("QA").build();

        String actual = handler.getEndDate(student).toString();
        Assertions.assertEquals(expected, actual, expected + " was expected, but end date is another");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Mon Jun 15 13:00:00 MSK 2020"})
    void getEndDateTest4(String expected) {
        handler.setStartDate(new Date("12 June 2020, Friday, 10:00"));
        String course = "Java 11";
        list.add(course);
        map.put("1", list);
        Student student = Student.builder()
                .startDate(handler.getStartDate())
                .name("Ivan")
                .courseList(map)
                .curriculum("QA").build();

        String actual = handler.getEndDate(student).toString();
        Assertions.assertEquals(expected, actual, expected + " was expected, but end date is another");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Fri Jun 12 10:00:00 MSK 2020"})
    void getEndDateTest6(String expected) {
        handler.setStartDate(new Date("12 June 2020, Friday, 10:00"));
        String course = "Java 0";
        list.add(course);
        map.put("1", list);
        Student student = Student.builder()
                .startDate(handler.getStartDate())
                .name("Ivan")
                .courseList(map)
                .curriculum("QA").build();

        String actual = handler.getEndDate(student).toString();
        Assertions.assertEquals(expected, actual, expected + " was expected, but end date is another");
    }

}