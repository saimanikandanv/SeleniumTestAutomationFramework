package com.staf.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.staf.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Created by Saimanikandan V on 16-04-2021
 */
public final class ExtentLogger {

    private ExtentLogger(){

    }

    public static void pass(String message)
    {
        ExtentTestManager.getExtentTest().pass(message);
    }
    public static void fail(String message)
    {
        ExtentTestManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotAsBase64Image()).build());
    }
    public static void skip(String message)
    {
        ExtentTestManager.getExtentTest().skip(message);
    }
    public static void info(String message)
    {
        ExtentTestManager.getExtentTest().info(message);
    }

    public static void passWithScreen(String message)
    {
        ExtentTestManager.getExtentTest().pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshotAsBase64Image()).build());
    }

    public static String getScreenshotAsBase64Image(){
       return((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.BASE64);
    }



}
