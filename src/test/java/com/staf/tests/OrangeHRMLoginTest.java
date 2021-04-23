package com.staf.tests;

import com.staf.annotations.FrameworkAnnotations;
import com.staf.enums.CategoryType;
import com.staf.listeners.RetryListener;
import com.staf.pages.OrangeHRMHomePage;
import com.staf.pages.OrangeHRMLoginPage;
import com.staf.util.DataProviderUtils;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by Saimanikandan V on 03-04-2021
 */
public final class OrangeHRMLoginTest extends  BaseTest{

    @FrameworkAnnotations(authors = {"SAI"}, category = {CategoryType.SMOKE,CategoryType.REGRESSION})
    @Test
    public void loginTest(Map<String,String> data)throws Exception {
        OrangeHRMLoginPage loginPage=new OrangeHRMLoginPage();
        loginPage.loginApp(data.get("username"), data.get("password"));
        OrangeHRMHomePage homePage=new OrangeHRMHomePage();
        homePage.checkLogin();
        loginPage=homePage.logout();
    }


}
