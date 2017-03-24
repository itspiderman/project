package com.services;

import com.services.pojo.FundRate;
import com.services.dao.FundRateDao;

public class FundRateService {
	FundRate fundRate;

	public FundRate getFundRate() {
		return fundRateDao.getFundRate();
	}

	public void setFundRate(FundRate fundRate) {
		this.fundRate = fundRate;
	}
	

	//injection
	private FundRateDao fundRateDao;
	public void setFundRateDao(FundRateDao fundRateDao) {
		this.fundRateDao = fundRateDao;
	}
	
	public FundRateService(){
		fundRateDao=new FundRateDao();
	}
}
