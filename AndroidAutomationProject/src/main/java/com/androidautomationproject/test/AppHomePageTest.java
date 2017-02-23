package com.androidautomationproject.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.androidautomationproject.util.TestHelper;
import com.androidautomationproject.locator.EnglishFromBengaliPageLocator;
import com.androidautomationproject.locator.HomePageElemLocator;

public class AppHomePageTest extends AppHomePageScenario{


	@Test
	public void test_swipeUpAndDownAppHomePage(){
					
		waitForHomePage();
		swipeTopToBottom();
		swipeBottomToTop();
		boolean isEngFromBengOptShown = driver.findElementsByXPath(HomePageElemLocator.OPTIONS_COMMON_XPATH).get(0).isDisplayed();
		Assert.assertFalse(isEngFromBengOptShown);
	}
	
	@Test
	public void test_clickEnglishFromBengaliOption(){
	
		clickEnglishFromBengaliOption();
		WebElement photoSelectionPage = driver.findElementByXPath(EnglishFromBengaliPageLocator.PROFILE_PHOTO_SELECTION_TEXT);
		boolean isPhotoSelectionPageShown = photoSelectionPage.isDisplayed();
		Assert.assertTrue(isPhotoSelectionPageShown);
		navigateBack();
	}
	
	@Test
	public void test_clickEngFromBangladeshiBengOption(){
		
		clickEnglishFromBengaliOption();
		WebElement photoSelectionPage = driver.findElementByXPath(EnglishFromBengaliPageLocator.PROFILE_PHOTO_SELECTION_TEXT);
		boolean isPhotoSelectionPageShown = photoSelectionPage.isDisplayed();
		Assert.assertTrue(isPhotoSelectionPageShown);
		navigateBack();
	}
	
	@Test
	public void test_clickEnglishFromHindiOption(){
				
		clickEnglishFromBengaliOption();
		WebElement photoSelectionPage = driver.findElementByXPath(EnglishFromBengaliPageLocator.PROFILE_PHOTO_SELECTION_TEXT);
		boolean isPhotoSelectionPageShown = photoSelectionPage.isDisplayed();
		Assert.assertTrue(isPhotoSelectionPageShown);
		navigateBack();
	}
}
