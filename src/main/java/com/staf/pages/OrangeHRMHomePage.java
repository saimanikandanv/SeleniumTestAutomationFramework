package com.staf.pages;

import com.staf.driver.DriverManager;
import com.staf.enums.ExplicitWaitConditions;
import com.staf.reports.ExtentLogger;
import com.staf.util.SeleniumFactories;
import org.openqa.selenium.By;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Saimanikandan V on 04-04-2021
 */
public class OrangeHRMHomePage extends BasePage{

    private static final By homePageTitle=By.xpath("//ul[@id='mainMenuFirstLevelUnorderedList']");
    private static final By welcomeLink=By.id("welcome");
    private static final By linkLogOut=By.xpath("//a[text()='Logout']");
    private static final By linkApplyleave=By.xpath("//span[contains(text(),'Apply Leave')]//parent::a");

    public OrangeHRMHomePage checkLogin() throws InterruptedException {
        Thread.sleep(5000);
        if(DriverManager.getWebDriver().findElement(homePageTitle).isDisplayed()){
            ExtentLogger.passWithScreen("Login Success");
        }
        return this;
    }

    public OrangeHRMLoginPage logout() throws Exception {
        SeleniumFactories.performExplicitWait(ExplicitWaitConditions.ELEMENTTOBECLICKABLE,welcomeLink);
        click(welcomeLink,"Welcome Link");
        click(linkLogOut, "Logout");
        Thread.sleep(2000);
        return new OrangeHRMLoginPage();
    }

    public OrangeHRMApplyLeavePage applyLeave() throws Exception {
        SeleniumFactories.performExplicitWait(ExplicitWaitConditions.ELEMENTTOBECLICKABLE,linkApplyleave);
        click(linkApplyleave,"Apply Leave");
        return new OrangeHRMApplyLeavePage();
    }
}
