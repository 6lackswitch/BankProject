package Login;

import Base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPage extends BasePage {
    private final By customerLogin = By.xpath("//button[@ng-click='customer()']");
    private static LoginPage loginPage;

    public LoginPage(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("Going to the customer's login page")
    public CustomerLoginPage customerLogin() {
        driver.findElement(customerLogin).click();
        return new CustomerLoginPage(driver);
    }
}
