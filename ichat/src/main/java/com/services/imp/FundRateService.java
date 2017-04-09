package com.services.imp;

import java.util.List;

import com.services.dao.IFundDao;
import com.services.dao.IFundRateStepDao;
import com.services.dao.imp.FundDao;
import com.services.dao.imp.FundRateStepDao;
import com.services.pojo.fund.Fund;
import com.services.pojo.fund.FundRate;
import com.services.pojo.fund.FundRateStep;


public class FundRateService {	

	public FundRate getFundRateList() {
		FundRate fundRate=new FundRate();
		
		Fund fund =fundDao.queryByFundCode("");
		fundRate.setFund(fund);
		
		List<FundRateStep> stepList=fundRateStepDao.queryFundRateStepByFundCode("");		
		fundRate.setSteps(stepList);
		
		return fundRate;
	}

	//injection
	private IFundDao fundDao;
	private IFundRateStepDao fundRateStepDao;
	public void setFundRateDao(IFundDao fundDao) {
		this.fundDao = fundDao;
	}
	public void setFundRateStepDao(IFundRateStepDao fundRateStepDao) {
		this.fundRateStepDao = fundRateStepDao;
	}
	//Without injection,before call this class's function in biz layer, need call this construct function to instance this class.
	public FundRateService(){
		fundDao=new FundDao();
		fundRateStepDao=new FundRateStepDao();		
	}
}
