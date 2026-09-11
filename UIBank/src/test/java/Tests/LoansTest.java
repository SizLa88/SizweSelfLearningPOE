package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoansTest {

    public static WebDriver driver;

    @Test
    public void openLoan() {

        driver = new EdgeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {

            driver.get("https://uibank.uipath.com/welcome");

            // Open Menu

            wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdownMenuLink"))).click();

            // Open Loan Page

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/body/app-nav-menu/header/nav/div/div/ul/li[1]/div/a[1]"))).click();

            // Apply Button

            wait.until(ExpectedConditions.elementToBeClickable(By.id("applyButton"))).click();

            // Fill Form

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("test@example.com");

            driver.findElement(By.id("amount")).sendKeys("10000");

            // Loan Term Dropdown

            Select term = new Select(driver.findElement(By.id("term")));
            term.selectByIndex(3);

            driver.findElement(By.id("income")).sendKeys("50000");

            driver.findElement(By.id("age")).sendKeys("38");

            // Submit Button

            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submitButton")));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", submitButton);

            Thread.sleep(1000);

            try {
                submitButton.click();
            } catch (Exception e) {

                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].click();",
                                submitButton);
            }

            System.out.println("Open Loan Successful");

        } catch (Exception e) {

            System.out.println("Test Failed");
            e.printStackTrace();

        } finally {

            driver.quit();
        }
    }
}