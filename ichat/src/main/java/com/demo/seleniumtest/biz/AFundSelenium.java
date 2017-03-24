package com.demo.seleniumtest.biz;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.services.FundRateService;
import com.services.pojo.FundRate;

public abstract class AFundSelenium implements IFundSelenium {
	
	private String browserName;	
	public String getBrowserName() {
		return browserName;
	}
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}


	//injection
	WebDriver driver;
	FundRateService fundRateService;
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public void setFundRateService(FundRateService fundRateService) {
		this.fundRateService = fundRateService;
	}
	
	@Override
	public void genFundRateRpt() {
		fundRateService=new FundRateService();
		FundRate fundRate=new FundRate();
		
		fundRate=fundRateService.getFundRate();
		//FundRate fundRate=fundRateService.getFundRate();
		String fundUrl="http://fund.eastmoney.com/001781.html";
		fundRate.setFundUrl(fundUrl);
				
		driver.get(fundRate.getFundUrl());
		System.out.println("Page title : "+ driver.getTitle());
		try {
			Thread.sleep(5000);
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
		System.out.println("lst1wRate is "+lst1mRate);		
		lst3mRate= driver.findElement(By.xpath("//table/tbody/tr[6]/td[4]/h3")).getText();
		System.out.println("lst1wRate is "+lst3mRate);
		lst6mRate= driver.findElement(By.xpath("//table/tbody/tr[6]/td[5]/h3")).getText();
		System.out.println("lst1wRate is "+lst6mRate);
		curyearRate= driver.findElement(By.xpath("//table/tbody/tr[6]/td[6]/h3")).getText();
		System.out.println("lst1wRate is "+curyearRate);
		lst1yRate= driver.findElement(By.xpath("//table/tbody/tr[6]/td[7]/h3")).getText();
		System.out.println("lst1wRate is "+lst1yRate);
		
		//close driver
		driver.quit();

	}
}
