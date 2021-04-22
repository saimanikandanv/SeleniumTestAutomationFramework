package com.staf.driver;

import com.staf.constants.*;
import com.staf.enums.PropertyFileEnums;
import com.staf.util.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Objects;
import io.github.bonigarcia.wdm.WebDriverManager;

import static com.staf.util.PropertyUtils.readPropertyValue;

/**
 * Created by Saimanikandan V on 03-04-2021
 */
public final class DriverHelper {

    private DriverHelper(){

    }


    public static void initDriver(String browser) throws Exception {
        if(Objects.isNull(DriverManager.getWebDriver()))
        {
            if(browser.equalsIgnoreCase("chrome"))
            {
//                System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
                WebDriverManager.chromedriver().setup();
                DriverManager.setWebDriver(new ChromeDriver());
                DriverManager.getWebDriver().manage().window().maximize();
                DriverManager.getWebDriver().get(PropertyUtils.readPropertyValue(PropertyFileEnums.URL.name().toLowerCase()));
            }
            else if(browser.equalsIgnoreCase("firefox"))
            {
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setWebDriver(new FirefoxDriver());
                DriverManager.getWebDriver().manage().window().maximize();
                DriverManager.getWebDriver().get(PropertyUtils.readPropertyValue(PropertyFileEnums.URL.name().toLowerCase()));
            }
            else
            {
                throw new Exception("Invalid Browser name only chrome and firefox is supported as of now");
            }
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
