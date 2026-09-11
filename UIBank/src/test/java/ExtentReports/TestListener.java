package ExtentReports;

import Base.DriverFactory;
import Utils.ScreenshotHelper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestListener implements ITestListener {

    private static final ExtentReports extent =
            ExtentManager.getInstance();

    private static int passedTests = 0;
    private static int failedTests = 0;
    private static int skippedTests = 0;

    @Override
    public void onTestStart(ITestResult result) {

        String testName =
                result.getMethod().getMethodName();

        if (result.getParameters().length > 11) {

            testName += " - "
                    + result.getParameters()[11];
        }

        System.out.println(
                "[EXTENT] STARTING TEST: "
                        + testName);

        ExtentTestManager.setTest(
                extent.createTest(testName)
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        passedTests++;

        System.out.println(
                "[EXTENT] PASS: "
                        + result.getMethod().getMethodName());

        ExtentTestManager.getTest()
                .log(
                        Status.PASS,
                        "Test Passed Successfully"
                );
    }

    @Override
    public void onTestFailure(ITestResult result) {

        failedTests++;

        System.out.println(
                "[EXTENT] FAIL: "
                        + result.getMethod().getMethodName());

        ExtentTestManager.getTest()
                .log(
                        Status.FAIL,
                        result.getThrowable()
                );

        try {

            String screenshotPath =
                    ScreenshotHelper.takeScreenshot(
                            DriverFactory.getDriver(),
                            result.getMethod()
                                    .getMethodName()
                    );

            ExtentTestManager.getTest()
                    .addScreenCaptureFromPath(
                            screenshotPath
                    );

        } catch (Exception e) {

            ExtentTestManager.getTest()
                    .log(
                            Status.WARNING,
                            "Unable to attach screenshot."
                    );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        skippedTests++;

        System.out.println(
                "[EXTENT] SKIPPED: "
                        + result.getMethod().getMethodName());

        ExtentTestManager.getTest()
                .log(
                        Status.SKIP,
                        "Test Skipped"
                );
    }

    @Override
    public void onFinish(ITestContext context) {

        int totalTests =
                passedTests
                        + failedTests
                        + skippedTests;

        double successRate =
                totalTests == 0
                        ? 0
                        : ((double) passedTests
                           / totalTests) * 100;

        ExtentTest dashboard =
                extent.createTest(
                        "Execution Dashboard"
                );

        dashboard.info(
                "Total Tests : "
                        + totalTests);

        dashboard.pass(
                "Passed Tests : "
                        + passedTests);

        dashboard.fail(
                "Failed Tests : "
                        + failedTests);

        dashboard.skip(
                "Skipped Tests : "
                        + skippedTests);

        dashboard.info(
                "Success Rate : "
                        + String.format(
                        "%.2f",
                        successRate)
                        + "%");

        try {

            File jpgFile =
                    new File(
                            System.getProperty("user.dir")
                                    + File.separator
                                    + "Reports"
                                    + File.separator
                                    + "ResultsPieChart.jpg");

            File pngFile =
                    new File(
                            System.getProperty("user.dir")
                                    + File.separator
                                    + "Reports"
                                    + File.separator
                                    + "ResultsPieChart.png");

            if (jpgFile.exists()) {

                dashboard.addScreenCaptureFromPath(
                        jpgFile.getAbsolutePath(),
                        "Pass / Fail Pie Chart");

                System.out.println(
                        "[EXTENT] JPG Pie Chart Attached");

            } else if (pngFile.exists()) {

                dashboard.addScreenCaptureFromPath(
                        pngFile.getAbsolutePath(),
                        "Pass / Fail Pie Chart");

                System.out.println(
                        "[EXTENT] PNG Pie Chart Attached");

            } else {

                System.out.println(
                        "[EXTENT] No Pie Chart Found");
            }

        } catch (Exception e) {

            System.out.println(
                    "[EXTENT] Pie Chart Attachment Failed");

            e.printStackTrace();
        }

        System.out.println(
                "[EXTENT] FLUSHING REPORT");

        extent.flush();

        ExtentTestManager.unload();
    }
}