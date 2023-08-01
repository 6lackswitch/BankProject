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
        try {
            driver.findElement(transactionInput).sendKeys(deposit);
            Thread.sleep(700);
            driver.findElement(transactionSubmit).click();
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return AccountPage.getInstance();
    }
}
