package Login;

import Account.AccountPage;
import Base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class CustomerLoginPage extends BasePage {
    private final By selectName = By.id("userSelect");
    private final By options = By.xpath("//option[@class='ng-binding ng-scope']");
    private final By login = By.xpath("//button[@type='submit']");
    private static CustomerLoginPage customerLoginPage;

    public CustomerLoginPage(RemoteWebDriver driver) {
        super(driver);
    }

    public CustomerLoginPage chooseName(String name) {
        driver.findElement(selectName).click();
        driver.findElements(options)
                .stream()
                .filter(x -> x.getText().equals(name))
                .findFirst()
                .ifPresentOrElse(WebElement::click, Assert::fail);
        return this;
    }

    @Step("Login as {name}")
    public AccountPage loginAs(String name) {
        chooseName(name);
        driver.findElement(login).click();
        return new AccountPage(driver);
    }
}
