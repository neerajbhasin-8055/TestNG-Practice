package org.arena;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ArenaPage extends BasePage {

    public ArenaPage(WebDriver driver) {
        super(driver);
    }

    // --- Navigation ---
    public void navigateToTab(String tabName) {
        clickElementJS(By.id("nav-" + tabName));
    }

    // --- Tab 1: Lifecycle & Flow ---
    public void enterEnvironment(String env) {
        enterText(By.id("env-domain"), env);
        clickElement(By.xpath("//button[text()='Verify']"));
    }

    public String getEnvStatus() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("env-status"))).getText();
    }

    public void bootSystemSequence(String sequenceId) {
        // Using JS Click as elements might be pushed down by the top bar
        clickElementJS(By.id("btn-" + sequenceId));
    }

    public void addToCart() {
        clickElementJS(By.xpath("//button[text()='Add to Cart']"));
    }

    public void loginToAccount() {
        clickElementJS(By.xpath("//button[text()='Login to Account']"));
    }

    public void processPayment() {
        clickElementJS(By.xpath("//button[text()='Process Payment']"));
    }

    // --- Tab 2: Advanced Attributes ---
    public void castVote() {
        clickElementJS(By.xpath("//button[text()='Cast Vote']"));
    }

    public String getVoteCount() {
        return driver.findElement(By.id("vote-count")).getText();
    }

    public void generateReport() {
        clickElement(By.id("reportBtn"));
        // Wait for loader to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("reportLoader")));
    }

    public void connectToFlakyServer() {
        clickElementJS(By.xpath("//button[text()='Connect to Server']"));
    }

    public String getFlakyStatus() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flakyStatus"))).getText();
    }

    // --- Tab 3: Data-Driven ---
    public void fillFlightDetails(String src, String dest) {
        enterText(By.id("flightSrc"), src);
        enterText(By.id("flightDest"), dest);
        // Custom Calendar Interaction
        clickElement(By.className("cal-trigger"));
        clickElement(By.xpath("//div[@class='cal-day' and text()='15']")); // Hardcoded day for demo
        clickElementJS(By.xpath("//button[text()='Book Flight']"));
    }

    // --- Tab 4: Advanced Elements ---
    public void startWaitTimer() {
        clickElement(By.xpath("//button[text()='Start 5s Timer']"));
    }

    public boolean isDelayedElementVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("delayed-element"))).isDisplayed();
    }

    public void interactWithShadowDOM() {
        WebElement shadowHost = driver.findElement(By.id("shadow-host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        shadowRoot.findElement(By.id("shadowBtn")).click();
    }

    public void handleAlert() {
        clickElementJS(By.xpath("//button[text()='Alert']"));
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void interactWithIFrame() {
        driver.switchTo().frame("securityFrame");
        wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button"))).click();
        driver.switchTo().defaultContent(); // Always switch back!
    }
}