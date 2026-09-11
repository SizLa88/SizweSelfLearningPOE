package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TransferFundsPage {

    private WebDriver driver;

    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators

    private By transferMoneyButton = By.id("transferMoney");
    private By fromAccountDropdown = By.id("fromAccount");
    private By toAccountDropdown = By.id("toAccount");
    private By amountField = By.id("amountTransferred");

    private By submitTransferButton = By.xpath("/html/body/app-root/body/div/app-account/app-transfer-money/div[1]/div[2]/form/div[4]/button");

    private By confirmTransferButton = By.xpath("//*[@id='exampleModal']/div/div/div[3]/button[1]");

    private By accountsPageButton = By.xpath("/html/body/app-root/body/div/app-account/app-transfer-result/div[1]/div[1]/a/span");

    private By returnButton = By.xpath("/html/body/app-root/body/div/app-account/app-transfer-money/div[1]/div[1]/a/strong");

    // Actions

    public void clickTransferMoney() {
        driver.findElement(transferMoneyButton).click();
    }

    public void selectFromAccount(int index) {
        Select fromAccount = new Select(driver.findElement(fromAccountDropdown));
        fromAccount.selectByIndex(index);
    }

    public void selectToAccount(int index) {
        Select toAccount = new Select(driver.findElement(toAccountDropdown));
        toAccount.selectByIndex(index);
    }

    public void enterAmount(String amount) {
        driver.findElement(amountField).clear();
        driver.findElement(amountField).sendKeys(amount);
    }

    public void submitTransfer() {
        driver.findElement(submitTransferButton).click();
    }

    public void confirmTransfer() {
        driver.findElement(confirmTransferButton).click();
    }

    public void returnToAccountsPage() {
        driver.findElement(accountsPageButton).click();
    }

    public void clickReturnButton() {
        driver.findElement(returnButton).click();
    }

    public void transferFunds(int fromIndex, int toIndex, String amount) {

        clickTransferMoney();

        selectFromAccount(fromIndex);

        selectToAccount(toIndex);

        enterAmount(amount);

        submitTransfer();

        confirmTransfer();
    }
}