package com.staf.driver;

import com.staf.constants.*;
import com.staf.enums.PropertyFileEnums;
import com.staf.util.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Objects;

import static com.staf.util.PropertyUtils.readPropertyValue;

/**
 * Created by Saimanikandan V on 03-04-2021
 */
public final class DriverHelper {

    private DriverHelper(){

    }


    public static void initDriver() throws Exception {
        if(Objects.isNull(DriverManager.getWebDriver()))
        {
            if(readPropertyValue(PropertyFileEnums.BROWSER.name().toLowerCase()).equalsIgnoreCase("chrome"))
            {
                System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
                DriverManager.setWebDriver(new ChromeDriver());
                DriverManager.getWebDriver().manage().window().maximize();
                DriverManager.getWebDriver().get(PropertyUtils.readPropertyValue(PropertyFileEnums.URL.name().toLowerCase()));
            }
            else if(readPropertyValue(PropertyFileEnums.BROWSER.name().toLowerCase()).equalsIgnoreCase("firefox"))
            {
                    //code to open firefox
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
