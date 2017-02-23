package com.androidautomationproject.util;

import java.io.File;


import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/*
 * @Noor Mohammad Shiblee
 * all necessary data is handled here before start the execution.
 */
public class PropertySettings {
	
	public AppiumDriver<WebElement> driver = null;


	private String testngxml = null;
	private String udid = null;
	private String deviceName = null;
	private String appApk = null;
	
	/** 
	 * construct setting information
	 **/
	public PropertySettings()
	{
		Properties prop = null;
		try{
			
            prop = new Properties();
            
            //get setting.conf
            prop.load(new FileInputStream(AppConstant.SETTING_PATH));
          
            this.testngxml = prop.getProperty("testngxml");
            this.udid = prop.getProperty("udid");
            this.deviceName = prop.getProperty("deviceName");
            this.appApk = prop.getProperty("appApk");
            
		}catch (Exception e) {           
           System.out.println(e.getMessage());
           e.printStackTrace();
	    }
	}
	

	/** returns web driver 
	 * @throws MalformedURLException */
	public AppiumDriver<WebElement> getDriver() throws MalformedURLException
	{	
		if (this.driver == null) {
			setDriver();
		}
		
		return this.driver;
	}
	
	
	/** set the driver 
	 * @throws MalformedURLException */
	public void setDriver() throws MalformedURLException
	{	
		
		AppiumDriver<WebElement> driver = null;
		
		File appDir = new File(AppConstant.RESOURCE_DIR);
		File app = new File(appDir, this.appApk);
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName",getDeviceName());
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("udid",getUdid());
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("app-package", "com.CultureAlley.japanese.english"); //Replace with your app's package
	    capabilities.setCapability("app-activity", ".MainActivity"); //Replace with app's Activity
		// add caps according to project purpose.
		
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    this.driver = driver;
	}
	
	/** set null to driver */
	public void setDriverEmpty(){
		this.driver = null;
	}
	
	/**
	 * @return the testngxml
	 */
	public String getTestngxml() {
		return testngxml;
	}

	/**
	 * @param testngxml to set
	 */
	public void setTestngxml(String testngxml) {
		this.testngxml = testngxml;
	}


	/**
	 * @return the udid
	 */
	public String getUdid() {
		return udid;
	}

	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}	
}
