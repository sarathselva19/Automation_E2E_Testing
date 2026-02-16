package com.combined.automation.pageObjects;

import com.combined.automation.presetClass.BaseClass;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

//    public LoginPage() {
//
//
//    }

//    @FindBy(how= How.XPATH, using = "//input[@id='username']")
//    private WebElement txtuserName;
//
//    @FindBy(how= How.XPATH, using = "//input[@id='password']")
//    private WebElement txtPassword;
//
//    @FindBy(how= How.XPATH, using = "//button[@class='radius']")
//    private WebElement btnLogin;

    // Objects of - https://the-internet.herokuapp.com/login
//    @FindBy(xpath ="//input[@id='username']")
//    private WebElement txtuserName;
//
//    @FindBy(xpath ="//input[@id='password']")
//    private WebElement txtPassword;
//
//    @FindBy(xpath ="//button[@class='radius']")
//    private WebElement btnLogin;


    @FindBy(xpath ="//input[@id='UserName']")
    private WebElement txtuserName;

    @FindBy(xpath ="//input[@id='Password']")
    private WebElement txtPassword;

    @FindBy(xpath ="//input[@id='loginIn']")
    private WebElement btnLogin;



    public HomePage appLogin(String userName, String password)
    {
        txtuserName.sendKeys(userName);
        txtPassword.sendKeys(password);
        btnLogin.click();
        return new HomePage();
    }

}
