package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static Tests.LoginTest.driver;

public class OpenSavingsAccountTest {

    @Test
    public void testOpenSavingsAccount() throws InterruptedException {

        driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://uibank.uipath.com/welcome");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Login

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("SizBankTest");

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Test@123");

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/body/div/app-welcome-page/div[1]/div/div[1]/div/form/div[3]/button"))).click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mat-mdc-dialog-0']/div/div/app-agreement-popup/mat-dialog-content/div[2]/button"))).click();

        Thread.sleep(2000);

        // Open Savings Account

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/body/div/app-account/app-accounts/div/div[1]/div/div/div[1]/div[2]"))).click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='accountNickname']"))).sendKeys("SizSavesAcc");

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='typeOfAccount']/option[2]"))).click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/body/div/app-account/app-account-apply/div/div[2]/form/button"))).click();

        // Click to View New Account Opened

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='viewAccounts']"))).click();

        System.out.println("Open Savings Account Successful");

        driver.quit();
    }
}