package com.combined.automation.pageObjects.UI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

//    public HomePage () {
//
//    }

    @FindBy(xpath ="//a[text()='Login']")
    private WebElement linkLogin;

    @FindBy(xpath ="//a[text()='Employee List']")
    private WebElement linkSearchmployee;

    public void clickLoginLink()
    {
        linkLogin.click();
        //return new LoginPage();

    }

    public void clickSearchemployeeLink()
    {
        linkSearchmployee.click();
        //return new EmployeePage();
    }

}
