package com.demo.seleniumtest.biz;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeSelenium extends AFundSelenium {
	ChromeSelenium(){
		this.setBrowserName("Chrome");
		super.setDriver(new ChromeDriver());
	}

//	@Override
//	public void genFundRateRpt() {
//		// TODO Auto-generated method stub
//
//	}

}
