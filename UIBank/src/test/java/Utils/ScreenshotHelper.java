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

    public static void takeScreenshot(
            WebDriver driver,
            String screenshotName) {

        try {

            File source =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            String timestamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss")
                            .format(new Date());

            File destination =
                    new File("Screenshots/"
                            + screenshotName
                            + "_"
                            + timestamp
                            + ".png");

            FileUtils.copyFile(source, destination);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}