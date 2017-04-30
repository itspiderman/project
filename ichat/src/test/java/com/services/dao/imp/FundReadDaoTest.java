package com.services.dao.imp;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.services.pojo.fund.Fund;

public class FundReadDaoTest {

	@Test
	public void testQueryFundList() {
		FundReadDao fundReadDao=new FundReadDao();
		List<Fund> fundList=fundReadDao.queryFundList();
		Iterator<Fund> it=fundList.iterator();
		Fund fund=null;
		while(it.hasNext()){
			fund=it.next();
			System.out.println(fund.getFundCode());
			System.out.println(fund.getFundName());
			break;
		}
		
		
		fail("Not yet implemented");
	}


}
