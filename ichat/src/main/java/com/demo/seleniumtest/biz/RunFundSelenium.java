package com.demo.seleniumtest.biz;

public class RunFundSelenium{	
	
	public static void main(String[] args){		
		
		RunFundSelenium runFundSelecnium=new RunFundSelenium();		
		runFundSelecnium.runSelenium();
		
	}
	
	private void runSelenium(){
		fundSelenium=new FireFoxSelenium();
		System.out.println(fundSelenium.getBrowserName());
		fundSelenium.genFundRateRpt();
	}
	
	//inject
	AFundSelenium fundSelenium;
	public void setFundSelenium(AFundSelenium fundSelenium) {
		this.fundSelenium = fundSelenium;
	}	
}
