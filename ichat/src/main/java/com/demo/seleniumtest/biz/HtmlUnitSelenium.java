package com.demo.seleniumtest.biz;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitSelenium extends AFundSelenium  {
	
	HtmlUnitSelenium(){
		this.setBrowserName("HtmlUnit");
		super.setDriver(new HtmlUnitDriver());
		//without injection,need call initial function
		initial();
	}
}
