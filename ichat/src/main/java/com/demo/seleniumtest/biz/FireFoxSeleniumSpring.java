package com.demo.seleniumtest.biz;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxSeleniumSpring extends AFundSeleniumSpring  {
	
	FireFoxSeleniumSpring(){
		this.setBrowserName("FireFox");		
		System.setProperty("webdriver.firefox.marionette", "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");		
		super.setDriver(new FirefoxDriver());	
		//this.set
	}

//	@Override
//	public void getFundRate() {
//		// TODO Auto-generated method stub		
//	}

}
