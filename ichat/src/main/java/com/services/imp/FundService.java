package com.services.imp;

import java.util.List;

import com.services.IFundService;
import com.services.dao.IFundDao;
import com.services.dao.imp.FundDao;
import com.services.pojo.fund.Fund;

public class FundService implements IFundService {
	@Override
	public Fund queryFundByFundCode(String fundCode) {
		return fundDao.queryByFundCode(fundCode);		
	}
	@Override
	public List<Fund> queryFundRateList() {
		return fundDao.queryFund();	
	}
	//injection
	IFundDao fundDao;
	public void setFundDao(IFundDao fundDao) {
		this.fundDao = fundDao;
	}
	//without injection
	FundService(){
		fundDao=new FundDao();
	}
}