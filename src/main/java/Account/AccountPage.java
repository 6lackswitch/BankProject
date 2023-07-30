package Account;

import Base.BasePage;
import org.openqa.selenium.By;

public class AccountPage extends BasePage {
    private final By accountNumber = By.xpath("//div[@ng-hide='noAccount']//strong[1]");
    private final By balance = By.xpath("//div[@ng-hide='noAccount']//strong[2]");
    private final By currency = By.xpath("//div[@ng-hide='noAccount']//strong[3]");
    private final By transactionsButton = By.xpath("//button[@ng-click='transactions()']");
    private final By depositButton = By.xpath("//button[@ng-click='deposit()']");
    private final By withdrawlButton = By.xpath("//button[@ng-click='withdrawl()']");
    private static AccountPage accountPage;
    public static AccountPage getInstance() {
        if(accountPage == null) {
            return new AccountPage();
        }
        return accountPage;
    }

    public TransactionsPage transactionsClick() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(transactionsButton).click();
        return new TransactionsPage();
    }

    public TransactionForm depositClick() {
        driver.findElement(depositButton).click();
        return new TransactionForm("deposit");
    }

    public TransactionForm withdrawlClick() {
        driver.findElement(withdrawlButton).click();
        return new TransactionForm("withdrawl");
    }

    public String getBalance() {
        return driver.findElement(balance).getText();
    }
}
