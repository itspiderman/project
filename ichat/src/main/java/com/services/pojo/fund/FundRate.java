package com.services.pojo.fund;

import java.util.List;

public class FundRate extends AFund {

	private List<FundRateStep> steps;	
	
	public List<FundRateStep> getSteps() {
		return steps;
	}
	public void setSteps(List<FundRateStep> steps) {
		this.steps = steps;
	} 
}
