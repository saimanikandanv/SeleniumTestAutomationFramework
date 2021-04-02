package com.staf.tests;

import com.staf.driver.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

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
        DriverHelper.driver.findElement(By.name("q")).sendKeys("Java Tutorial", Keys.ENTER);
    }

    @Test
    public void searchTest2()
    {
        DriverHelper.driver.findElement(By.name("q")).sendKeys("Selenium Tutorial", Keys.ENTER);
    }
}
