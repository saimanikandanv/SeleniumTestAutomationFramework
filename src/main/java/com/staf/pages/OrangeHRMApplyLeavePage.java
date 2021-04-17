package com.staf.pages;

import com.staf.driver.DriverManager;
import com.staf.reports.ExtentLogger;
import org.openqa.selenium.By;

/**
 * Created by Saimanikandan V on 17-04-2021
 */
public class OrangeHRMApplyLeavePage {

    private static final By applyLeaveSection= By.xpath("//div[@id='apply-leave']");

    public OrangeHRMApplyLeavePage checkApplyLeave()
    {
        if(DriverManager.getWebDriver().findElement(applyLeaveSection).isDisplayed())
        {
            ExtentLogger.passWithScreen("Landed on Apply Leave Section");
        }
        return this;
    }

}
