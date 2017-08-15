package com.services.dao.imp;

import java.util.ArrayList;
import java.util.List;

import com.services.dao.IFundRateStepDao;
import com.services.pojo.fund.FundRateStep;

public class FundRateStepDao implements IFundRateStepDao {
	
	public FundRateStep getFundRateStep() {
		FundRateStep fundRateStep=new FundRateStep();
		fundRateStep.setFundCode("001781");
		fundRateStep.setSeq(1);
		fundRateStep.setControltype("textbox");
		fundRateStep.setInputValue("hsbc fund");
		fundRateStep.setAction("input");		
		return fundRateStep;
	}

	@Override
	public List<FundRateStep> queryFundRateStep() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FundRateStep> queryFundRateStepByFundCode(String fundCode) {
		List<FundRateStep> list=new ArrayList<FundRateStep>();
		
		FundRateStep fundRateStep=new FundRateStep();
		fundRateStep.setFundCode("001781");
		fundRateStep.setSeq(1);
		fundRateStep.setControltype("textbox");
		fundRateStep.setInputValue("hsbc fund");
		fundRateStep.setAction("input");
		
		FundRateStep fundRateStep2=new FundRateStep();
		fundRateStep2.setFundCode("001781");
		fundRateStep2.setSeq(2);
		fundRateStep2.setControltype("button");
		fundRateStep2.setInputValue("icbc fund");
		fundRateStep2.setAction("click");
		
		list.add(fundRateStep);
		list.add(fundRateStep2);
		
		return list;
	}
	
}
