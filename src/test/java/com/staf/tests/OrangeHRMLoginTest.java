package com.staf.tests;

import com.staf.driver.DriverHelper;
import com.staf.driver.DriverManager;
import com.staf.enums.PropertyFileEnums;
import com.staf.pages.OrangeHRMHomePage;
import com.staf.pages.OrangeHRMLoginPage;
import com.staf.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.staf.pages.OrangeHRMLoginPage;
import java.util.Locale;
import java.util.Objects;

/**
 * Created by Saimanikandan V on 03-04-2021
 */
public final class OrangeHRMLoginTest extends BaseTest{

    @Test
    public void loginTest() throws Exception {
        OrangeHRMLoginPage loginPage=new OrangeHRMLoginPage();
        loginPage.loginApp(Utils.readPropertyValue(PropertyFileEnums.USERNAME.name().toLowerCase()),Utils.readPropertyValue(PropertyFileEnums.PASSWORD.name().toLowerCase()));
    }

}
