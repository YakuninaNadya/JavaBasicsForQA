import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GUI extends JFrame {
    private JTextArea reportText;
    private String date;
    private JComboBox comboBox;
    private JDatePickerImpl datePicker;

    public void setFrame() {
        final JFrame frame = new JFrame("Reports generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel mainPanel = new JPanel();
        setCharacteristics(mainPanel, 10, 10, 490, 790);

        mainPanel.add(addReportDatePanel());
        mainPanel.add(addReportTypePanel());
        mainPanel.add(addReportTextPanel());
        mainPanel.add(addGenerateBtn());

        frame.getContentPane().add(mainPanel);
        frame.setSize(500, 800);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private JPanel addReportDatePanel() {
        final JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Select report date:"));
        setCharacteristics(panel, 10, 10, 480, 80);

        final UtilDateModel model = new UtilDateModel();
        final JDatePanelImpl datePanel = new JDatePanelImpl(model);
        datePicker = new JDatePickerImpl(datePanel);
        date = datePicker.getJFormattedTextField().getSelectedText();
        datePicker.setLocation(10, 25);
        datePicker.setSize(200, 40);
        panel.add(datePicker);
        return panel;
    }

    private JPanel addReportTypePanel() {
        final JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Select report type:"));
        setCharacteristics(panel, 10, 100, 480, 80);

        final String[] typesOfReport = {"Full", "Short"};
        comboBox = new JComboBox(typesOfReport);
        comboBox.setLocation(10, 25);
        comboBox.setSize(200, 40);
        panel.add(comboBox);
        return panel;
    }

    private JPanel addReportTextPanel() {
        final Border border = BorderFactory.createLineBorder(Color.WHITE, 0);
        final JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Report:"));
        setCharacteristics(panel, 10, 190, 480, 400);

        reportText = new JTextArea();
        reportText.setSize(455, 360);
        reportText.setLocation(10, 25);
        final JScrollPane scroll = new JScrollPane(reportText);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBorder(border);
        scroll.setSize(457, 365);
        scroll.setLocation(10, 25);
        panel.add(scroll);
        return panel;
    }

    private JButton addGenerateBtn() {
        final JButton reportBtn = new JButton("Generate report");
        reportBtn.setVisible(true);
        reportBtn.setSize(120, 50);
        reportBtn.setLocation(200, 600);
        reportBtn.addActionListener(new ButtonEventListener());
        return reportBtn;
    }

    private void setCharacteristics(JPanel panel, int x, int y, int width, int height) {
        panel.setLocation(x, y);
        panel.setSize(width, height);

        panel.setOpaque(true);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            final Date selectedDate = (Date) datePicker.getModel().getValue();
            final DateFormat df = new SimpleDateFormat(Constants.DATE_REPORT_FORMAT);
            final String reportDate = df.format(selectedDate);

            final String selectedType = String.valueOf(comboBox.getSelectedItem());
            ReportType reportType = null;
            switch (selectedType.toUpperCase()) {
                case "FULL":
                    reportType = ReportType.FULL;
                    break;
                case "SHORT":
                    reportType = ReportType.SHORT;
                    break;
                default:
                    break;
            }
//            if (selectedType.equals("Full")) {
//                reportType = Constants.ONE;
//            } else {
//                reportType = Constants.ZERO;
//            }
            reportText.setText(new Report().generateReport(Utils.generateDateFromString(reportDate), reportType));
        }
    }
}

