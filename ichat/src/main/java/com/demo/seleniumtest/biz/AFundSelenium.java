package com.demo.seleniumtest.biz;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import com.services.imp.FundRateService;
import com.services.pojo.other.FundRate;

public abstract class AFundSelenium implements IFundSelenium {
	
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
	FundRateService fundRateService;
	public void setFundRateService(FundRateService fundRateService) {
		this.fundRateService = fundRateService;
	}
	//without injection, need call this function in sub class' construct method
	public void initial(){		
		fundRateService=new FundRateService();
	}
	
	
	@Override
	public void insertFundRateRpt() {
		//fundRateService=new FundRateService();		
		FundRate fundRate=fundRateService.getFundRateList();
		String fundUrl=fundRate.getFund().getFundUrl();
		try{
			//driver.get("http://www.baidu.com");
			driver.get("http://fund.eastmoney.com/001781.html");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Page title : "+ driver.getTitle());
			
			//
			System.out.println(fundUrl);
			driver.get(fundUrl);
		}catch(Exception ex){
			ex.printStackTrace();
		}
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
