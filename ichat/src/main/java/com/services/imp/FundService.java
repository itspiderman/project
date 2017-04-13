package com.services.imp;

import java.util.Date;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import com.services.IFundService;
import com.services.dao.IFundReadDao;
import com.services.dao.IFundWriteDao;
import com.services.dao.imp.FundReadDao;
import com.services.pojo.fund.Fund;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

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
	public FundService(){
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
	
	@Override
	public int uploadFund(String xlsFileName,String sheetName) {
		Workbook workbook=null;
		Sheet sheet=null;
		//int columns=0;
		int rows=0;
		int row=1;
		Date sysDate=null;
		
		
		//fundServiceRunnable=(FundServiceRunnable)SpringContextUtils.getBean("fundServiceRunnable");
		try {
			workbook=Workbook.getWorkbook(new File(xlsFileName));
			sheet=workbook.getSheet(sheetName);
			//columns=sheet.getColumns();
			rows=sheet.getRows();
			while(row<rows){												
				synchronized(this){
					Fund fund=new Fund();
					sysDate=new Date();
					fund.setFundCode(sheet.getCell(1,row).getContents());
					fund.setFundName(sheet.getCell(2, row).getContents());
					fund.setFundUrl(sheet.getCell(3, row).getContents());
					fund.setFundTypecode(sheet.getCell(4,row).getContents().charAt(0));
					fund.setCrtDateTime(new Timestamp(sysDate.getTime()));
					System.out.println("start row: "+row+","+fund.getFundName());
					insertFundThread(fund);					
				}
				//After handle 20 rows, make thread sleep for 5 seconds
				if((row%20)==0){
					try {
						System.out.println("After handle 20 rows, make thread sleep for 5 seconds.....");
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				row++;
			}
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sheet=null;
			workbook.close();
		}
		row--;
		return row;
	}
	
	public void insertFundThread(Fund fund){
		FundServiceRunnable fundServiceRunnable=new FundServiceRunnable();
		fundServiceRunnable.setFund(fund);
		Thread th=new Thread(fundServiceRunnable);		
		th.start();	
	}
}