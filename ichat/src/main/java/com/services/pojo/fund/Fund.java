package com.services.pojo.fund;

import java.sql.Timestamp;

public class Fund{
	private String fundCode;
	private String fundName;
	private String fundUrl;
	private char fundTypecode;
	private Timestamp crtDateTime;
	private char rcdsts;
	
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
	public char getFundTypecode() {
		return fundTypecode;
	}
	public void setFundTypecode(char fundTypecode) {
		this.fundTypecode = fundTypecode;
	}
	public Timestamp getCrtDateTime() {
		return crtDateTime;
	}
	public void setCrtDateTime(Timestamp crtDateTime) {
		this.crtDateTime = crtDateTime;
	}
	public char getRcdsts() {
		return rcdsts;
	}
	public void setRcdsts(char rcdsts) {
		this.rcdsts = rcdsts;
	}
}
