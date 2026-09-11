package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static Tests.LoginTest.driver;

public class TransferFundsTest {

    @Test
    public void testTransferFunds() throws InterruptedException {

        driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://uibank.uipath.com/welcome");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Login

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("SizBankTest");

        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Test@123");

        Thread.sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/body/div/app-welcome-page/div[1]/div/div[1]/div/form/div[3]/button"))).click();

        Thread.sleep(1000);

        // Accept Privacy Policy

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mat-mdc-dialog-0']/div/div/app-agreement-popup/mat-dialog-content/div[2]/button"))).click();

        Thread.sleep(1000);

        // Open Accounts Page

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/body/app-nav-menu/header/nav/div/div/ul/li[1]/a"))).click();

        Thread.sleep(1000);

        // Open Checking Account

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/body/div/app-account/app-accounts/div/div[1]/div/div/div[2]/div/div/div/div[1]/a/strong"))).click();

        Thread.sleep(1000);

        // Click Transfer Money

        wait.until(ExpectedConditions.elementToBeClickable(By.id("transferMoney"))).click();

        Thread.sleep(1000);

        // Select From Account

        Select fromAccount = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromAccount"))));

        fromAccount.selectByIndex(1);

        Thread.sleep(1000);

        // Select To Account

        Select toAccount = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toAccount"))));

        toAccount.selectByIndex(3);

        Thread.sleep(1000);

        // Enter Amount

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amountTransferred"))).sendKeys("100");

        Thread.sleep(1000);

        // Submit Transfer

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/body/div/app-account/app-transfer-money/div[1]/div[2]/form/div[4]/button"))).click();

        Thread.sleep(1000);

        // Confirm Transfer

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='exampleModal']/div/div/div[3]/button[1]"))).click();

        Thread.sleep(1000);

        System.out.println("Transfer Funds Successful");

        // Return to Accounts Page

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/body/div/app-account/app-transfer-result/div[1]/div[1]/a/span"))).click();

        Thread.sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/body/div/app-account/app-transfer-money/div[1]/div[1]/a/strong"))).click();

        Thread.sleep(3000);

        driver.quit();
    }
}