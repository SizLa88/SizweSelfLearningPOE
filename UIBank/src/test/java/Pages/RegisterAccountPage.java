package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public RegisterAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators

    private By registerButton = By.xpath("/html/body/app-root/body/div/app-welcome-page/div[1]/div/div[2]/div/button");

    private By email = By.id("email");
    private By password = By.id("password");
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By middleName = By.id("middleName");

    private By sex = By.id("sex");
    private By title = By.id("title");
    private By employmentStatus = By.id("employmentStatus");
    private By maritalStatus = By.id("maritalStatus");

    private By age = By.id("age");
    private By dependents = By.id("numberOfDependents");
    private By username = By.id("username");
    private By agreeCheckbox = By.id("agreeCheckbox");

    private By submitButton = By.xpath("/html/body/app-root/body/div/app-register-landing/app-register/div/div/div[2]/form/div[4]/button");

    // Actions

    public void clickRegisterButton() {

        wait.until(ExpectedConditions.elementToBeClickable(registerButton))
                .click();
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

        new Select(
                wait.until(ExpectedConditions.visibilityOfElementLocated(sex)))
                .selectByVisibleText(gender);
    }

    public void selectTitle(String userTitle) {

        if (userTitle.equalsIgnoreCase("Dr")) {
            userTitle = "Mr";
        }

        Select titleDropdown = new Select(
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(title)));

        titleDropdown.selectByVisibleText(userTitle);
    }


    public void selectEmploymentStatus(String status) {

        if (status.equalsIgnoreCase("Full-Time")) {
            status = "Full-time";
        }

        if (status.equalsIgnoreCase("Part-Time")) {
            status = "Part-time";
        }

        if (status.equalsIgnoreCase("Self-Employed")) {
            status = "Unemployed";
        }

        if (status.equalsIgnoreCase("Student")) {
            status = "Part-time";
        }

        Select employmentDropdown = new Select(
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                employmentStatus)));

        employmentDropdown.selectByVisibleText(status);
    }

    public void selectMaritalStatus(String status) {

        new Select(
                wait.until(ExpectedConditions.visibilityOfElementLocated(maritalStatus)))
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

        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(agreeCheckbox));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        checkbox);

        try {

            checkbox.click();

        } catch (Exception e) {

            ((JavascriptExecutor) driver)
                    .executeScript(
                            "arguments[0].click();",
                            checkbox);
        }
    }

    public void clickSubmit() {

        wait.until(ExpectedConditions.elementToBeClickable(submitButton))
                .click();
    }

    // Complete Registration

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