package com.combined.automation.Listeners;

import com.combined.automation.Report_ProprtyManager.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();

    // ThreadLocal to support parallel execution
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    // ✅ Runs when a test METHOD starts
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        extentTest.get().log(Status.INFO, "Test Started : "
                + result.getMethod().getMethodName());
    }

    // ✅ Runs when a test PASSES
    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed : "
                + result.getMethod().getMethodName());
    }

    // ✅ Runs when a test FAILS
    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().log(Status.FAIL, "Test Failed : "
                + result.getMethod().getMethodName());
        extentTest.get().log(Status.FAIL, "Reason : "
                + result.getThrowable());  // captures the exception/error message
    }

    // ✅ Runs when a test is SKIPPED
    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Test Skipped : "
                + result.getMethod().getMethodName());
    }

    // ✅ Runs after ALL tests are done - flushes report to HTML file
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();  // VERY IMPORTANT - without this report won't generate
    }
}