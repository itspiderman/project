package com.services.dao;

import java.util.List;

import com.services.pojo.fund.FundRateRpt;
public interface IFundRateRptDao {
	//insert fund rate data into report db table.
	public void insertFundRateRpt(FundRateRpt fundRateRpt);
	public void insertFundRateRpt(List<FundRateRpt> ls);
	//query fund rate data from report db table
	public FundRateRpt queryFundRateRptByFundCode(String fundCode);
	public List<FundRateRpt> queryFundRateRpt(); 
}
