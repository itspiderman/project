package com.services.dao;

import java.util.List;

import com.services.pojo.fund.FundRateStep;

public interface IFundRateStepDao {
	public List<FundRateStep> queryFundRateStep();
	public List<FundRateStep> queryFundRateStepByFundCode(String fundCode);

}
