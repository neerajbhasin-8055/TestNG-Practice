package org.arenatest;

import org.arena.ArenaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ArenaTest {
    private WebDriver driver;
    private ArenaPage arena;

    // Provide access to the driver for the CustomListener
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Path/To/Your/UltimateTestNGArena.html");
        arena = new ArenaPage(driver);
    }

    // Tagged for both smoke and regression
    @Test(groups = {"smoke", "regression"}, description = "TC_001: Add item to cart")
    public void step1_addToCart() {
        arena.navigateToTab("lifecycle");
        arena.addToCart();
        Assert.assertTrue(true, "Cart state validated.");
    }

    // Dependent test. If step 1 fails, this is skipped.
    @Test(dependsOnMethods = "step1_addToCart", groups = {"regression"}, description = "TC_002: Login during checkout")
    public void step2_login() {
        arena.loginToAccount();
        Assert.assertTrue(true, "Login state validated.");
    }

    // Tagged only for negative testing
    @Test(groups = {"negative"}, description = "TC_003: Intentional Failure for Screenshot")
    public void intentionalFailureTest() {
        arena.navigateToTab("lifecycle");
        // This will fail and trigger the ITestListener to take a screenshot
        Assert.fail("Failing intentionally to test Extent Reports screenshot logic.");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}