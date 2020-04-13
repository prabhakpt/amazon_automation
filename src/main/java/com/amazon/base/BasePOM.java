package com.amazon.base;

import org.apache.log4j.Logger;

import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.OrderPlacemenPage;
import com.amazon.pages.ProductsPage;
import com.amazon.utils.APPHelper;
import com.amazon.utils.Hooks;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BasePOM {
	
	private static final Logger LOG = Logger.getLogger(BasePOM.class);
	
	HomePage homePage;
	APPHelper appiumUtils;
	LoginPage loginPage;
	ProductsPage productsPage;
	OrderPlacemenPage orderPlacemenPage;
	AndroidDriver<MobileElement> driver;
	APPHelper appHelper;
	
	public AndroidDriver<MobileElement> getDriver() {
		if(driver == null)
			driver = Hooks.getDriver();
		return driver;
	}
	
	public APPHelper appHelper() {
		if(appHelper == null)
			appHelper = new APPHelper(getDriver());
		return appHelper;
	}
	
	public HomePage homePage() {
		if(homePage == null)
			homePage = new HomePage();
		return homePage;
	}
	
	public LoginPage loginPage() {
		if(loginPage == null) 
			loginPage = new LoginPage();
		return loginPage;
	}
	
	public ProductsPage productsSearch() {
		if(productsPage == null) 
			productsPage = new ProductsPage();
		return productsPage;
	}
	
	public OrderPlacemenPage orderPlacementPage() {
		if(orderPlacemenPage==null)
			orderPlacemenPage=new OrderPlacemenPage();
		return orderPlacemenPage;
	}
}
