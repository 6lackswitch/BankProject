package Account;

import Base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AccountPage extends BasePage {
    private final By balance = By.xpath("//div[@ng-hide='noAccount']//strong[2]");
    private final By transactionsButton = By.xpath("//button[@ng-click='transactions()']");
    private final By depositButton = By.xpath("//button[@ng-click='deposit()']");
    private final By withdrawlButton = By.xpath("//button[@ng-click='withdrawl()']");
    private static AccountPage accountPage;

    public AccountPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("Going to transactions page")
    public TransactionsPage transactionsClick() {
        driver.findElement(transactionsButton).click();
        return new TransactionsPage(driver);
    }

    @Step("Click to deposit")
    public TransactionForm depositClick() {
        driver.findElement(depositButton).click();
        return new TransactionForm(driver, "deposit");
    }

    @Step("Click to withdrawl")
    public TransactionForm withdrawlClick() {
        driver.findElement(withdrawlButton).click();
        return new TransactionForm(driver, "withdrawl");
    }

    public String getBalance() {
        return driver.findElement(balance).getText();
    }
}
