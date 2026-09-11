package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoansPage {

    WebDriver driver;

    public LoansPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators

    By applyButton = By.id("applyButton");
    By email = By.id("email");
    By amount = By.id("amount");
    By term = By.id("term");
    By income = By.id("income");
    By age = By.id("age");
    By submitButton = By.id("submitButton");

    // Actions

    public void clickApplyButton() {
        driver.findElement(applyButton).click();
    }

    public void enterEmail(String emailAddress) {
        driver.findElement(email).sendKeys(emailAddress);
    }

    public void enterAmount(String loanAmount) {
        driver.findElement(amount).sendKeys(loanAmount);
    }

    public void selectTerm(int index) {
        Select loanTerm = new Select(driver.findElement(term));
        loanTerm.selectByIndex(index);
    }

    public void enterIncome(String salary) {
        driver.findElement(income).sendKeys(salary);
    }

    public void enterAge(String applicantAge) {
        driver.findElement(age).sendKeys(applicantAge);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
}
