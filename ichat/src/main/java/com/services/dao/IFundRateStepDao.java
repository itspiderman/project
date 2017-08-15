package com.services.dao;

import java.util.List;

import com.services.pojo.other.FundRateStep;

public interface IFundRateStepDao {
	public List<FundRateStep> queryFundRateStep();
	public List<FundRateStep> queryFundRateStepByFundCode(String fundCode);

}
