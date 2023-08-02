import Base.Config;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public static RemoteWebDriver driver;

    public static RemoteWebDriver getDriver() {
        if(driver == null) {
            System.setProperty("webdriver.chrome.driver", Config.DRIVER_PATH);
            DesiredCapabilities cap = new DesiredCapabilities();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-dev-shm-usage");

            cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            cap.setBrowserName("chrome");
            try {
                driver = new RemoteWebDriver(new URL(Config.HUB), cap);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    @BeforeClass
    public void before() {
        getDriver().get(Config.URL);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass
    public void after() {
        getDriver().quit();
    }
}
