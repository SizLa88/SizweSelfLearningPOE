package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators

    private By usernameField = By.id("username");

    private By passwordField = By.id("password");

    private By loginButton = By.xpath("/html/body/app-root/body/div/app-welcome-page/div[1]/div/div[1]/div/form/div[3]/button");

    private By agreementButton = By.xpath("//*[@id='mat-mdc-dialog-0']/div/div/app-agreement-popup/mat-dialog-content/div[2]/button");

    // Methods

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void acceptAgreement() {
        driver.findElement(agreementButton).click();
    }

    public void login(String username, String password) {

        enterUsername(username);

        enterPassword(password);

        clickLogin();

        acceptAgreement();
    }
}