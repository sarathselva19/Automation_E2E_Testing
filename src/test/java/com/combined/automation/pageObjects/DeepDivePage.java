package com.combined.automation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeepDivePage extends BasePage {

    //Dropdown elements // https://demowebshop.tricentis.com/

    @FindBy (xpath="//li[@class='inactive']//a[normalize-space()='Books']")
    public WebElement bookOptions;

    @FindBy (xpath="//select[@id='products-orderby']")
    public WebElement dropdownWebShop;

//ShadowRoot Element handle

    @FindBy (css="book-app[apptitle=\'BOOKS\']")
    public WebElement shadowHost;

    // File Download
    @FindBy(xpath="//a[text()='tmpa9b835yx.txt']")
    public WebElement fileDownloadLink;


}
