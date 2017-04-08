package com.services.dao.imp;

import java.util.List;

import com.services.dao.IFundRateStepDao;
import com.services.pojo.fund.FundRateStep;

public class FundRateStepDao implements IFundRateStepDao {
	FundRateStep fundRateStep=new FundRateStep();

	public FundRateStep getFundRateStep() {
		
		fundRateStep.setFundCode("001781");
		fundRateStep.setSeq(1);
		fundRateStep.setControltype("textbox");
		fundRateStep.setInputValue("hsbc fund");
		fundRateStep.setAction("input");
		
		
		return fundRateStep;
	}

	public void setFundRateStep(FundRateStep fundRateStep) {
		this.fundRateStep = fundRateStep;
	}

	@Override
	public List<FundRateStep> queryFundRateStep() {
		// TODO Auto-generated method stub
		return null;
	}
}
