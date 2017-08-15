package com.services.imp;

import java.util.List;

import com.services.IFundRateService;
import com.services.dao.IFundRateDao;
import com.services.pojo.other.FundRate;

public class FundRateServiceSpring implements IFundRateService{
	
	public FundRate getFundRateByFundCode(String fundCode) {
		return fundRateDao.getFundRateByFundCode(fundCode);
	}	
	
	public List<FundRate> getFundRateList(){
		return fundRateDao.getFundRate();
	}

	//injection
	private IFundRateDao fundRateDao;	
	public void setFundRateDao(IFundRateDao fundRateDao) {
		this.fundRateDao = fundRateDao;
	}
}
