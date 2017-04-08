package com.demo.seleniumtest.biz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunFundSeleniumSpring{	
	
	public static void main(String[] args){		
		
		RunFundSeleniumSpring runFundSelecnium=new RunFundSeleniumSpring();		
		runFundSelecnium.runSelenium();
		
	}
	
	private void runSelenium(){
		// fundSelenium=new FireFoxSelenium(); //use injection to load class instance
		ClassPathXmlApplicationContext  context=new ClassPathXmlApplicationContext("applicationContext.xml");
		fundSelenium=(FireFoxSeleniumSpring)context.getBean("fireFoxSelenium");
		System.out.println(fundSelenium.getBrowserName());
		fundSelenium.genFundRateRpt();
		context.close();
	}
		
	
	//inject
	AFundSeleniumSpring fundSelenium;
	public void setFundSelenium(AFundSeleniumSpring fundSelenium) {
		this.fundSelenium = fundSelenium;
	}	
}
