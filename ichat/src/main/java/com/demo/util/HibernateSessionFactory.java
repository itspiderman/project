package com.demo.util;

import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactory {
	private static SessionFactory sessionFactory = null;	
	final static StandardServiceRegistry registry =new StandardServiceRegistryBuilder().configure().build();	
	private static final ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();

	
	static{
		try{
			sessionFactory=new MetadataSources(registry).buildMetadata().buildSessionFactory();			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private HibernateSessionFactory(){		
	}
	public static Session getSession() throws HibernateException{
		Session session=(Session)threadLocal.get();
		if(session==null || !session.isOpen()){
			if(sessionFactory==null){
				rebuildSessionFactory();
			}
			session=(sessionFactory!=null)?sessionFactory.openSession():null;
			threadLocal.set(session);
		}		
		return session;
	}
	private static void rebuildSessionFactory(){
		try{
			sessionFactory=new MetadataSources(registry).buildMetadata().buildSessionFactory();			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void closeSession() throws HibernateException{
		Session session=(Session) threadLocal.get();
		threadLocal.set(null);
		if(session!=null){
			session.close();
		}
	}	
}
