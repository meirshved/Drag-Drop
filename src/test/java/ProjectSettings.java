import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

public class ProjectSettings {

    private WebDriver driver;

    public void setProjectWebDriver(String webDriver){
       switch(webDriver) {
           case "chrome":
               setChromeWebDriver();
               break;
           case "firefox":
               setFirefoxWebDriver();
               break;
           default:
               System.out.println("Error on setting web driver");
       }
    }

    private void setChromeWebDriver(){
        System.setProperty("webdriver.chrome.driver"
                ,"/Users/igor_shved/Documents/Java/libraries/webDrivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
    }

    private void setFirefoxWebDriver(){
        System.setProperty("webdriver.gecko.driver", "/Users/igor_shved/Documents/Java/libraries/webDrivers/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(new FirefoxProfile());
        options.addPreference("dom.webnotifications.enabled", false);
        driver = new FirefoxDriver(options);
    }

    public void setWebDriverSettings(){
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver(){
        return this.driver;
    }
}