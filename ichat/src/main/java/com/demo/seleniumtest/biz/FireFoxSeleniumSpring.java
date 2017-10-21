package com.demo.seleniumtest.biz;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxSeleniumSpring extends AFundSeleniumSpring  {
	//Firefox Setup 46.0.exe
	//selenium-firefox-driver version: 3.3.1
	FireFoxSeleniumSpring(){
		this.setBrowserName("FireFox");		
		System.setProperty("webdriver.firefox.marionette", "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");		
		super.setDriver(new FirefoxDriver());
	}	
}
