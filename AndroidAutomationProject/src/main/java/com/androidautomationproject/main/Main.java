package com.androidautomationproject.main;

import com.androidautomationproject.util.PropertySettings;
import com.androidautomationproject.util.TestStarter;

/*
 * this is the main class to run the automation test.
 */
public class Main {
	
	public static void main(String args[]){
		
		System.out.println("Main automation project starts.");
		
		//get all necessary data from PropertySettings and get ready for start test.
		PropertySettings setting = new PropertySettings();
		
		//Test Execution Start
		TestStarter ts = new TestStarter(setting);
		ts.startTest();
	}
}
