package com.combined.automation.pageObjects;

import com.combined.automation.presetClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablePage extends BaseClass {

    public WebTablePage()
    {

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//table[@id='courses_table']/thead/tr/th")
    public List<WebElement> tableHeader;
    String course="Selenium Framework";

    public WebElement dynamicElement()
    {

        return driver.findElement(By.xpath("//table[@id='courses_table']/descendant::td[text()='"+course+"']/preceding-sibling::td"));
    }

}
