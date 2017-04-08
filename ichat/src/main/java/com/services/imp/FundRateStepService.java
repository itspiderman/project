package com.services.imp;

import java.util.List;

import com.services.IFundRateStepService;
import com.services.dao.IFundRateStepDao;
import com.services.dao.imp.FundRateStepDao;
import com.services.pojo.fund.FundRateStep;

public class FundRateStepService implements IFundRateStepService {
	FundRateStep fundRateStep;

	public FundRateStep getFundRateStep() {
		return fundRateStep;
	}

	public void setFundRateStep(FundRateStep fundRateStep) {
		this.fundRateStep = fundRateStep;
	}
	
	@Override
	public List<FundRateStep> queryFundRateStepList() {
		List<FundRateStep> ls=fundRateStepDao.queryFundRateStep();
		// TODO Auto-generated method stub
		return ls;
	}	
	
	//injection
	IFundRateStepDao fundRateStepDao;
	public void setFundRateStepDao(IFundRateStepDao fundRateStepDao) {
		this.fundRateStepDao = fundRateStepDao;
	}
	//Without injection,use construct function
	FundRateStepService(){
		fundRateStepDao=new FundRateStepDao();
	}
}
