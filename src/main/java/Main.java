public class Main {
    public static void main(String[] args) {

        /**
         * Please, choose reportDate, and write it in "YYYY-MM-DD HH"format, for example "2020-06-06 10".
         * Also choose type of the report: short or full.
         *
         *
         * If you want to use GUI, uncomment the next line:
         */
//        runGUI();

        String reportDate = "2020-06-06 10";
        runCLI(reportDate, ReportType.FULL);
    }

    private static void runCLI(String reportDate, ReportType reportType) {
        System.out.println(new Report()
                .generateReport(Utils.generateDateFromString(reportDate), reportType));
    }

    private static void runGUI() {
        new GUI().runGUI();
    }
}
