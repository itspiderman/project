package com.services;

import java.util.List;

import com.services.pojo.fund.FundRateRpt;

public interface IFundRateRptService {	
	public void insertFundRateRpt(FundRateRpt fundRateRpt);
	public void insertFundRateRptThread(FundRateRpt fundRateRpt);
	public void insertFundRateRpt(List<FundRateRpt> ls);
	public void genFundRateRptByFundCode(String fundCode);
	public void genFundRateRpt();
}
