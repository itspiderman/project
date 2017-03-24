package com.services.pojo;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class FundRateTest extends TestCase {
	FundRate fundRate=new FundRate();
	String fundUrl="http://fund.eastmoney.com/001781.html";
	String fundCode="001781";
	String fundName="建信现代服务业股票";
	
	@Before
	public void initial(){
	
	}	

	@Test
	public void testGetFundUrl() {
		fundRate.setFundUrl(fundUrl);
		assertEquals("http://fund.eastmoney.com/001781.html",fundRate.getFundUrl());
	}

	@Test
	public void testGetFundCode() {
		fundRate.setFundCode(fundCode);
		assertEquals("001781",fundRate.getFundCode());
	}

	@Test
	public void testGetFundName() {
		fundRate.setFundName(fundName);
		assertEquals("建信现代服务业股票",fundRate.getFundName());
	}

	@Test
	public void testGetSteps() {
		fundRate.setFundUrl(fundUrl);
		assertEquals("http://fund.eastmoney.com/001781.html",fundRate.getFundUrl());
	}
}
