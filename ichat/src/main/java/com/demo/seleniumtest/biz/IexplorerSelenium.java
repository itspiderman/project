package com.demo.seleniumtest.biz;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class IexplorerSelenium extends AFundSelenium  {
	
	IexplorerSelenium(){
		this.setBrowserName("Internet Explorer");
		super.setDriver(new InternetExplorerDriver());
	}

//	@Override
//	public void genFundRateRpt() {
//		// TODO Auto-generated method stub
//
//	}

}
