package com.combined.automation.stepDefinitions.UI;
import com.combined.automation.pageObjects.UI.DeepDivePage;
import com.combined.automation.presetClass.BaseClass;
import com.combined.automation.presetClass.Hooks;
import com.combined.automation.utilities.GenericUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileIOTest extends Hooks {

    @Test
    public void fileIOTest() throws InterruptedException {
        getDriver().get("https://the-internet.herokuapp.com/download");
        https://the-internet.herokuapp.com/download
        Thread.sleep(3000);
        deepDivePage=new DeepDivePage();
        gutils=new GenericUtility();
        gutils.elementIsClickable(getDriver(),deepDivePage.fileDownloadLink,20);
        deepDivePage.fileDownloadLink.click();
        //System.out.println("File downloaded successfully");
        Thread.sleep(10000);
        //System.out.println("File downloaded successfully");
        //JavaScriptExecuter js= (JavaScriptExecuter)driver;

        File[] files= BaseClass.file.listFiles();
        for(File file:files) {
            System.out.println(file.getName());
            if (file.getName().equals("tmpa9b835yx.txt1")) {
                System.out.println("File is downloaded successfully");
                file.delete();
                System.out.println("File is deleted successfully");
                break;
            }
            else{
                Assert.assertEquals(file.getName(),"tmpa9b835yx.txt1","File is not downloaded successfully");}
        }

    }

    @Test
    public void FileIoTest2()
    {
        System.out.println("FIleIOTest 2");
    }

    }
