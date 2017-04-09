package com.services.imp;

import com.services.IFundRateRptService;
import com.services.pojo.fund.FundRateRpt;

public class FundRateRptServiceThread extends Thread {
//	public FundRateRptServiceThread(){}
	
	FundRateRpt fundRateRpt;	
	public void setFundRateRpt(FundRateRpt fundRateRpt) {
		this.fundRateRpt = fundRateRpt;
	}
	
//	public FundRateRptServiceThread(FundRateRpt fundRateRpt){
//		fundRateRptService=new FundRateRptService();
//		this.fundRateRpt=fundRateRpt;
//	}
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
