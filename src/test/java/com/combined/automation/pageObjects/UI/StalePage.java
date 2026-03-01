package com.combined.automation.pageObjects.UI;

import com.combined.automation.presetClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StalePage extends BaseClass {

    public StalePage()
    {

        PageFactory.initElements(driver,this);
    }

    //https://omayo.blogspot.com/


    @FindBy(xpath = "//a[text()='onlytestingblog']")
    public WebElement onlyTestingLink;

    @FindBy(id="ta1")
    public WebElement textArea;



    public void staleElementTest() throws InterruptedException {
        Thread.sleep(2000);
        textArea.sendKeys("Test text");
        onlyTestingLink.click();
        driver.navigate().back();
        Thread.sleep(1000);
        textArea.clear();

    }


    String course="Selenium Framework";

    public WebElement dynamicElement()
    {

        return driver.findElement(By.xpath("//table[@id='courses_table']/descendant::td[text()='"+course+"']/preceding-sibling::td"));
    }
}
