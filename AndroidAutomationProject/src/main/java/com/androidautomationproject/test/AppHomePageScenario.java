package com.androidautomationproject.test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.androidautomationproject.locator.EnglishFromBengaliPageLocator;
import com.androidautomationproject.locator.HomePageElemLocator;
import com.androidautomationproject.util.TestHelper;

public class AppHomePageScenario extends TestHelper{

	/*
	 * wait for the homepage
	 */
	public void waitForHomePage(){
		//wait for maximum three minute to complete the login manually.
		waitForElement(By.xpath(HomePageElemLocator.OPTIONS_COMMON_XPATH), 20);
	} 
	
	/*
	 * click on English From Bengali Option
	 */
	public void clickEnglishFromBengaliOption(){
		waitForHomePage();
		try{
			
			driver.findElementByXPath(HomePageElemLocator.OPTIONS_COMMON_XPATH).click();//this will click on by default first element
			waitForElement(By.xpath(EnglishFromBengaliPageLocator.PROFILE_PHOTO_SELECTION_TEXT), 5);//after click, wait for next page element
		}
		catch(Exception e){
			System.out.println("error found in clicking english from bengali option.");
		}
	}
	
	/*
	 * click on English From  Bangladeshi Bengali Option
	 */
	public void clickEngFromBangladeshiBengOption(){
		
		waitForHomePage();
		try{
			
			driver.findElementsByXPath(HomePageElemLocator.OPTIONS_COMMON_XPATH).get(1).click();//click on second option.
			waitForElement(By.xpath(EnglishFromBengaliPageLocator.PROFILE_PHOTO_SELECTION_TEXT), 5);//after click, wait for next page element
		}
		catch(Exception e){
			System.out.println("error found in clicking English From  Bangladeshi Bengali Option.");
		}
	}
	
	/*
	 * click on English From Hindi Option
	 */
	public void clickEnglishFromHindiOption(){
		
		waitForHomePage();
		try{
			
			driver.findElementsByXPath(HomePageElemLocator.OPTIONS_COMMON_XPATH).get(2).click();//click on third option
			waitForElement(By.xpath(EnglishFromBengaliPageLocator.PROFILE_PHOTO_SELECTION_TEXT), 5);//after click, wait for next page element
		}
		catch(Exception e){
			System.out.println("error found in clicking English From Hindi Option.");
		}
	}
}

