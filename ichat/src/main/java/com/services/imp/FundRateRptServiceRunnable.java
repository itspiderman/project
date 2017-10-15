package com.services.imp;

import com.services.dao.IFundRateRptDao;
import com.services.pojo.fund.FundRateRpt;

public class FundRateRptServiceRunnable implements Runnable {
	/* Thread class will not use the Injection Dependence of Spring. 
	 * usage sample:
	private void runInsertFundRateRptThread(FundRateRpt fundRateRpt){
		FundRateRptServiceRunnable fundRateRptServiceRunnable=new FundRateRptServiceRunnable();
		fundRateRptServiceRunnable.setFundRateRptDao(fundRateRptDao);
		fundRateRptServiceRunnable.setFundRateRpt(fundRateRpt);
		Thread th=new Thread(fundRateRptServiceRunnable);
		th.start();	
	}	
	 */
	String sCycleDate;	
	public void setsCycleDate(String sCycleDate) {
		this.sCycleDate = sCycleDate;
	}

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
		//fundRateRptService.insertFundRateRpt(fundRateRpt);
		fundRateRptDao.insertFundRateRpt(fundRateRpt);
	}

	//injection
	IFundRateRptDao fundRateRptDao;
	public void setFundRateRptDao(IFundRateRptDao fundRateRptDao) {
		this.fundRateRptDao = fundRateRptDao;
	}
}
