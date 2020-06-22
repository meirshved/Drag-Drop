import com.example.JSUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AutomationTest extends ProjectTestBase {

    private final String URL = "http://jqueryui.com/droppable/";

    private JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions action = new Actions(driver);

    private final String COLOR = "#fffa90";

    @Test
    public void test_1_openJQueryExercisePage() {
        driver.get(URL);
    }

    @Test
    public void test_2_DragAndDrop(){
        driver.switchTo().frame(0);
        WebElement dragElement = driver.findElement(By.id("draggable"));
        WebElement dropElement = driver.findElement(By.id("droppable"));
        action
                .moveToElement(dragElement)
                .clickAndHold()
                .moveToElement(dropElement)
                .release()
                .build()
                .perform();
        Color actualColor = Color.fromString(dropElement.getCssValue("background-color"));
        Assert.assertEquals(COLOR,actualColor.asHex());
    }
}
