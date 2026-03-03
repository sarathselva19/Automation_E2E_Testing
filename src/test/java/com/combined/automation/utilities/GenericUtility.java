package com.combined.automation.utilities;

import com.combined.automation.presetClass.BaseClass;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenericUtility extends BaseClass {


    public void visibilityOfElements (WebDriver driver, WebElement element, long timeSeconds){
        try{
            WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch(Exception e){
            System.out.println("Element is not visible within the given time: " + e.getMessage());

        }
    }

    public void elementIsClickable (WebDriver driver, WebElement element, long timeSeconds){
        try{
            WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeSeconds));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch(Exception e){
            System.out.println("Element is not not clickable within the given time: " + e.getMessage());

        }
    }

    public void reTryElement(By by,String message )
    {
        int attempt=0;

            while(attempt<=3)
            {
                try {
                    getDriver().findElement(by).clear();
                    System.out.println("cleared successfully");
                    break;
                }
                catch(StaleElementReferenceException e)
                {
                    System.out.println("Stale Execption occured retrying"+e.getMessage());
                    attempt++;
                }
            }


    }

    public void reTryElement(WebElement element,String message )
    {
        int attempt=0;

        while(attempt<=3)
        {
            try {
                //element.click();
                element.clear();

                System.out.println("cleared successfully");
                break;
            }
            catch(StaleElementReferenceException e)
            {
                System.out.println("Stale Execption occured retrying"+e.getMessage());
                attempt++;
            }
        }


    }

    public static boolean validateResponseSchema(Response response, String schemaFilePath) {
        try {
            JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaFilePath)
                    .matches(response.asString());
            System.out.println("Schema validation passed for: " + schemaFilePath);
            return true;
        } catch (Exception e) {
            System.out.println("Schema validation failed: " + e.getMessage());
            return false;
        }
    }



}
