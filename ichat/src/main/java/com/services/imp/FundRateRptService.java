package com.services.imp;

import java.util.List;

import com.services.IFundRateRptService;
import com.services.dao.IFundRateRptDao;
import com.services.pojo.fund.FundRateRpt;

public class FundRateRptService implements IFundRateRptService {

	@Override
	public void insertFundRateRpt(FundRateRpt fundRateRpt) {
		fundRateRptDao.insertFundRateRpt(fundRateRpt);
	}
	@Override
	public void insertFundRateRptThread(FundRateRpt fundRateRpt) {
		runInsertFundRateRptThread(fundRateRpt);
	}

	@Override
	public void insertFundRateRpt(List<FundRateRpt> ls) {
		// TODO Auto-generated method stub

	}

	@Override
	public void genFundRateRptByFundCode(String fundCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void genFundRateRpt() {
		// TODO Auto-generated method stub
		
	}
	private void runInsertFundRateRptThread(FundRateRpt fundRateRpt){
		FundRateRptServiceRunnable fundRateRptServiceRunnable=new FundRateRptServiceRunnable();
		fundRateRptServiceRunnable.setFundRateRptDao(fundRateRptDao);
		fundRateRptServiceRunnable.setFundRateRpt(fundRateRpt);
		Thread th=new Thread(fundRateRptServiceRunnable);
		th.start();	
	}
	
	//injection
	IFundRateRptDao fundRateRptDao;
	public void setFundRateRptDao(IFundRateRptDao fundRateRptDao) {
		this.fundRateRptDao = fundRateRptDao;
	}
}
