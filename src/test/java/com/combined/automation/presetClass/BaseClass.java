package com.combined.automation.presetClass;

import com.combined.automation.pageObjects.*;
//import com.combined.automation.utilities.projectSpecific.GenericUtilitis;
import com.combined.automation.stepDefinitions.FileIOTest;
import com.combined.automation.utilities.GenericUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public abstract class BaseClass {




    public static WebDriver driver;
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



}
