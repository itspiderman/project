package com.services.imp;

import com.services.dao.IFundRateStepDao;
import com.services.dao.imp.FundRateStepDao;
import com.services.pojo.fund.FundRateStep;

public class FundRateStepService {
	FundRateStep fundRateStep;

	public FundRateStep getFundRateStep() {
		return fundRateStep;
	}

	public void setFundRateStep(FundRateStep fundRateStep) {
		this.fundRateStep = fundRateStep;
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
