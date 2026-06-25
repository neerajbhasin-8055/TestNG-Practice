import org.example.Annotations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PriorityTest {
    WebDriver driver;
    Annotations priorityTest;
    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://neerajbhasin-8055.github.io/TestNg-Practice-Site/");
        priorityTest = new Annotations(driver);
    }
    @Test(priority = 1)
    public void clickLogin(){
        priorityTest.clickLogin();
    }
    @Test(dependsOnMethods = {"clickLogin"})
    public void addToCart(){
        priorityTest.selectAddToCart();
    }
    @Test(dependsOnMethods = {"addToCart"})
    public void processPayment(){
        priorityTest.processPayment();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
