package com.services.pojo;

import java.util.HashMap;
import java.util.List;

public class FundRate {
	private String fundUrl;
	private String fundCode;
	private String fundName;
	private List<HashMap<String,String>> steps;
	
	public String getFundUrl() {
		return fundUrl;
	}
	public void setFundUrl(String fundUrl) {
		this.fundUrl = fundUrl;
	}
	public String getFundCode() {
		return fundCode;
	}
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public List<HashMap<String, String>> getSteps() {
		return steps;
	}
	public void setSteps(List<HashMap<String, String>> steps) {
		this.steps = steps;
	} 
}
