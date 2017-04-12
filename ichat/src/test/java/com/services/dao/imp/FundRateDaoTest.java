package com.services.dao.imp;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.services.pojo.fund.Fund;
import com.services.pojo.fund.FundRate;
import com.services.pojo.fund.FundRateStep;

public class FundRateDaoTest {
	
	

	@Test
	public void testQueryFundRate() {
		FundRateDao fundRateDao=new FundRateDao();
		
		List<FundRate> list=fundRateDao.getFundRate();
		Iterator<FundRate> it=list.iterator();
		FundRate fundRate=null;		
		Fund fund=null;		
		//List<FundRateStep> sList=null;		
		while(it.hasNext()){						
			fundRate=(FundRate)it.next();			
			break;
		}		
		fund=fundRate.getFund();
		FundRateStep fundRateStep=(FundRateStep) fundRate.getSteps().get(0);
		
		assertEquals("001781",fund.getFundCode());
		assertEquals("建信现代服务业股票",fund.getFundName());
		assertEquals("http://fund.eastmoney.com/001781.html",fund.getFundUrl());
		assertEquals('1',fund.getFundTypecode());
		assertEquals(1, fundRateStep.getSeq());
	}

}
