package com.demo.seleniumtest.biz;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import com.services.imp.FundRateServiceSpring;
import com.services.pojo.fund.FundRate;

public abstract class AFundSeleniumSpring implements IFundSelenium {
	
	private String browserName;	
	public String getBrowserName() {
		return browserName;
	}
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	//Sub class to set its webdriver as the browser
	WebDriver driver;	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	//injection
	FundRateServiceSpring fundRateServiceSpring;
	public void setFundRateServiceSpring(FundRateServiceSpring fundRateServiceSpring) {
		this.fundRateServiceSpring = fundRateServiceSpring;
	}

	
	
	@Override
	public void genFundRateRpt() {
		//FundRateServiceSpring=new FundRateServiceSpring();		
		FundRate fundRate=fundRateServiceSpring.getFundRateList();
		driver.get(fundRate.getFundUrl());
		System.out.println("Page title : "+ driver.getTitle());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//get the rate
		String lst1wRate;
		String lst1mRate;
		String lst3mRate;
		String lst6mRate;
		String curyearRate;
		String lst1yRate;		
			
		lst1wRate= driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]/h3")).getText();
		System.out.println("lst1wRate is "+lst1wRate);		
		lst1mRate= driver.findElement(By.xpath("//table/tbody/tr[6]/td[3]/h3")).getText();
		System.out.println("lst1mRate is "+lst1mRate);		
		lst3mRate= driver.findElement(By.xpath("//table/tbody/tr[6]/td[4]/h3")).getText();
		System.out.println("lst3mRate is "+lst3mRate);
		lst6mRate= driver.findElement(By.xpath("//table/tbody/tr[6]/td[5]/h3")).getText();
		System.out.println("lst6mRate is "+lst6mRate);
		curyearRate= driver.findElement(By.xpath("//table/tbody/tr[6]/td[6]/h3")).getText();
		System.out.println("curyearRate is "+curyearRate);
		lst1yRate= driver.findElement(By.xpath("//table/tbody/tr[6]/td[7]/h3")).getText();
		System.out.println("lst1yRate is "+lst1yRate);
		
		//close driver
		driver.quit();

	}
}
