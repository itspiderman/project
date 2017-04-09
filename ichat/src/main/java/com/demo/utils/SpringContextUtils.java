package com.demo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtils implements ApplicationContextAware {
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

}
