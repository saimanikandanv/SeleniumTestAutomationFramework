package com.staf.driver;

import com.staf.constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

/**
 * Created by Saimanikandan V on 03-04-2021
 */
public class DriverHelper {

    public static WebDriver driver;


    public static void initDriver()
    {
        if(Objects.isNull(driver))
        {
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://www.google.com");
        }
    }

    public static void quitDriver()
    {
        if(Objects.nonNull(driver))
        {
            driver.quit();
        }
    }

}
