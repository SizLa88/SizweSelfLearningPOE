package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.lang.Thread;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterAccountTest {

    public static WebDriver driver;

    @Test
    public void registerAccount() throws InterruptedException {

        driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://uibank.uipath.com/welcome");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click Register Button

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/body/div/app-welcome-page/div[1]/div/div[2]/div/button"))).click();

        Thread.sleep(2000);

        // Personal Information

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("siz.ngwenya@gmail.com");

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Test@123");

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys("Sizwe");

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName"))).sendKeys("Ngwenya");

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("middleName"))).sendKeys("M");

        Thread.sleep(2000);

        // Dropdowns

        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sex")))).selectByVisibleText("Male");

        Thread.sleep(2000);

        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")))).selectByVisibleText("Mr");

        Thread.sleep(2000);

        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employmentStatus")))).selectByVisibleText("Full-time");

        Thread.sleep(2000);

        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("maritalStatus")))).selectByVisibleText("Single");

        Thread.sleep(2000);

        // Date of Birth (MM/DD/YY)

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("age"))).sendKeys("07/07/07");

        Thread.sleep(2000);

        // Other Fields

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numberOfDependents"))).sendKeys("1");

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("SizBankTest");

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("agreeCheckbox"))).click();

        Thread.sleep(2000);

        // Register

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/body/div/app-register-landing/app-register/div/div/div[2]/form/div[4]/button"))).click();

        System.out.println("Registration Script Executed Successfully");

        driver.quit();
    }
}