package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Annotations extends BasePage {

    private By annotations = By.xpath("//button[@id='nav-lifecycle']");
    private By parameterInjection = By.xpath("//input[@id='env-domain']");
    private By beforeSuite = By.xpath("//button[@id='btn-suite']");
    private By beforeTest = By.xpath("//button[@id='btn-test']");
    private By beforeClass = By.xpath("//button[@id='btn-class']");
    private By beforeMethod = By.xpath("//button[@id='btn-method']");
    private By addToCart = By.xpath("//div[@class='grid-3']//div[1]");
    private By login = By.xpath("//button[normalize-space()='Login to Account']");
    private By processPayment = By.xpath("//button[normalize-space()='Process Payment']");
    private By clearButton = By.xpath("//button[normalize-space()='Clear']");

    public Annotations(WebDriver driver) {
        super(driver);
    }

    public void clickAnnotationsPage() {
        clickElement(annotations);
    }

    public void enterParameter(String domain) {
        driver.findElement(parameterInjection).sendKeys(domain);
    }

    public void clickBeforeSuite() {
        clickElement(beforeSuite);
    }

    public void clickBeforeTest() {
        clickElement(beforeTest);
    }

    public void clickBeforeClass() {
        clickElement(beforeClass);
    }

    public void clickBeforeMethod() {
        clickElement(beforeMethod);
    }

    // JS Click used to bypass overlays like log-info [cite: 33, 39]
    public void selectAddToCart() {
        clickElementJS(addToCart);
    }

    // JS Click used to bypass overlays like console-container [cite: 66]
    public void clickLogin() {
        clickElementJS(login);
    }

    public void processPayment() {
        clickElementJS(processPayment);
    }

    public void clickClear() {
        clickElementJS(clearButton);
    }
}