package com.combined.automation.presetClass;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import java.util.HashMap;


public class Hooks extends BaseClass {

    //@Before
    @BeforeSuite
    public void setUp() {
        System.out.println("executing before suite");
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

        // initialize WebDriver here so tests can reuse BaseClass.driver
        driver = new ChromeDriver(options);
        System.out.println("[Hooks] WebDriver initialized: " + driver);
        System.out.println("[Hooks] Download path configured: " + downloadPath);
        driver.manage().window().maximize();
    }
        //@After
    @AfterSuite
    public void tearDown() {
        System.out.println("executing After suite");
        System.out.println("[Hooks] tearDown invoked");
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception ignored) {
            } finally {
                driver = null;
            }
        }
    }

//    @BeforeSuite
//    public void beforeSuite()
//    {
//        System.out.println("executing before suite");
//    }

    @BeforeTest
    public void beforeTest()
    {
        System.out.println("executing before Test");
    }

    @BeforeClass
    public void beforeClasst()
    {
        System.out.println("executing before class");
    }

    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("executing before method");
    }

    @AfterMethod
    public void afterMethod()
    {
        System.out.println("executing After method");
    }

    @AfterClass
    public void afterClass()
    {
        System.out.println("executing After class");
    }

    @AfterTest
    public void AfterTest()
    {
        System.out.println("executing After Test");
    }

//    @AfterSuite
//    public void AfterSuite()
//    {
//        System.out.println("executing After suite");
//    }

}
