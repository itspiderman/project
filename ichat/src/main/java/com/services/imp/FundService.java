package com.services.imp;

import java.util.List;

import com.services.IFundService;
import com.services.dao.IFundReadDao;
import com.services.dao.IFundWriteDao;
import com.services.dao.imp.FundReadDao;
import com.services.pojo.fund.Fund;

public class FundService implements IFundService {
	//injection
	IFundReadDao fundReadDao;
	IFundWriteDao fundWriteDao;
	public void setFundReadDao(IFundReadDao fundDao) {
		this.fundReadDao = fundDao;
	}
	
	public void setFundWriteDao(IFundWriteDao fundWriteDao) {
		this.fundWriteDao = fundWriteDao;
	}

	//without injection
	FundService(){
		fundReadDao=new FundReadDao();
	}
	
	@Override
	public Fund queryFundByFundCode(String fundCode) {
		return fundReadDao.queryByFundCode(fundCode);		
	}
	@Override
	public List<Fund> queryFundList() {
		return fundReadDao.queryFundList();	
	}

	@Override
	public int insertFund(Fund fund) {
		return fundWriteDao.insertFund(fund);
	}
	@Override
	public int insertFund(List<Fund> fundList) {
		return fundWriteDao.insertFund(fundList);
	}
}