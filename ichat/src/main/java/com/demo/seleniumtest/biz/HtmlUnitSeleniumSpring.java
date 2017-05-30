package com.demo.seleniumtest.biz;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitSeleniumSpring extends AFundSeleniumSpring {
	public HtmlUnitSeleniumSpring(){
		this.setBrowserName("HtmlUnit");		
		//System.setProperty("webdriver.firefox.marionette", "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");		
		super.setDriver(new HtmlUnitDriver());
	}
	public void insertFundRateRpt() {
		System.out.println("this is in HtmlUnitSeleiumSpring");
	}
}
