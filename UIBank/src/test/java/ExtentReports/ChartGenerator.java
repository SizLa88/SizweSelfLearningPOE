package ExtentReports;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.io.File;

public class ChartGenerator {

    public static void generatePieChart(
            int passed,
            int failed,
            int skipped) {

        try {

            DefaultPieDataset<String> dataset =
                    new DefaultPieDataset<>();

            dataset.setValue(
                    "Passed",
                    passed);

            dataset.setValue(
                    "Failed",
                    failed);

            dataset.setValue(
                    "Skipped",
                    skipped);

            JFreeChart pieChart =
                    ChartFactory.createPieChart(
                            "Test Results",
                            dataset,
                            true,
                            true,
                            false);

            String chartPath =
                    System.getProperty("user.dir")
                            + File.separator
                            + "Reports"
                            + File.separator
                            + "ResultsPieChart.png";

            ChartUtils.saveChartAsPNG(
                    new File(chartPath),
                    pieChart,
                    800,
                    600
            );

            System.out.println(
                    "[EXTENT] Pie Chart Generated: "
                            + chartPath
            );

        } catch (Exception e) {

            System.out.println(
                    "[EXTENT] Pie Chart Generation Failed"
            );

            e.printStackTrace();
        }
    }
}