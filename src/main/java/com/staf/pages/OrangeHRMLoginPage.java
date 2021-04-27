package com.staf.pages;

import com.staf.enums.ExplicitWaitConditions;
import com.staf.util.SeleniumFactories;
import org.openqa.selenium.By;

/**
 * Created by Saimanikandan V on 04-04-2021
 */
public class OrangeHRMLoginPage extends BasePage {

    private static final By txtUserName=By.id("txtUsername");
    private static final By txtPassword=By.id("txtPassword");
    private static final By btnLogin=By.id("btnLogin");


    public OrangeHRMHomePage loginApp(String username, String password) throws Exception {
        SeleniumFactories.performExplicitWait(ExplicitWaitConditions.ELEMENTTOBECLICKABLE,txtUserName);
        sendKeys(txtUserName,"username",username);
        sendKeys(txtPassword,"password", password);
        click(btnLogin,"Login");
        Thread.sleep(3000);
        return new OrangeHRMHomePage();
    }



}
