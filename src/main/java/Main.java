public class Main {
    public static void main(String[] args) {

        /**
         * Please, choose reportDate, and write it in "YYYY-MM-DD HH"format, for example "2020-06-06 10".
         * Also choose type of the report: short or full (no parameter
         * or parameter 0 - an abbreviated view of the short report, otherwise - a full report
         */

        String reportDate = "2020-06-06 10";
        Report report = new Report();
        System.out.println(report
                .generateReport(Utils.generateDateFromString(reportDate), "1"));
    }
}
