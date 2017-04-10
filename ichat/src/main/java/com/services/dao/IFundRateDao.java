package com.services.dao;

import java.util.List;

import com.services.pojo.fund.FundRate;

public interface IFundRateDao {
	public FundRate getFundRateByFundCode(String fundCode);	
	public List<FundRate> getFundRate();
}
