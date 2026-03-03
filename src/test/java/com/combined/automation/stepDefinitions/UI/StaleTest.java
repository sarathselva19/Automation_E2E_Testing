package com.combined.automation.stepDefinitions.UI;

import com.combined.automation.pageObjects.UI.StalePage;
import com.combined.automation.presetClass.Hooks;
import com.combined.automation.utilities.GenericUtility;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.id;

public class StaleTest extends Hooks {

    @Test
    public void staleTest() throws InterruptedException {
        getDriver().get("https://omayo.blogspot.com/");

        stale = new StalePage();
        System.out.println("Stale Test Started");
        //stale.staleElementTest();

//        stale.textArea.sendKeys("Test text");
//        stale.onlyTestingLink.click();
//        driver.navigate().back();
//        Thread.sleep(2000);
//        stale.textArea.clear();
//        Thread.sleep(2000);

        WebElement staleElement = getDriver().findElement(id("ta1"));
        staleElement.sendKeys("Test text");
        Thread.sleep(1000);
        stale.onlyTestingLink.click();
        Thread.sleep(2000);
        getDriver().navigate().back();

        Thread.sleep(1000);
        // staleElement.clear();

        gutils = new GenericUtility();
        gutils.reTryElement(By.id("ta1"), "String Message");

        gutils.reTryElement(stale.textArea, "String Message");


        System.out.println("Stale Test Ended");

    }

    @Test
    public void StaleTest2()
    {
        System.out.println("StaleTest 2");
    }
}
