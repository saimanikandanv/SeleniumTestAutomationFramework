package com.staf.driver;

import com.staf.constants.FrameworkConstants;
import com.staf.util.Utils;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Objects;

/**
 * Created by Saimanikandan V on 03-04-2021
 */
public final class DriverHelper {

    private DriverHelper(){

    }


    public static void initDriver() throws Exception {
        if(Objects.isNull(DriverManager.getWebDriver()))
        {
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
            DriverManager.setWebDriver(new ChromeDriver());
            DriverManager.getWebDriver().manage().window().maximize();
            DriverManager.getWebDriver().get(Utils.getValue("url"));
        }
    }

    public static void quitDriver()
    {
        if(Objects.nonNull(DriverManager.getWebDriver()))
        {
            DriverManager.getWebDriver().quit();
            DriverManager.unloadWebDriver();
        }
    }

}
