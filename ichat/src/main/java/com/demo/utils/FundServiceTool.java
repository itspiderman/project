package com.demo.utils;

import com.services.imp.FundServiceRunnable;

public class FundServiceTool {
	//injection
	FundServiceRunnable fundServiceRunnable;
	public void setFundServiceRunnable(FundServiceRunnable fundServiceRunnable) {
		this.fundServiceRunnable = fundServiceRunnable;
	}
	
	//private static volatile FundServiceRunnable singletonFundServiceRunnable;

	public FundServiceRunnable getSingletonFundServiceRunnable() {
		return new FundServiceRunnable();
	}
	
}
