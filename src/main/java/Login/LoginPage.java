package Login;

import Base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By customerLogin = By.xpath("//button[@ng-click='customer()']");
    private static LoginPage loginPage;
    public static LoginPage getInstance() {
        if(loginPage == null) {
            return new LoginPage();
        }
        return loginPage;
    }

    public CustomerLoginPage customerLogin() {
        driver.findElement(customerLogin).click();
        return CustomerLoginPage.getInstance();
    }
}
