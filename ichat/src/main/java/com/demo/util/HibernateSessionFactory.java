package com.demo.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactory {
	private static SessionFactory sessionFactory = null;
	final static StandardServiceRegistry registry =new StandardServiceRegistryBuilder().configure().build();
	
	
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null){
			sessionFactory=new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}
		return sessionFactory;
	}
	public static void closeSessionFactory(){
		sessionFactory.close();
	}

}
