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
    public void testOpenSavingsAccount() {

        driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://uibank.uipath.com/welcome");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open Savings Account

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='accountNickname']"))).sendKeys("SizweSaves");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='typeOfAccount']/option[2]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/body/div/app-account/app-account-apply/div/div[2]/form/button"))).click();

        System.out.println("Open Savings Account Successful");
    }
}
