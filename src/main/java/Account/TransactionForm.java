package Account;

import Base.BasePage;
import org.openqa.selenium.By;

public class TransactionForm extends BasePage {
    private By transactionInput;
    private By transactionSubmit;

    public TransactionForm(String action) {
        this.transactionInput = By.xpath("//form[@ng-submit='" + action + "()']//input");
        this.transactionSubmit = By.xpath("//form[@ng-submit='" + action + "()']//button");
    }

    public AccountPage setTransaction(String deposit) {
        driver.findElement(transactionInput).sendKeys(deposit);
        driver.findElement(transactionSubmit).click();
        return AccountPage.getInstance();
    }
}
