package com.staf.pages;

import com.staf.driver.DriverManager;
import com.staf.enums.ExplicitWaitConditions;
import com.staf.util.SeleniumFactories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Saimanikandan V on 04-04-2021
 */
public class BasePage {

    private WebElement element;

    protected void click(By elementTobeClicked) throws Exception {
        element=SeleniumFactories.performExplicitWait(ExplicitWaitConditions.ELEMENTTOBECLICKABLE,elementTobeClicked);
        element.click();
    }

    protected void sendKeys(By elementTobeSentText, String value) throws Exception {
        if(DriverManager.getWebDriver().findElement(elementTobeSentText).isEnabled()){
            element=SeleniumFactories.performExplicitWait(ExplicitWaitConditions.VISIBILITYOFELEMENT,elementTobeSentText);
            element.sendKeys(value);
        }
        else{
            throw new Exception("Element to be sent text is not editable");
        }
    }
}
