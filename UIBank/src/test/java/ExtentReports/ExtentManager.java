package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter("Reports/AutomationReport.html");

            sparkReporter.config().setReportName("Sizwe Automation Report");
            sparkReporter.config().setDocumentTitle("Automation Test Results");

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Tester", "Sizwe Ngwenya");
            extent.setSystemInfo("Framework", "Selenium TestNG");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}