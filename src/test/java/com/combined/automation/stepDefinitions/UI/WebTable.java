package com.combined.automation.stepDefinitions.UI;

import com.combined.automation.pageObjects.UI.WebTablePage;
import com.combined.automation.presetClass.Hooks;
import com.combined.automation.utilities.GenericUtility;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class WebTable extends Hooks {

    @Test
    public void webTable() throws InterruptedException {
        getDriver().get("https://practicetestautomation.com/practice-test-table/");

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
