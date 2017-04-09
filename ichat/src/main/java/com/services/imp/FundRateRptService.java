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
	
	//injection
	IFundRateRptDao fundRateRptDao;
	public void setFundRateRptDao(IFundRateRptDao fundRateRptDao) {
		this.fundRateRptDao = fundRateRptDao;
	}
	

}
