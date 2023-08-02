package Account;

import Base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TransactionForm extends BasePage {
    private By transactionInput;
    private By transactionSubmit;

    public TransactionForm(RemoteWebDriver driver, String action) {
        super(driver);
        this.transactionInput = By.xpath("//form[@ng-submit='" + action + "()']//input");
        this.transactionSubmit = By.xpath("//form[@ng-submit='" + action + "()']//button");
    }

    @Step("Set transaction on {deposit}")
    public AccountPage setTransaction(String deposit) {
        try {
            driver.findElement(transactionInput).sendKeys(deposit);
            Thread.sleep(700);
            driver.findElement(transactionSubmit).click();
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AccountPage(driver);
    }
}
