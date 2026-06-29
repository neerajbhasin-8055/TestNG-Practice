package org.arena.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Define the report output path
            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReports/ArenaReport.html");

            // Configure report visuals
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("TestNG Arena Automation Report");
            spark.config().setReportName("Arena SUT v5.0 Execution Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Engineer", "Automation Team");
        }
        return extent;
    }
}