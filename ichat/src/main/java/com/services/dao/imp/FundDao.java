package com.services.dao.imp;

import java.util.List;

import com.services.dao.IFundDao;
import com.services.pojo.fund.Fund;

public class FundDao implements IFundDao {
	private Fund fund;

	public Fund getFund() {
		fund=new Fund();
		String fundUrl="http://fund.eastmoney.com/001781.html";
		String fundCode="001781";
		String fundName="建信现代服务业股票";
		
		fund.setFundUrl(fundUrl);
		fund.setFundCode(fundCode);
		fund.setFundName(fundName);
		
		return fund;
	}

	public void setFund(Fund fund) {
		
		this.fund = fund;
	}

	@Override
	public List<Fund> fundQuery() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
