package Base;

import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePage {
    protected RemoteWebDriver driver;

    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
    }
}
