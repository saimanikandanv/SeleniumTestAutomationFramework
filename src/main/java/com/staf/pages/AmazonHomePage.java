package com.staf.pages;

import com.staf.enums.ExplicitWaitConditions;
import com.staf.util.SeleniumFactories;
import org.openqa.selenium.By;

public class AmazonHomePage extends BasePage {


	private static final By lnkHamburgerMenu= By.xpath("//a[@id='nav-hamburger-menu");
	private static final By txtSearch= By.xpath("//input[@id='twotabsearchtextbox']");
	private static final By btnSearch= By.xpath("//input[@id='nav-search-submit-button']");


//	public void loginApp(String uname, String pass) throws Exception {
//		SeleniumFactories.performExplicitWait(ExplicitWaitConditions.ELEMENTTOBECLICKABLE,txtUserName);
//		sendKeys(txtUserName,"Username",uname);
//		sendKeys(txtPassword,"Password",pass);
//		click(btnLogin,"Login");
//	}
	public void searchProduct(String productName) throws Exception {
		SeleniumFactories.performExplicitWait(ExplicitWaitConditions.ELEMENTTOBECLICKABLE,txtSearch);
		sendKeys(txtSearch,"Search",productName);
		click(btnSearch,"Search");
	}

}