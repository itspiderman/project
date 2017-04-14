package com.demo.seleniumtest.biz;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import com.demo.util.SpringContextUtils;
import com.services.IFundRateRptService;
import com.services.IFundRateService;
import com.services.IFundService;
import com.services.imp.FundRateRptServiceRunnable;
import com.services.pojo.fund.Fund;
import com.services.pojo.fund.FundRateRpt;

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

	@Override
	public void insertFundRateRpt() {
		int thCount=0;
		
		List<Fund> flist=fundService.queryFundList();
		Iterator<Fund> fit=flist.iterator();
		Fund fund=null;
		//get the rate
		String lst1wRate;
		String lst1mRate;
		String lst3mRate;
		String lst6mRate;
		String curyearRate;
		String lst1yRate;	
		
		while(fit.hasNext()){
			fund=(Fund)fit.next();
			driver.get(fund.getFundUrl());
			
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
			
			FundRateRpt frRpt=new FundRateRpt();
			frRpt.setFundCode(fund.getFundCode());
			frRpt.setLst1wRate(lst1wRate);
			frRpt.setLst1mRate(lst1mRate);
			frRpt.setLst3mRate(lst3mRate);
			frRpt.setLst6mRate(lst6mRate);
			frRpt.setCuryearRate(curyearRate);
			frRpt.setLst1yRate(lst1yRate);
			//start a new thread
			thCount++;
			insertFundRateRpt(frRpt);
			// once thread count growth every 20, sleep 3 seconds
			if((thCount%20)==0){
				try {
					System.out.println("growth every 20, sleep 3 seconds ......");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//close driver
		driver.quit();
	}
	FundRateRptServiceRunnable fundRateRptServiceRunnable=(FundRateRptServiceRunnable)SpringContextUtils.getBean("fundRateRptServiceRunnable");
	public void insertFundRateRpt(FundRateRpt fdRpt){		
		fundRateRptServiceRunnable.setFundRateRpt(fdRpt);
		Thread th=new Thread(fundRateRptServiceRunnable);
		th.start();		
	}	
	//injection
	IFundService fundService; 
	IFundRateService fundRateService;
	IFundRateRptService fundRateRptService;		
	public void setFundService(IFundService fundService) {
		this.fundService = fundService;
	}
	public void setfundRateService(IFundRateService fundRateService) {
		this.fundRateService = fundRateService;
	}	
	public void setFundRateRptService(IFundRateRptService fundRateRptService) {
		this.fundRateRptService = fundRateRptService;
	}	
}