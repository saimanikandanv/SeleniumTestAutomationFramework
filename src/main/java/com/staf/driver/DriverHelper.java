package com.staf.driver;

import com.staf.constants.*;
import com.staf.enums.PropertyFileEnums;
import com.staf.util.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URL;
import java.util.Objects;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.staf.util.PropertyUtils.readPropertyValue;

/**
 * Created by Saimanikandan V on 03-04-2021
 */
public final class DriverHelper {

    private DriverHelper(){

    }


    public static void initDriver(String browser) throws Exception {
        if (Objects.isNull(DriverManager.getWebDriver())) {
            String runMode = PropertyUtils.readPropertyValue(PropertyFileEnums.RUNMODE.name().toLowerCase());
            switch(runMode)
            {
                case "remote":
                    DesiredCapabilities cap =new DesiredCapabilities();
                    ChromeOptions options=new ChromeOptions();
                    options.addArguments("--no-sandbox");
                    options.addArguments("-disable-dev-shm-usage");
                    cap.setBrowserName(BrowserType.CHROME);
                    cap.setCapability(ChromeOptions.CAPABILITY,options);
                    DriverManager.setWebDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap));
                    DriverManager.getWebDriver().manage().window().maximize();
                    DriverManager.getWebDriver().get(PropertyUtils.readPropertyValue(PropertyFileEnums.URL.name().toLowerCase()));
                    break;
                case "local":
                    if(browser.equalsIgnoreCase("chrome"))
                    {
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
                        throw new RuntimeException("Invalid Browser name only chrome and firefox is supported as of now");
                    }
                    break;
                default:
                    throw new RuntimeException("Incorrect Run mode in config.properties");
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
