package com.combined.automation.presetClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import java.util.HashMap;


public class Hooks extends BaseClass {

    @BeforeMethod
    public void setUp() {
        System.out.println("[Hooks] [Thread: " + Thread.currentThread().getName() + "] Initializing WebDriver");
        // Ensure geckodriver is available on the machine
        ChromeOptions options=new ChromeOptions();
        HashMap<String, Object> prefs = new HashMap<String, Object>();

        // Set download directory to a reliable location (Windows temp folder or user-defined)
        //String downloadPath = "D:\\Testfolder";
        prefs.put("download.default_directory", downloadPath);

        // Disable download prompt
        prefs.put("download.prompt_for_download", false);

        // Allow multiple downloads
        prefs.put("profile.default_content_settings.popups", 0);

        options.setExperimentalOption("prefs", prefs);

        // initialize WebDriver for this thread
        WebDriver driver = new ChromeDriver(options);
        setDriver(driver);  // Store in ThreadLocal
        //getDriver() = threadDriver;    // Also keep for backward compatibility
        System.out.println("[Hooks] [Thread: " + Thread.currentThread().getName() + "] WebDriver initialized: " + getDriver());
        System.out.println("[Hooks] Download path configured: " + downloadPath);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("[Hooks] [Thread: " + Thread.currentThread().getName() + "] Tearing down WebDriver");
        //WebDriver threadDriver = getDriver();
        if (getDriver() != null) {
            try {
                getDriver().quit();
            } catch (Exception e) {
                System.out.println("[Hooks] Error quitting driver: " + e.getMessage());
            } finally {
                driver.remove(); // Clean up ThreadLocal
                //driver = null;                // Clean up static reference
            }
        }
    }

    @BeforeClass
    public void beforeClasst()
    {
        System.out.println("[BeforeClass] [Thread: " + Thread.currentThread().getName() + "] Executing before class");
    }

    @AfterClass
    public void afterClass()
    {
        System.out.println("[AfterClass] [Thread: " + Thread.currentThread().getName() + "] Executing after class");
    }

    @BeforeTest
    public void beforeTest()
    {
        System.out.println("[BeforeTest] [Thread: " + Thread.currentThread().getName() + "] Executing before test");
    }

    @AfterTest
    public void AfterTest()
    {
        System.out.println("[AfterTest] [Thread: " + Thread.currentThread().getName() + "] Executing after test");
    }

}
