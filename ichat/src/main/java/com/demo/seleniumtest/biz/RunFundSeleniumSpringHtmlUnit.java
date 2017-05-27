package com.demo.seleniumtest.biz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunFundSeleniumSpringHtmlUnit{	
	
	public static void main(String[] args){		
		RunFundSeleniumSpringHtmlUnit runFundSelecnium=new RunFundSeleniumSpringHtmlUnit();		
		runFundSelecnium.runSelenium();		
	}
	
	private void runSelenium(){
		ClassPathXmlApplicationContext  context=new ClassPathXmlApplicationContext("./spring/applicationContext.xml");
		AFundSeleniumSpring fundSelenium=(HtmlUnitSeleniumSpring)context.getBean("htmlUnitSeleniumSpring");
		System.out.println(fundSelenium.getBrowserName());
		fundSelenium.insertFundRateRpt();
		context.close();
	}	
}
