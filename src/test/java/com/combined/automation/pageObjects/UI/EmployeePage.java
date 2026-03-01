package com.combined.automation.pageObjects.UI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeePage extends BasePage {

//    public EmployeePage() {
//
//    }

    @FindBy(xpath ="//input[@name='searchTerm']")
    private WebElement btnSearchEmp;

    public void searchEmployee()
    {
        btnSearchEmp.sendKeys("Ramsh");
    }
}
