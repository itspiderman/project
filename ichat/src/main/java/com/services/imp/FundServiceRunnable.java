package com.services.imp;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.demo.utils.SpringContextUtils;
import com.services.dao.imp.FundWriteDao;
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
	FundWriteDao fundWriteDao;
	private void synRun(){
		if(fundWriteDao==null){
			fundWriteDao=(FundWriteDao)SpringContextUtils.getBean("fundWriteDao");
			System.out.println("Created fundWrinteDao in FundServiceRunnable at "+(new SimpleDateFormat("HH:mm:ss")).format((new Date())));
		}
		System.out.println("Start run thread for fund:"+fund.getFundName() );
		fundWriteDao.insertFund(fund);
		
	}	
}
