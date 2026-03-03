package com.combined.automation.stepDefinitions.UI;

import com.combined.automation.pageObjects.UI.EmployeePage;
import com.combined.automation.pageObjects.UI.HomePage;
import com.combined.automation.pageObjects.UI.LoginPage;
import com.combined.automation.presetClass.Hooks;
import org.testng.annotations.Test;

public class LoginTest extends Hooks {



    @Test
    public void login() {
//    driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
//    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
//    driver.findElement(By.xpath("//button[@class='radius']")).click();
        getDriver().navigate().to("http://eaapp.somee.com/");
       homePage=new HomePage();
        //LoginPage login=new LoginPage(); -->this line of code is removed as calling the method returns the required login page object
       // LoginPage login= hmpage.clickLoginLink(); --> Symplified this link using the curret page declaration in base class
        homePage.clickLoginLink();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        loginPage= new LoginPage();
        loginPage.appLogin("UserName","Password@01");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        homePage.clickSearchemployeeLink();

        empPage=new EmployeePage();

        empPage.searchEmployee();

    }



}
