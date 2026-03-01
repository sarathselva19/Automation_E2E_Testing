package com.combined.automation.pageObjects.UI;

import com.combined.automation.presetClass.BaseClass;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends BaseClass {

    public BasePage  () {
        PageFactory.initElements(driver, this);

    }
}
