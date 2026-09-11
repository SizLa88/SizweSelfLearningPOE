package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String reportDir =
                    System.getProperty("user.dir")
                            + File.separator
                            + "Reports";

            new File(reportDir).mkdirs();

            String reportPath =
                    reportDir
                            + File.separator
                            + "AutomationReport.html";

            System.out.println(
                    "[EXTENT] Report Path: "
                            + reportPath);

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(reportPath);

            spark.config().setDocumentTitle(
                    "UIBank Automation Dashboard");

            spark.config().setReportName(
                    "UIBank Registration Test Results");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo(
                    "Tester",
                    "Sizwe Ngwenya");

            extent.setSystemInfo(
                    "Framework",
                    "Selenium + TestNG");

            extent.setSystemInfo(
                    "Browser",
                    "Microsoft Edge");

            extent.setSystemInfo(
                    "Environment",
                    "QA");

            extent.setSystemInfo(
                    "Execution Type",
                    "Data Driven Testing");
        }

        return extent;
    }
}