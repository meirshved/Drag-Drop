import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class ProjectTestBase {

    private static final String PROJECT_DIVER = "firefox";

    protected static WebDriver driver;

    private static ProjectSettings projectSettings = new ProjectSettings();

    @BeforeClass
    public static void testSettings(){
        projectSettings.setProjectWebDriver(PROJECT_DIVER);
        projectSettings.setWebDriverSettings();
        driver = projectSettings.getDriver();
    }

    @AfterClass
    public static void tearsDown() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }
}