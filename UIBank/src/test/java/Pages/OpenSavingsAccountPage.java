package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenSavingsAccountPage {

    private WebDriver driver;

    public OpenSavingsAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators

    private By savingsAccountTile = By.xpath("/html/body/app-root/body/div/app-account/app-accounts/div/div[1]/div/div/div[1]/div[2]");

    private By accountNickname = By.id("accountNickname");

    private By savingsAccountOption = By.xpath("//*[@id='typeOfAccount']/option[2]");

    private By openAccountButton = By.xpath("/html/body/app-root/body/div/app-account/app-account-apply/div/div[2]/form/button");

    private By viewAccountsButton = By.id("viewAccounts");

    // Methods
    public void clickSavingsAccount() {
        driver.findElement(savingsAccountTile).click();
    }

    public void enterNickname(String nickname) {
        driver.findElement(accountNickname).sendKeys(nickname);
    }

    public void selectSavingsAccount() {
        driver.findElement(savingsAccountOption).click();
    }

    public void submitApplication() {
        driver.findElement(openAccountButton).click();
    }

    public void viewAccounts() {
        driver.findElement(viewAccountsButton).click();
    }
}