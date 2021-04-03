package com.staf.driver;

import org.openqa.selenium.WebDriver;

/**
 * Created by Saimanikandan V on 03-04-2021
 */
public final class DriverManager {

    private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();

    private DriverManager(){

    }


    public static WebDriver getWebDriver() {
        return driver.get();
    }

    public static void setWebDriver(WebDriver driverRef) {
        driver.set(driverRef);
    }

    public static void unloadWebDriver(){
        driver.remove();
    }
}
