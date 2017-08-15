package com.demo.seleniumtest.biz;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.WebClient;

public class HtmlUnitSeleniumSpring extends AFundSeleniumSpring {
	private WebClient webClient;
	
	public HtmlUnitSeleniumSpring(){
		this.setBrowserName("HtmlUnit");		
		//System.setProperty("webdriver.firefox.marionette", "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");		
		super.setDriver(new HtmlUnitDriver());
	}
	@Override
	public void insertFundRateRpt() {
		try{
			
		}catch(Exception ex){
			
		}
		System.out.println("this is in HtmlUnitSeleiumSpring");
	}
}
