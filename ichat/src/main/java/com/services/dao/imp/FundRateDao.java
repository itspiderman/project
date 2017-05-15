package com.services.dao.imp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.services.dao.IFundReadDao;
import com.services.dao.IFundRateDao;
import com.services.dao.IFundRateStepDao;
import com.services.pojo.fund.Fund;
import com.services.pojo.fund.FundRate;
import com.services.pojo.fund.FundRateStep;

public class FundRateDao implements IFundRateDao {
	
	@Override
	public FundRate getFundRateByFundCode(String fundCode) {
		FundRate fundRate=new FundRate();
		Fund fund=fundReadDao.queryByFundCode(fundCode);
		List<FundRateStep> list=fundRateStepDao.queryFundRateStepByFundCode(fund.getFundCode());
		
		fundRate.setFund(fund);
		fundRate.setSteps(list);
		return fundRate;
	}

	@Override
	public List<FundRate> getFundRate() {
		List<FundRate> frList=new ArrayList<FundRate>();
		
		Fund fund=null;		
		List<Fund> fList=fundReadDao.queryFundList();
		Iterator<Fund> fit=fList.iterator();
		
		while(fit.hasNext()){
			FundRate fr=new FundRate();
			fund=(Fund)fit.next();
			fr.setFund(fund);			
			fr.setSteps(fundRateStepDao.queryFundRateStepByFundCode(fund.getFundCode()));
			frList.add(fr);
		}
		return frList;
	}
	
	//injection
	IFundReadDao fundReadDao;
	IFundRateStepDao fundRateStepDao;
	public void setFundReadDao(IFundReadDao fundReadDao) {
		this.fundReadDao = fundReadDao;
	}
	public void setFundRateStepDao(IFundRateStepDao fundRateStepDao) {
		this.fundRateStepDao = fundRateStepDao;
	}
	//without injection
	public FundRateDao(){
		fundReadDao=new FundReadDao();
		fundRateStepDao=new FundRateStepDao();
	}

}
