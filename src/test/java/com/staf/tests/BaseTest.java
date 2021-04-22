package com.staf.tests;

import com.staf.constants.FrameworkConstants;
import com.staf.driver.DriverHelper;
import com.staf.enums.PropertyFileEnums;
import com.staf.reports.ExtentLogger;
import com.staf.reports.ExtentReporting;
import com.staf.util.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

/**
 * Created by Saimanikandan V on 03-04-2021
 */
public class BaseTest {

    protected  BaseTest()
    {

    }

    @BeforeMethod
    public void startTest(Method m) throws Exception {
        DriverHelper.initDriver();
    }

    @AfterMethod
    public void endTest()
    {

        DriverHelper.quitDriver();
    }

}
