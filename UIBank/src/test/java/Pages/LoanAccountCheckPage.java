package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoanAccountCheckPage {

    private WebDriver driver;

    public LoanAccountCheckPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators

    private By menuButton = By.id("dropdownMenuLink");

    private By loansMenu = By.xpath("/html/body/app-root/body/app-nav-menu/header/nav/div/div/ul/li[2]/div/a[1]");

    private By existingLoanButton = By.id("existingButton");

    private By quoteIdField = By.id("quoteID");

    private By searchButton = By.xpath("/html/body/app-root/body/div/app-loan/app-loan-lookup/div/div/div/form/div/div[2]/button");

    // Actions

    public void openMenu() {
        driver.findElement(menuButton).click();
    }

    public void openLoansMenu() {
        driver.findElement(loansMenu).click();
    }

    public void clickExistingLoan() {
        driver.findElement(existingLoanButton).click();
    }

    public void enterQuoteId(String quoteId) {
        driver.findElement(quoteIdField).sendKeys(quoteId);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    public void performLoanLookup(String quoteId) {

        openMenu();

        openLoansMenu();

        clickExistingLoan();

        enterQuoteId(quoteId);

        clickSearch();
    }
}