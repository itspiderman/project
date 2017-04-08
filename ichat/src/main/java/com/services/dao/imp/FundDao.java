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
	//
	public Fund getFund() {
		fund=new Fund();		
		fund.setFundUrl(fundUrl);
		fund.setFundCode(fundCode);
		fund.setFundName(fundName);		
		return fund;
	}

	public void setFund(Fund fund) {
		
		this.fund = fund;
	}

	@Override
	public List<Fund> queryFund() {
		//demo start
		Fund fd=new Fund();
		fd.setFundUrl(fundUrl);
		fd.setFundCode(fundCode);
		fd.setFundName(fundName);		
		//demo end		
		List<Fund> ls=new ArrayList<Fund>();
		// connect to db to query fund records
		ls.add(fd);
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
