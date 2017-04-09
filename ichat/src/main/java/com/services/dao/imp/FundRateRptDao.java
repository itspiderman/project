package com.services.dao.imp;

import java.util.List;
import java.util.Iterator;

import com.services.dao.IFundRateRptDao;
import com.services.pojo.fund.FundRateRpt;

public class FundRateRptDao implements IFundRateRptDao {

	@Override
	public void insertFundRateRpt(FundRateRpt fundRateRpt) {
		// TODO Auto-generated method stub
		System.out.println("insert one fundRateRpt: "+fundRateRpt.getFundCode());

	}

	@Override
	public void insertFundRateRpt(List<FundRateRpt> ls) {
		// TODO Auto-generated method stub
		Iterator<FundRateRpt> it=ls.iterator();
		FundRateRpt frRpt=null;
		while(it.hasNext()){
			frRpt=(FundRateRpt)it.next();
			System.out.println("FundRateRpt list, and last 2 week rate is "+frRpt.getLst1wRate());
		}

	}

	@Override
	public FundRateRpt queryFundRateRptByFundCode(String fundCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FundRateRpt> queryFundRateRpt() {
		// TODO Auto-generated method stub
		return null;
	}

}
