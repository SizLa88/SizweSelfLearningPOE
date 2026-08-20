package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = DriverFactory.initializeDriver();

        driver.get("https://uibank.uipath.com/welcome");
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}