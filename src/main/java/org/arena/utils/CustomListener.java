package org.arena.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;


public class CustomListener implements ITestListener {
    private ExtentReports extent = ExtentManager.getInstance();
    private ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        // The description text is extracted by TestNG and injected into ExtentReports [cite: 264]
        String description = result.getMethod().getDescription();
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), description);
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed Successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());

        // Attempt to capture a screenshot on failure
        try {
            Object testClass = result.getInstance();
            // Assumes your test class has a getDriver() method
            WebDriver driver = ((org.arena.tests.ArenaTest) testClass).getDriver();

            if (driver != null) {
                String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
                test.get().addScreenCaptureFromBase64String(base64Screenshot, "Failure Screenshot");
            }
        } catch (Exception e) {
            test.get().log(Status.WARNING, "Could not attach screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flushes the data to the HTML file
        extent.flush();
    }
}