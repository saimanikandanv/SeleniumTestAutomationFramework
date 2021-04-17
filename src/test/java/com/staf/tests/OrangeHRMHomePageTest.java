package com.staf.tests;

import com.staf.pages.OrangeHRMApplyLeavePage;
import com.staf.pages.OrangeHRMHomePage;
import com.staf.pages.OrangeHRMLoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Saimanikandan V on 03-04-2021
 */
public final class OrangeHRMHomePageTest extends  BaseTest{

    @Test(dataProvider = "credentialProvider")
    public void applyLeave(String username, String password) throws Exception {
        OrangeHRMLoginPage loginPage=new OrangeHRMLoginPage();
        loginPage.loginApp(username, password);
        OrangeHRMHomePage homePage=new OrangeHRMHomePage();
        homePage.checkLogin();
        OrangeHRMApplyLeavePage applyLeavePage=homePage.applyLeave();
        applyLeavePage.checkApplyLeave();
        loginPage=homePage.logout();
    }

    @DataProvider(name="credentialProvider")
    public Object[][] getCredentials()
    {
        return new Object[][]{
                {"Admin","admin123"}
        };
    }

}
