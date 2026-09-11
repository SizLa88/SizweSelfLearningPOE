package Tests;

import ExtentReports.TestListener;
import Pages.RegisterAccountPage;
import Utils.ExcelReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class RegisterAccountTest {

    public static WebDriver driver;

    @DataProvider(name = "registrationData")
    public Object[][] registrationData() {

        int rows = ExcelReader.getRowCount();

        Object[][] data = new Object[rows][13];

        for (int row = 1; row <= rows; row++) {

            for (int col = 0; col < 13; col++) {

                data[row - 1][col] =
                        ExcelReader.getCellData(row, col);
            }
        }

        return data;
    }

    @Test(dataProvider = "registrationData")
    public void registerAccount(
            String email,
            String password,
            String firstName,
            String lastName,
            String middleInitial,
            String sex,
            String title,
            String employmentStatus,
            String dateOfBirth,
            String maritalStatus,
            String dependents,
            String username,
            String agreeTerms) {

        try {

            driver = new EdgeDriver();

            driver.manage().window().maximize();

            driver.get("https://uibank.uipath.com/welcome");

            RegisterAccountPage registerPage =
                    new RegisterAccountPage(driver);

            registerPage.registerNewUser(
                    email,
                    password,
                    firstName,
                    lastName,
                    middleInitial,
                    sex,
                    title,
                    employmentStatus,
                    maritalStatus,
                    dateOfBirth,
                    dependents,
                    username
            );

            System.out.println(
                    "Successfully Registered : "
                            + username);

        } finally {

            if (driver != null) {
                driver.quit();
            }
        }
    }
}