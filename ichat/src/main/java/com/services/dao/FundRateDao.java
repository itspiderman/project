package com.services.dao;

import com.services.pojo.FundRate;

public class FundRateDao {
	private FundRate fundRate;

	public FundRate getFundRate() {
		fundRate=new FundRate();
		String fundUrl="http://fund.eastmoney.com/001781.html";
		String fundCode="001781";
		String fundName="建信现代服务业股票";
		
		fundRate.setFundUrl(fundUrl);
		fundRate.setFundCode(fundCode);
		fundRate.setFundName(fundName);
		
		return fundRate;
	}

	public void setFundRate(FundRate fundRate) {

		
		this.fundRate = fundRate;
	}
	

}
