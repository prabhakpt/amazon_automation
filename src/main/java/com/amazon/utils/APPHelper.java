package com.amazon.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.amazon.constants.PropertyConstants;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class APPHelper {
	
	private static final Logger LOG = Logger.getLogger(APPHelper.class);
	
    private AppiumDriver<MobileElement> driver;
    DeviceActionUtils deviceActionUtils;
    boolean isLandscape=false;
    
    public APPHelper(AppiumDriver<MobileElement> driver) {
    	LOG.info("Intatiating appium driver");
        this.driver = driver;
        deviceActionUtils = new DeviceActionUtils(this.driver);
        deviceActionUtils.setScreenOrientation(ReadPropertiesFile.GetProperty(PropertyConstants.ANDROID_ORIENTATION_MODE));
        isLandscape = deviceActionUtils.isLandscape;
    }
    
    public void isElementEnabled(String identifier, String locator) {
    	MobileElement element = getMobileElement(identifier,locator);
    	AssertHelper.assertNotNull(element);
    	AssertHelper.assertTrue(element.isEnabled());   	
    }
    
    public boolean isElementDisplayed(String identifier, String locator) {
    	boolean isElementEnabled = false;
    	try {
    		waitForElement(identifier, locator);
    		isElementEnabled =getMobileElement(identifier, locator).isDisplayed();
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	
    	return isElementEnabled;
    	
    }
    
    public MobileElement getMobileElement(String identifier, String locator) {
    	
    	MobileElement mobileElement = null;
    	waitForElement(identifier, locator);
    	switch(Identifier.valueOf(identifier)) {
    	case id: 	mobileElement = driver.findElementById(locator);
    				break;
    	case css: 	mobileElement = driver.findElementByClassName(locator);
					break;
    	case xpath:	mobileElement = driver.findElementByXPath(locator);
    				break;
    	case name:	mobileElement = driver.findElementByName(locator);
					break;
    	default:LOG.info("No locator is matching in Switch statemet");
    		break;
    	}
    	return mobileElement;
    }
    
    public List<MobileElement> getMobileElements(String identifier, String locator) {
    	
    	List<MobileElement> mobileElements = null;
    	switch(Identifier.valueOf(identifier)) {
    		case id:	LOG.info("Getting list of objects from ID");
	    				mobileElements = driver.findElementsById(locator);
	    				break;
    		case css: 	mobileElements = driver.findElementsByClassName(locator);
						break;
    		case xpath: LOG.info("Getting list of objects from xpath"+locator);
    					mobileElements= driver.findElementsByXPath(locator);
    					break;
    		case name:	mobileElements = driver.findElementsByName(locator);
						break;
    		default: LOG.info("Identifier is not valid");
    				break;
    	}
    	LOG.info("Size of xpath objects list"+ mobileElements.size());
    	return mobileElements;
    }
    
    // Before each click, we are taking screen shots
    public void clickByElement(String identifier, String locator) {
    	captureScreenShots();
    	scrollTillElementAppearsInLandscape(identifier,locator);
    	MobileElement element = getMobileElement(identifier, locator);
    	AssertHelper.assertNotNull(element);
    	element.click();
    }
    
    public void clickWithoutScroll(String identifier, String locator) {
    	MobileElement element = getMobileElement(identifier, locator);
    	AssertHelper.assertNotNull(element);
    	element.click();
    }
    
    public void captureScreenShots(){
        String folder_name="screenshot";
        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat df=new  SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        new File(folder_name).mkdir();
        String file_name=df.format(new Date())+".png";
        try {
			FileUtils.copyFile(f, new File(folder_name + "/" + file_name));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void enterTextByElement(String identifier, String locator,String text) {
    	getMobileElement(identifier, locator).click();
		getMobileElement(identifier, locator).sendKeys(text);
		deviceActionUtils.closeKeyPad();
	}
    
    public void enterTextWithKeyPad(String identifier, String locator,String text) {
		getMobileElement(identifier, locator).sendKeys(text);
	}
    
    public void verifySizeofSearResults(String identifier, String locator) {
    	List<MobileElement> mobileElements = getMobileElements(identifier,locator);
    	Assert.assertTrue(mobileElements.size()>=1);
    }
    
    public String getTextByLocator(String identifier, String locator) {
    	LOG.info("Getting text by locator"+ locator);
    	String result = null;
    	if(getMobileElements(identifier,locator).size()>0) {
    		result = getMobileElement(identifier, locator).getText();
    	}
    	LOG.info("Locator text value:"+result);
    	return result;
    }
       
    public void selectProductByName(String identifier, String locator,String productName) {
    	
    	MobileElement element = getMobileElement(identifier, locator);
    	List<MobileElement> elements = element.findElementsByXPath("//android.view.View");
    	
    	LOG.info("Size fo products list in products page::"+elements.size());
    	
    	for(MobileElement eachElement:elements) {
    		System.out.println("product name: "+eachElement.getText());
    		if(eachElement.getText().contains(productName)) {
    			eachElement.click();
    			break;
    		}
    		deviceActionUtils.verticalSwipeByPercentages(0.3, 0.3, 0.2);
    	}
    } 
    
    public void scrollByOrientation(MobileElement element) {
    	if(isLandscape) {
    		deviceActionUtils.scrollToElement(element);
    	}
    }
    
    public void waitForElement(String identifier, String locator) {
    	int waitTime=15;
    	if(isLandscape || (ReadPropertiesFile.GetProperty(PropertyConstants.EXECUTION_ENVIRONMENT).equals("emulator")))
    	{
    		System.out.println("Waiting for element by 100 seconds"); 
    		waitTime = 100;
    	}    
	    
	    By by = null;
	    switch(Identifier.valueOf(identifier)) {
	    	case id: 	by = By.id(locator);
	    				break;
	    	case css: 	by = By.cssSelector(locator);
						break;
	    	case xpath:	by = By.xpath(locator);
	    				break;
	    	case name:	by = By.name(locator);
						break;
	    	default:	LOG.info("No locator is matching in Switch statemet");
	    				break;
    	}
	    
	    Wait wait = new FluentWait(driver)
	            .withTimeout(waitTime, TimeUnit.SECONDS)
	            .pollingEvery(250, TimeUnit.MILLISECONDS)
	            .ignoring(NoSuchElementException.class)
	            .ignoring(TimeoutException.class);
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }    
    
    public boolean isLocatorDisplayed(String identifier, String locator) {
    	 By by = null;
 	    switch(Identifier.valueOf(identifier)) {
 	    	case id: 	by = By.id(locator);
 	    				break;
 	    	case css: 	by = By.cssSelector(locator);
 						break;
 	    	case xpath:	by = By.xpath(locator);
 	    				break;
 	    	case name:	by = By.name(locator);
						break;
 	    	case linkText: by = By.name(locator);
 	    				break;
 	    	default:	LOG.info("No locator is matching in Switch statemet");
 	    				break;
     	}
 	    
 	    boolean locatorDispalyed = false;
 	    try {
 	    	locatorDispalyed = driver.findElement(by).isDisplayed();
 	    }catch (Exception ex) {
 	    	LOG.info("Exception occured while verifying locator");
			locatorDispalyed = false;
		}
 	    return locatorDispalyed;
 	    
    }
    
    public void scrollTillElementAppearsInLandscape(String identifier, String locator) {
    	if(isLandscape) {
	    	for(int i=0;i<10;i++) {
	    	if(isLocatorDisplayed(identifier,locator))
	    		deviceActionUtils.verticalSwipeByPercentages(0.5, 0.3, 0.4);
	    	}
    	}
    }
    
    public void scrollToElement(String identifier, String locator) {
	    	for(int i=0;i<10;i++) {
	    	if(isLocatorDisplayed(identifier,locator))
	    		deviceActionUtils.verticalSwipeByPercentages(0.5, 0.3, 0.2);
    	}
    }
    
    public void scrolltoElementAndClick(String identifier, String locator) {
    	for(int i=1;i<20;i++) {
	    	if(!isLocatorDisplayed(identifier,locator)) {
	    		System.out.println("Locaor is not displayed scrolling vertically");
	    		deviceActionUtils.verticalSwipeByPercentages(0.5, 0.3, 0.3);
	    	}else {
	    		System.out.println("Locator displaye");
	    		getMobileElement(identifier, locator).click();
	    		break;
	    	}
    	}
    }
    
    public void scrollDowntoXPath(String xPath) {
    	System.out.println("Starated executing the scroll down element");
        boolean flag=true;
        int count=1;
        while(flag){
            try {
                driver.findElement(By.xpath(xPath));
                flag=false;
                break;
            }
            catch(Exception NoSuchElementException) {
                count=count+1;
                Map<String, Object> params = new HashMap<>();
                params.put("start","40%,90%");
                params.put("end","40%,20%");
                params.put("duration","2");
                Object res= driver.executeScript("mobile:touch:swipe",params);
            if(count==5)
            {
                break;
            }
            }
        }
    }
    
    
}
