import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

class HandlerTest {
    Date date = new Date("06 June 2020, Saturday, 10:00");
    Handler handler = new Handler();
    Map<String, List<String>> map = new HashMap<>();
    List<String> list = new ArrayList<>();
    //    String course = "Java 11";
    List<Date> dateList = new ArrayList<>();
    List<String> course = new ArrayList<>();


//    @BeforeEach
//    void beforeTest() {
////        List<Date> dateList = new ArrayList<>();
//        dateList.add(new Date("06 June 2020, Saturday, 10:00"));
//        dateList.add(new Date("07 June 2020, Sunday, 10:00"));
//        dateList.add(new Date("08 June 2020, Monday, 10:00"));
//        dateList.add(new Date("09 June 2020, Tuesday, 10:00"));
//        dateList.add(new Date("10 June 2020, Wednesday, 10:00"));
//        dateList.add(new Date("11 June 2020, Thursday, 10:00"));
//        dateList.add(new Date("12 June 2020, Friday, 10:00"));
//
//        course.add("Java 11");
//        course.add("Java 40");
//        course.add("Java 8");
//        course.add("Java 0");
//
////        list.addAll("Java 11", "Selenium 11", "Spring 11");
//
//    }

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