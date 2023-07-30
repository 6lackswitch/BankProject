import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static Base.BasePage.driver;
import static Base.BasePage.setup;

public class BaseTest {
    @BeforeClass
    public void init() {
        setup();
    }

    @AfterClass
    public void after() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
