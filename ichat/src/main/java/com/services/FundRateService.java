package com.services;

import java.util.ArrayList;
import java.util.List;

import com.services.dao.imp.FundDao;
import com.services.dao.imp.FundRateStepDao;
import com.services.pojo.fund.Fund;
import com.services.pojo.fund.FundRate;
import com.services.pojo.fund.FundRateStep;


public class FundRateService {
	
	FundRate fundRate;	

	public FundRate getFundRate() {
		Fund fund=new Fund();
		FundRateStep fundRateStep =new FundRateStep();
		
				
		fund=fundDao.getFund();
		setFundRate(fund);		
		
		List<FundRateStep> stepList=new ArrayList<FundRateStep>();
		fundRateStep=fundRateStepDao.getFundRateStep();
		stepList.add(fundRateStep);
		
		fundRate.setSteps(stepList);
		
		return fundRate;
	}

	public void setFundRate(FundRate fundRate) {
		this.fundRate = fundRate;
	}
	public void setFundRate(Fund fund) {
		this.fundRate.setFundCode(fund.getFundCode());
		this.fundRate.setFundName(fund.getFundName());
		this.fundRate.setFundUrl(fund.getFundUrl());
	}
	

	//injection
	private FundDao fundDao;
	private FundRateStepDao fundRateStepDao;
	public void setFundRateDao(FundDao fundDao) {
		this.fundDao = fundDao;
	}
	public void setFundRateStepDao(FundRateStepDao fundRateStepDao) {
		this.fundRateStepDao = fundRateStepDao;
	}

	public FundRateService(){
		fundDao=new FundDao();
		fundRateStepDao=new FundRateStepDao();
		
		//
		fundRate=new FundRate();
		
	}
}
