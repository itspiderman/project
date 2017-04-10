package com.services.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.services.pojo.fund.Fund;

public class FundServiceTest {
	FundService fs=new FundService();

	@Test
	public void testQueryFundRateList() {
		Fund fund=new Fund();
		List<Fund> ls=fs.queryFundList();
		
//		Iterator<Fund> it=ls.iterator();
//		while(it.hasNext()){
//			fund=(Fund) it.next();
//		}
		
		fund=ls.get(0);
		assertEquals("001781",fund.getFundCode());
		assertEquals("建信现代服务业股票",fund.getFundName());
		assertEquals("http://fund.eastmoney.com/001781.html",fund.getFundUrl());
	}



}
