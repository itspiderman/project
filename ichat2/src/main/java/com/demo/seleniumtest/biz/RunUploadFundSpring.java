package com.demo.seleniumtest.biz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.services.imp.FundService;

public class RunUploadFundSpring{	
	
	public static void main(String[] args){		
		RunUploadFundSpring runFundSelecnium=new RunUploadFundSpring();		
		runFundSelecnium.uploadFund();
	}
	
	private void uploadFund(){		
		//ClassPathXmlApplicationContext  context=new ClassPathXmlApplicationContext("applicationContext.xml");
		ClassPathXmlApplicationContext  context=null;
		if(context==null){
			context=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		}
		context.refresh();
		FundService fundService=(FundService)context.getBean("fundService");
		String xlsFileName="D:\\Life\\fund\\stock1fund.xls";
		String sheetName="stock1fundtest";
		//sheetName="stock1fund";
		sheetName="hybrid2fund";
		sheetName="bons3fund";
		sheetName="qdii6fund";
		sheetName="lof7fund";
		sheetName="monetary8fund";
		sheetName="monetaryICBC";
		fundService.uploadFund(xlsFileName, sheetName);
		
		if(context!=null){
			System.out.println("..... context closed");
			context.close();			
		}
	}

}