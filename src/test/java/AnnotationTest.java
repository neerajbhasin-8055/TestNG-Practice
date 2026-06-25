import org.example.Annotations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationTest {
    WebDriver driver;
    Annotations annotations;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://neerajbhasin-8055.github.io/TestNg-Practice-Site/");
        annotations = new Annotations(driver);
    }

    @Test
    public void checkAnnotationWorkflow(){
        annotations.clickAnnotationsPage();
        annotations.enterParameter("https://example.com");
        annotations.clickBeforeSuite();
        annotations.clickBeforeTest();
        annotations.clickClear();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
