package com.demo.seleniumtest.biz;

public class RunFundSelenium{	
	
	public static void main(String[] args){		
		RunFundSelenium runFundSelecnium=new RunFundSelenium();		
		runFundSelecnium.runSelenium();		
	}
	
	private void runSelenium(){
		// run firefox
//		fundSelenium=new FireFoxSelenium();
//		System.out.println(fundSelenium.getBrowserName());
//		fundSelenium.insertFundRateRpt();
		// run HtmlUnit		
//		fundSelenium=new HtmlUnitSelenium();
//		System.out.println(fundSelenium.getBrowserName());
//		fundSelenium.insertFundRateRpt();
	}
	
	//inject
	AFundSelenium fundSelenium;
}
