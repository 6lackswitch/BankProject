package Base;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BasePage {
    public static RemoteWebDriver driver;

    public static void setup() {
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
        driver.get(Config.URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
