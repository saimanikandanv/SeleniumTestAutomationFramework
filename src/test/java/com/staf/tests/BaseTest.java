package com.staf.tests;

import com.staf.constants.FrameworkConstants;
import com.staf.driver.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Saimanikandan V on 03-04-2021
 */
public class BaseTest {

    protected  BaseTest()
    {

    }

    @BeforeMethod
    public void startTest()
    {
        DriverHelper.initDriver();
    }

    @AfterMethod
    public void endTest()
    {

        DriverHelper.quitDriver();
    }

}
