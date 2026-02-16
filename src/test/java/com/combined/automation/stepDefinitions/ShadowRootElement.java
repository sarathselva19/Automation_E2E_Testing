package com.combined.automation.stepDefinitions;

import com.combined.automation.pageObjects.DeepDivePage;
import com.combined.automation.presetClass.Hooks;
import com.combined.automation.utilities.GenericUtility;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

import java.time.Duration;

public class ShadowRootElement extends Hooks {

    @Test
    public void shadowRootHandle() throws InterruptedException {
        driver.get("https://books-pwakit.appspot.com/");

        deepDivePage=new DeepDivePage();
        gutils=new GenericUtility();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        SearchContext shadowRootElement=deepDivePage.shadowHost.getShadowRoot();
        shadowRootElement.findElement(By.cssSelector("input[id='input']")).sendKeys("Hi Test");
        Thread.sleep(1000);


        SearchContext shadowRootElement1=shadowRootElement.findElement(By.cssSelector("book-home")).getShadowRoot();
       String Text= shadowRootElement1.findElement(By.cssSelector("div[class='books-desc']")).getText();
        System.out.println(Text);
        //gutils.elementIsClickable(driver,deepDivePage.shadowHost,20);



    }

}