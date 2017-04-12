package com.demo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextUtils implements ApplicationContextAware {
	//Multi-thread solution
	//http://bbs.csdn.net/topics/390615376?page=1
	//http://littie1987.iteye.com/blog/937877
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		SpringContextUtils.applicationContext=applicationContext;
	}
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}
	public static Object getBean(String beanID) throws BeansException{		
		return applicationContext.getBean(beanID);
	}
	
	//// rewrite
//	private static ClassPathXmlApplicationContext applicationContext;
//
//	@Override
//	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		// TODO Auto-generated method stub
//		SpringContextUtils.applicationContext=(ClassPathXmlApplicationContext) applicationContext;
//	}
//	public static ApplicationContext getApplicationContext(){
//		return applicationContext;
//	}
//	public static Object getBean(String beanID) throws BeansException{
//		//applicationContext.refresh();
//		return applicationContext.getBean(beanID);
//	}

}
