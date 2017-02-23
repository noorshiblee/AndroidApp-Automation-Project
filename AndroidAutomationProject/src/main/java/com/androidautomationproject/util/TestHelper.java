package com.androidautomationproject.util;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.gargoylesoftware.htmlunit.javascript.host.media.rtc.webkitRTCPeerConnection;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

/*
 * add all helper function here.
 */
public class TestHelper {
	
	public AppiumDriver<WebElement> driver = null;
	protected PropertySettings settings = null;


	/**
	 * this method is responsible to setDriver for all Test suites
	 * @param ITestContext
	 * @throws MalformedURLException 
	 */
	@BeforeTest
	public void testBeforeTest(ITestContext ctx) throws MalformedURLException {
		
		if (settings == null) {
			settings = (PropertySettings)ctx.getAttribute("setting");
		}
		
		String testingClass = ctx.getCurrentXmlTest().getXmlClasses().get(0).toString(); 
	
		if (driver == null) {
		driver = settings.getDriver();
	}
		
	}
	
	/**
	 * quit the driver
	 */
	@AfterTest
	protected void quitDriver(){
	  driver.quit();
	  driver = null;
	  settings.setDriverEmpty();
	}
	
	/*
	 * enter text to text field
	 */
	protected void enterText(WebElement elem, String text){
		
		elem.click();
		elem.clear();
		elem.sendKeys(text);
	}
	
	/**
	 * wait until expected element is visible
	 *
	 * @param	elemLocator			element locator
	 * @param	timeout				Maximum timeout time in second
	 */
	protected void waitForElement(By elemLocator, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(elemLocator));
		} catch (Exception e) {
			System.out.println("problem in waitForElement, check element is valid and visible within the time or not");
		}
	}
	
	
	/**
	 * wait until Invisibility of element is completed
	 *
	 * @param	elemLocator	element Locator
	 * @param	timeout		Maximum timeout time in second
	 */
	protected void waitForElemInvisibility(By elemLocator, int timeout){
		try{
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(elemLocator));
		}catch(Exception e){
			System.out.println("problem in waitForElemInvisibility function");
		}
	}
	
	/**
	 * swipe page from top to bottom
	 */
	public void swipeTopToBottom(){
		
		try{
			
			Dimension size = driver.manage().window().getSize(); 
			int starty = (int) (size.height * 0.80);  
			int startx = size.width / 2; 
			int endy = (int) (size.height * 0.20);
			
			//Swipe from Top to Bottom. 
			driver.swipe(startx, starty, startx, endy, 800);
		}
		catch(Exception e){
			System.out.println("problem in swipeTopToBottom function");
		}
		
	}
	
	/**
	 * swipe page from bottom to top
	 */
	public void swipeBottomToTop(){
		
		try{
			
			Dimension size = driver.manage().window().getSize(); 
			int starty = (int) (size.height * 0.80);  
			int startx = size.width / 2; 
			int endy = (int) (size.height * 0.20);
			
			//Swipe from Bottom to Top. 
			 driver.swipe(startx, endy, startx, starty, 800);
		}
		catch(Exception e){
			System.out.println("problem in swipeBottomToTop function");
		}
		
	}
	
	/**
	 * drag and drop an element
	 * @param	elemOne - element which will be dragged
	 * @param	elemTwo	- where elemOne will be dropped
	 */
	public void dragAndDropElement(WebElement elemOne, WebElement elemTwo){
	
		try{
			
			TouchAction action = new TouchAction(driver);
			action.longPress(elemOne).waitAction(3000).moveTo(elemTwo).perform().release();
		}
		catch(Exception e){
			System.out.println("problem in dragAndDropElement function");
		}
		
	}
	
	/**
	 * go to back screen by click on device back button.
	 */
	public void navigateBack(){
	
		try{
			driver.navigate().back();	
		}
		catch(Exception e){
			System.out.println("problem in navigateBack function");
		}
	}
	
	/**
	 * Swipe Page right to left
	 */
	protected void swipePageRightToLeft() {
		try {
			Dimension size = driver.manage().window().getSize(); 
		    int startx = (int) (size.width * 0.8); 
		    int endx = (int) (size.width * 0.20); 
		    int starty = size.height / 2; 
		    driver.swipe(startx, starty, endx, starty, 1000);
		} catch (Exception e) {
			System.out.println("problem in Swipe Page right to left");
		}
	}
	
	/**
	 * Swipe Page left to right
	 */
	protected void swipePageLeftToRight() {
		try {
			Dimension size = driver.manage().window().getSize(); 
		    int endx = (int) (size.width * 0.8); 
		    int startx = (int) (size.width * 0.20); 
		    int starty = size.height / 2; 
		    driver.swipe(startx, starty, endx, starty, 1000);
		    
		} catch (Exception e) {
			System.out.println("problem in Swipe Page left to right");
		}
	}
	
}
