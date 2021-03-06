package com.staf.tests;

import com.staf.annotations.FrameworkAnnotations;
import com.staf.enums.CategoryType;
import com.staf.listeners.RetryListener;
import com.staf.pages.OrangeHRMApplyLeavePage;
import com.staf.pages.OrangeHRMHomePage;
import com.staf.pages.OrangeHRMLoginPage;
import com.staf.util.DataProviderUtils;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by Saimanikandan V on 03-04-2021
 */
public final class OrangeHRMHomePageTest extends  BaseTest{

    @FrameworkAnnotations(authors = {"SAI"}, category = {CategoryType.REGRESSION,CategoryType.SMOKE})
    @Test
    public void applyLeave(Map<String,String> data) throws Exception {
        OrangeHRMLoginPage loginPage=new OrangeHRMLoginPage();
        loginPage.loginApp(data.get("username"), data.get("password"));
        OrangeHRMHomePage homePage=new OrangeHRMHomePage();
        homePage.checkLogin();
        OrangeHRMApplyLeavePage applyLeavePage=homePage.applyLeave();
        applyLeavePage.checkApplyLeave();
        loginPage=homePage.logout();
    }

}
