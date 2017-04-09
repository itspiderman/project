package com.services.pojo.fund;

public class Fund{
	private String fundCode;
	private String fundName;
	private String fundUrl;
	private char typecode;
	
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
	public char getTypecode() {
		return typecode;
	}
	public void setTypecode(char typecode) {
		this.typecode = typecode;
	}
}
