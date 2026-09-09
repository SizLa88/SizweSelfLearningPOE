package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCheckingAccountPage {

    private WebDriver driver;

    public OpenCheckingAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators

    private By checkingAccountTile = By.xpath("/html/body/app-root/body/div/app-account/app-accounts/div/div[1]/div/div/div[1]/div[2]");

    private By accountNickname = By.id("accountNickname");

    private By checkingAccountOption = By.xpath("//*[@id='typeOfAccount']/option[1]");

    private By openAccountButton = By.xpath("/html/body/app-root/body/div/app-account/app-account-apply/div/div[2]/form/button");

    private By viewAccountsButton = By.id("viewAccounts");

    // Methods

    public void clickCheckingAccount() {
        driver.findElement(checkingAccountTile).click();
    }

    public void enterNickname(String nickname) {
        driver.findElement(accountNickname).sendKeys(nickname);
    }

    public void selectCheckingAccount() {
        driver.findElement(checkingAccountOption).click();
    }

    public void submitApplication() {
        driver.findElement(openAccountButton).click();
    }

    public void viewAccounts() {
        driver.findElement(viewAccountsButton).click();
    }
}