package com.demo.seleniumtest.biz;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxSelenium extends AFundSelenium  {
	
	FireFoxSelenium(){
		this.setBrowserName("FireFox");
		
		System.setProperty("webdriver.firefox.marionette", "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");
		
		super.setDriver(new FirefoxDriver());		
	}

//	@Override
//	public void getFundRate() {
//		// TODO Auto-generated method stub		
//	}

}
