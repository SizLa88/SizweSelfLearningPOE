package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterAccountPage {

    WebDriver driver;
    WebDriverWait wait;

    public RegisterAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators

    By registerButton = By.xpath("/html/body/app-root/body/div/app-welcome-page/div[1]/div/div[2]/div/button");

    By email = By.id("email");
    By password = By.id("password");
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By middleName = By.id("middleName");

    By sex = By.id("sex");
    By title = By.id("title");
    By employmentStatus = By.id("employmentStatus");
    By maritalStatus = By.id("maritalStatus");

    By age = By.id("age");
    By dependents = By.id("numberOfDependents");
    By username = By.id("username");
    By agreeCheckbox = By.id("agreeCheckbox");

    By submitButton = By.xpath("/html/body/app-root/body/div/app-register-landing/app-register/div/div/div[2]/form/div[4]/button");

    // Actions

    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }

    public void enterEmail(String emailAddress) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(email))
                .sendKeys(emailAddress);
    }

    public void enterPassword(String pwd) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password))
                .sendKeys(pwd);
    }

    public void enterFirstName(String fName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName))
                .sendKeys(fName);
    }

    public void enterLastName(String lName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName))
                .sendKeys(lName);
    }

    public void enterMiddleName(String mName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(middleName))
                .sendKeys(mName);
    }

    public void selectSex(String gender) {
        new Select(wait.until(
                ExpectedConditions.visibilityOfElementLocated(sex)))
                .selectByVisibleText(gender);
    }

    public void selectTitle(String userTitle) {
        new Select(wait.until(
                ExpectedConditions.visibilityOfElementLocated(title)))
                .selectByVisibleText(userTitle);
    }

    public void selectEmploymentStatus(String status) {
        new Select(wait.until(
                ExpectedConditions.visibilityOfElementLocated(employmentStatus)))
                .selectByVisibleText(status);
    }

    public void selectMaritalStatus(String status) {
        new Select(wait.until(
                ExpectedConditions.visibilityOfElementLocated(maritalStatus)))
                .selectByVisibleText(status);
    }

    public void enterDOB(String dob) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(age))
                .sendKeys(dob);
    }

    public void enterDependents(String number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dependents))
                .sendKeys(number);
    }

    public void enterUsername(String user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username))
                .sendKeys(user);
    }

    public void agreeTerms() {
        wait.until(ExpectedConditions.elementToBeClickable(agreeCheckbox))
                .click();
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton))
                .click();
    }

    // Complete registration method

    public void registerNewUser(
            String emailAddress,
            String pwd,
            String fName,
            String lName,
            String mName,
            String gender,
            String userTitle,
            String employment,
            String marital,
            String dob,
            String dependentsCount,
            String userName) {

        clickRegisterButton();

        enterEmail(emailAddress);
        enterPassword(pwd);
        enterFirstName(fName);
        enterLastName(lName);
        enterMiddleName(mName);

        selectSex(gender);
        selectTitle(userTitle);
        selectEmploymentStatus(employment);
        selectMaritalStatus(marital);

        enterDOB(dob);
        enterDependents(dependentsCount);
        enterUsername(userName);

        agreeTerms();
        clickSubmit();
    }
}