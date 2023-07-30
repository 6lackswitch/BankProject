package Login;

import Base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By customerLogin = By.xpath("//button[@ng-click='customer()']");
    private final By managerLogin = By.xpath("//button[@ng-click='manager()']");

    public CustomerLoginPage customerLogin() {
        driver.findElement(customerLogin).click();
        return new CustomerLoginPage();
    }
}
