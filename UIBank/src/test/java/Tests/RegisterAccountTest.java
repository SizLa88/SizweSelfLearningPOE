package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import java.time.Instant;

public class RegisterAccountTest extends BaseTest {

    @Test
    public void registerAccount() {

        System.out.println("Test Started");

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //wait.until(ExpectedConditions.elementToBeClickable(By.id("get-started"))).click();

        //wait.until(ExpectedConditions.elementToBeClickable(By.id("email"))).sendKeys("siz.ngwenya@gmail.com");

        //wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys("LetMeIn88#");

        //wait.until(ExpectedConditions.elementToBeClickable(By.id("firstName"))).sendKeys("Sizwe");

        //wait.until(ExpectedConditions.elementToBeClickable(By.id("lastName"))).sendKeys("Ngwenya");

        //wait.until(ExpectedConditions.elementToBeClickable(By.id("middleName"))).sendKeys("Mpumelelo");

        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sex']/option[2]"))).click();

        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='title']/option[4]"))).click();

        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='employmentStatus']/option[2]"))).click();

        //wait.until(ExpectedConditions.elementToBeClickable(By.id("age"))).sendKeys("07/25/88");

        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='maritalStatus']/option[2]"))).click();

        //wait.until(ExpectedConditions.elementToBeClickable(By.id("numberOfDependents"))).sendKeys("0");

        //wait.until(ExpectedConditions.elementToBeClickable(By.id("username"))).sendKeys("SizweNG");

        //wait.until(ExpectedConditions.elementToBeClickable(By.id("agreeCheckbox"))).click();

        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Register')]"))).click();

        System.out.println("Account registration completed successfully at: " + Instant.now());
    }
}
