package Tests;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class LoginTest {

    public static WebDriver driver;

    @Test
    public void login() {

        driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://uibank.uipath.com/welcome");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "SizBankTest",
                "Test@123"
        );

        System.out.println("Login Successful");

        driver.quit();
    }
}