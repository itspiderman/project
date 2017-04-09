package com.services.imp;

import com.services.IFundRateRptService;
import com.services.pojo.fund.FundRateRpt;

public class FundRateRptServiceRunnable implements Runnable {
	/* usage sample:
	FundRateRptServiceRunnable fundRateRptServiceRunnable=(FundRateRptServiceRunnable)SpringContextUtils.getBean("fundRateRptServiceRunnable");
	public void insertFundRateRpt(FundRateRpt fdRpt){		
		fundRateRptServiceRunnable.setFundRateRpt(fdRpt);
		Thread th=new Thread(fundRateRptServiceRunnable);
		th.start();		
	}	
	 */
	FundRateRpt fundRateRpt;	
	public void setFundRateRpt(FundRateRpt fundRateRpt) {
		this.fundRateRpt = fundRateRpt;
	}
	@Override
	public void run(){
		synRun();
	}
	//Synchronized是Java并发编程中最常用的用于保证线程安全的方式
	synchronized void synRun(){		
		fundRateRptService.insertFundRateRpt(fundRateRpt);
	}

	//injection
	IFundRateRptService fundRateRptService;
	public void setFundRateRptService(IFundRateRptService fundRateRptService) {
		this.fundRateRptService = fundRateRptService;
	}
	

}
