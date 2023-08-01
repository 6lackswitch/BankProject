package Login;

import Account.AccountPage;
import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CustomerLoginPage extends BasePage {
    private final By selectName = By.id("userSelect");
    private final By options = By.xpath("//option[@class='ng-binding ng-scope']");
    private final By login = By.xpath("//button[@type='submit']");
    private static CustomerLoginPage customerLoginPage;
    public static CustomerLoginPage getInstance() {
        if(customerLoginPage == null) {
            return new CustomerLoginPage();
        }
        return customerLoginPage;
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

    public AccountPage loginAs(String name) {
        chooseName(name);
        driver.findElement(login).click();
        return AccountPage.getInstance();
    }
}
