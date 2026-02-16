package com.combined.automation.stepDefinitions;

import com.combined.automation.pageObjects.DeepDivePage;
import com.combined.automation.pageObjects.WebTablePage;
import com.combined.automation.presetClass.Hooks;
import com.combined.automation.utilities.GenericUtility;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTable extends Hooks {

    @Test
    public void webTable() throws InterruptedException {
        driver.get("https://practicetestautomation.com/practice-test-table/");

        webtable = new WebTablePage();
      //List<WebElement> header;
      for(WebElement w:webtable.tableHeader)
      {
          String header=w.getText();
          System.out.println("Header Values"+ header);
      }
    String id= webtable.dynamicElement().getText();
        System.out.println(id);
        gutils = new GenericUtility();
    }
}
