package com.services.dao.imp;

import static org.junit.Assert.*;

import org.junit.Test;

import com.services.pojo.fund.Fund;

public class FundWriteDaoTest {

	@Test
	public void testInsertFundFund() {
		
		Fund fd2=new Fund();
		fd2.setFundUrl("http://fund.eastmoney.com/290004.html");
		fd2.setFundCode("290004");
		fd2.setFundName("泰信优质生活混合");
		fd2.setFundTypecode('2');
		FundWriteDao fundWriteDao=new FundWriteDao();
		int i=fundWriteDao.insertFund(fd2);
		assertEquals(1, i);
	}

//	@Test
//	public void testInsertFundListOfFund() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateFundString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateFundStringArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteFundString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteFundStringArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUploadFund() {
//		fail("Not yet implemented");
//	}

}
