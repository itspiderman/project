package com.services.imp;

//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import com.demo.util.SpringContextUtils;
import com.services.dao.IFundWriteDao;
import com.services.pojo.fund.Fund;

public class FundServiceRunnable implements Runnable {
	
	private Fund fund;
	public void setFund(Fund fund) {
		this.fund = fund;
	}

	@Override
	public void run() {
		synRun();
	}
//	FundWriteDao fundWriteDao=(FundWriteDao)SpringContextUtils.getBean("fundWriteDao");
	
	private void synRun(){
		System.out.println("Start run thread for fund:"+fund.getFundCode()+"-"+fund.getFundName() );
		fundWriteDao.insertFund(fund);
	}
	//injection
	IFundWriteDao fundWriteDao;
	public void setFundWriteDao(IFundWriteDao fundWriteDao) {
		this.fundWriteDao = fundWriteDao;
	}	
}
