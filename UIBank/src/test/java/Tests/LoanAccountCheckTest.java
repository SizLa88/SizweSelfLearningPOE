package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoanAccountCheckTest {

    public static WebDriver driver;

    @Test
    public void checkLoanAccount() throws InterruptedException {

        driver = new EdgeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {

            // Open Website

            driver.get("https://uibank.uipath.com/welcome");

            Thread.sleep(1000);

            // Enter Username

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("SizBankTest");

            Thread.sleep(1000);

            // Enter Password

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Test@123");

            Thread.sleep(1000);

            // Click Login

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/body/div/app-welcome-page/div[1]/div/div[1]/div/form/div[3]/button"))).click();

            Thread.sleep(1000);

            // Accept Privacy Policy

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mat-mdc-dialog-0']/div/div/app-agreement-popup/mat-dialog-content/div[2]/button"))).click();

            Thread.sleep(1000);

            // Open Loan Lookup

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dropdownMenuLink']"))).click();

            Thread.sleep(1000);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/body/app-nav-menu/header/nav/div/div/ul/li[2]/div/a[1]"))).click();

            Thread.sleep(1000);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='existingButton']"))).click();

            Thread.sleep(1000);

            // Enter Quote ID

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='quoteID']"))).sendKeys("6aa25ba45765320048f8303f");

            Thread.sleep(1000);

            // Click Search

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/body/div/app-loan/app-loan-lookup/div/div/div/form/div/div[2]/button"))).click();

            Thread.sleep(1000);

            System.out.println("Check Loan Account Status Successful");

            // Leave browser open briefly to view result

            Thread.sleep(3000);

        } catch (Exception e) {

            System.out.println("Loan Account Check Failed");
            e.printStackTrace();

            throw e;

        } finally {

            driver.quit();
        }
    }
}