package com.combined.automation.stepDefinitions.UI;

import com.combined.automation.pageObjects.UI.DeepDivePage;
import com.combined.automation.presetClass.Hooks;
import com.combined.automation.utilities.GenericUtility;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DropDown extends Hooks {
    @Test
    public void dropDOwn() throws InterruptedException {
        getDriver().get("https://demowebshop.tricentis.com/");

        deepDivePage=new DeepDivePage();
        gutils=new GenericUtility();
        gutils.elementIsClickable(getDriver(),deepDivePage.bookOptions,20);
        deepDivePage.bookOptions.click();
        gutils.elementIsClickable(getDriver(),deepDivePage.dropdownWebShop,20);
        deepDivePage.dropdownWebShop.click();
        Thread.sleep(1000);

        //Select Class
        Select select= new Select(deepDivePage.dropdownWebShop);
        select.selectByIndex(2);

        List<WebElement> selectOptions=new LinkedList<>();
        selectOptions=select.getOptions();
        System.out.println("Total options in the dropdown are: "+selectOptions.size());
        System.out.println(selectOptions);
        for (WebElement op: selectOptions){
            System.out.println(op.getText());
        }
        System.out.println("***************");

        //FInd Duplicate using the Set
        List<String> TestOptions=new LinkedList<>();
        TestOptions.add("Sarath");
        TestOptions.add("Sarath");
        TestOptions.add("Sarath1");
        TestOptions.add("Sarath1");
        TestOptions.add("Sarath2");
        System.out.println(TestOptions);

        System.out.println("***************");

        Set<String> uniqueOptions=new HashSet<>();
        for(String uop:TestOptions)
        {
            if(!uniqueOptions.add(uop))
            {
                System.out.println("Duplicate option is: "+uop);
            }
        }
        System.out.println("***************");
        System.out.println(uniqueOptions);






    }

    @Test
    public void TestDropDown2()
    {
        System.out.println("Test 2");
    }

}
