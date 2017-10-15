package com.demo.seleniumtest.biz;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunFundSeleniumSpring{	
	
	public static void main(String[] args){		
		String sCycleDate=null; 		 
		if(args.length>0){
			sCycleDate=args[0].trim();	
			//sCycleDate=dtFormat.format(new Date(sCycleDate));
		}else{	
			SimpleDateFormat dtFormat=new SimpleDateFormat("yyyy-MM-dd");
			sCycleDate=dtFormat.format(new Date());
		}
		System.out.println(sCycleDate);
		RunFundSeleniumSpring runFundSelecnium=new RunFundSeleniumSpring();
		//runFundSelecnium.runSelenium();
		runFundSelecnium.runSelenium(sCycleDate);
	}

	private void runSelenium(){
// 注意class-path的路径可以配置多个文件夹，多个jar包，之间用空格隔开，注意文件夹一定要在结尾加上/,例如：classpath为当前目录写 ./   为当前目前下级config文件夹则为 ./config/ 或者config/
//		ClassPathXmlApplicationContext  context=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		ClassPathXmlApplicationContext  context=new ClassPathXmlApplicationContext("applicationContext.xml");
		AFundSeleniumSpring fundSelenium=(FireFoxSeleniumSpring)context.getBean("fireFoxSelenium");
		System.out.println(fundSelenium.getBrowserName());
		fundSelenium.insertFundRateRpt();
		context.close();
	}
	private void runSelenium(String sCycleDate){		
				ClassPathXmlApplicationContext  context=new ClassPathXmlApplicationContext("applicationContext.xml");
				AFundSeleniumSpring fundSelenium=(FireFoxSeleniumSpring)context.getBean("fireFoxSelenium");
				System.out.println(fundSelenium.getBrowserName());
				fundSelenium.insertFundRateRpt(sCycleDate);
				context.close();
	}
}