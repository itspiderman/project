package com.services.dao.imp;

import java.util.ArrayList;
import java.util.List;

import com.services.dao.IFundDao;
import com.services.pojo.fund.Fund;

public class FundDao implements IFundDao {
	private Fund fund;

	//
	String fundUrl="http://fund.eastmoney.com/001781.html";
	String fundCode="001781";
	String fundName="建信现代服务业股票";
	char fundTypeCode='1'; //股票开型
	//
	public Fund getFundByFundCode(String fundCode) {
		fund=new Fund();		
		fund.setFundUrl(fundUrl);
		fund.setFundCode(fundCode);
		fund.setFundName(fundName);
		fund.setTypecode(fundTypeCode);
		return fund;
	}

	public void setFund(Fund fund) {
		
		this.fund = fund;
	}

	@Override
	public List<Fund> queryFundList() {
		//demo start
		// fund 1
		Fund fd=new Fund();
		fd.setFundUrl(fundUrl);
		fd.setFundCode(fundCode);
		fd.setFundName(fundName);
		fd.setTypecode(fundTypeCode);
		//fund2
		Fund fd2=new Fund();
		fd2.setFundUrl("http://fund.eastmoney.com/290004.html");
		fd2.setFundCode("290004");
		fd2.setFundName("泰信优质生活混合");
		fd2.setTypecode('2');
		//demo end		
		List<Fund> ls=new ArrayList<Fund>();
		// connect to db to query fund records
		ls.add(fd);
		ls.add(fd2);
		return ls;
	}

	@Override
	public Fund queryByFundCode(String fundcode) {
		Fund fd=new Fund();
		//
		fd.setFundUrl(fundUrl);
		fd.setFundCode(fundCode);
		fd.setFundName(fundName);
		//
		return fd;
	}
	
	

}
