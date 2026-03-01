package com.combined.automation.Report_ProprtyManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            // Step 1 - Define where report file will be generated
            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter("test-output/ExtentReport/ExtentReport.html");

            // Step 2 - Configure the report appearance
            sparkReporter.config().setDocumentTitle("API Automation Report");
            sparkReporter.config().setReportName("Booking API Test Results");
            sparkReporter.config().setTheme(Theme.DARK);  // DARK or STANDARD

            // Step 3 - Attach reporter to ExtentReports
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            // Step 4 - Add system info to report
            extent.setSystemInfo("Tester", "Sarath Kumar");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", "API");
        }

        return extent;
    }
}