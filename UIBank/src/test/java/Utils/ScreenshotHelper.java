package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotHelper {

    public static String takeScreenshot(
            WebDriver driver,
            String screenshotName) {

        String screenshotPath = "";

        try {

            File screenshotDir = new File("Screenshots");

            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            File source =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            String timestamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss")
                            .format(new Date());

            screenshotPath =
                    "Screenshots/"
                            + screenshotName
                            + "_"
                            + timestamp
                            + ".png";

            File destination = new File(screenshotPath);

            FileUtils.copyFile(source, destination);

            System.out.println("Screenshot saved: " + screenshotPath);

        } catch (IOException e) {

            System.out.println("Failed to capture screenshot.");

            e.printStackTrace();
        }

        return screenshotPath;
    }
}
