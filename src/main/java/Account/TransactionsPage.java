package Account;

import Base.BasePage;
import org.openqa.selenium.By;

public class TransactionsPage extends BasePage {
    private final By resetButton = By.xpath("//button[@ng-click='reset()']");
    public Table table() {
        return new Table();
    }


}
