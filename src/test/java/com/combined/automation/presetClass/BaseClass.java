package com.combined.automation.presetClass;

//import com.combined.automation.utilities.projectSpecific.GenericUtilitis;
import com.combined.automation.pageObjects.UI.*;
import com.combined.automation.stepDefinitions.UI.FileIOTest;
import com.combined.automation.utilities.GenericUtility;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;

        import java.io.File;

public abstract class BaseClass {

    // ThreadLocal for parallel execution support - protected so subclasses can access
    protected static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Public getter for backward compatibility
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Public setter for initialization
    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    // Public field for direct access (for backward compatibility)
    //public static WebDriver driver;
    //public static BasePage currentPage;
    //public static GenericUtilitis gutils;

    // File donloads
    public static String downloadPath = "D:\\Testfolder";
    public static File file=new File(downloadPath);

    public static EmployeePage empPage;
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static DeepDivePage deepDivePage;
    public static WebTablePage webtable;
    public static StalePage stale;
    public static FileIOTest fileIOTest;


    public static GenericUtility gutils;

    // API Variables

    public static RequestSpecification gRequest;
    public static Response gResponse;
    public static String baseURL="https://restful-booker.herokuapp.com";
    public static String schemaPath;
    public static boolean isSchemaExpected;


}
