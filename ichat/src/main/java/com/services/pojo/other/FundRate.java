package com.services.pojo.other;

import java.util.List;

import com.services.pojo.fund.Fund;

public class FundRate {
	private Fund fund;
	private List<FundRateStep> steps;	
	public Fund getFund() {
		return fund;
	}
	public void setFund(Fund fund) {
		this.fund = fund;
	}
	public List<FundRateStep> getSteps() {
		return steps;
	}
	public void setSteps(List<FundRateStep> steps) {
		this.steps = steps;
	}
}
