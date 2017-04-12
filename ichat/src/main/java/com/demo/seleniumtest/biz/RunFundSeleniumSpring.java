package com.demo.seleniumtest.biz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunFundSeleniumSpring{	
	
	public static void main(String[] args){		
		RunFundSeleniumSpring runFundSelecnium=new RunFundSeleniumSpring();		
		runFundSelecnium.runSelenium();		
	}

	private void runSelenium(){		
		ClassPathXmlApplicationContext  context=new ClassPathXmlApplicationContext("applicationContext.xml");
		AFundSeleniumSpring fundSelenium=(FireFoxSeleniumSpring)context.getBean("fireFoxSelenium");
		System.out.println(fundSelenium.getBrowserName());
		fundSelenium.insertFundRateRpt();
		context.close();
	}	
}