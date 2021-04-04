package com.staf.util;

import com.staf.driver.DriverManager;
import com.staf.enums.ExplicitWaitConditions;
import com.staf.enums.PropertyFileEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Saimanikandan V on 05-04-2021
 */
public class SeleniumFactories {

    private SeleniumFactories() {
    }

    public static WebElement performExplicitWait(ExplicitWaitConditions waitconditions, By byElement) throws Exception {
        WebDriverWait wait=new WebDriverWait(DriverManager.getWebDriver(),Integer.parseInt(Utils.readPropertyValue(PropertyFileEnums.EXPLICITWAITTIME.name().toLowerCase())));
        WebElement element=null;
        switch (waitconditions){
            case ELEMENTTOBECLICKABLE:
                element=wait.until(ExpectedConditions.elementToBeClickable(DriverManager.getWebDriver().findElement(byElement)));
                break;
            case VISIBILITYOFELEMENT:
                element=wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
                break;
            case NONE:
                element=DriverManager.getWebDriver().findElement(byElement);
                break;
        }
        return element;
    }



}
