package com.staf.tests;

import com.staf.driver.DriverHelper;
import com.staf.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.Objects;

/**
 * Created by Saimanikandan V on 03-04-2021
 */
public final class HomePageTest extends BaseTest{

    private HomePageTest()
    {
    }

    @Test
    public void searchTest1()
    {
        DriverManager.getWebDriver().findElement(By.name("q")).sendKeys("Java Tutorial", Keys.ENTER);
        String title=DriverManager.getWebDriver().getTitle();
        Assert.assertTrue(Objects.nonNull(title));
        Assert.assertTrue(title.toLowerCase().contains("google search"));
    }

    @Test
    public void searchTest2()
    {
        DriverManager.getWebDriver().findElement(By.name("q")).sendKeys("Selenium Tutorial", Keys.ENTER);
    }
}
