package com.services.dao.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.services.dao.IFundWriteDao;
import com.services.pojo.fund.Fund;

public class FundWriteDao implements IFundWriteDao {

	@Override
	public int insertFund(Fund fund) {
		
		SessionFactory sessionFactory = null;
		Session session=null;
		final StandardServiceRegistry registry =new StandardServiceRegistryBuilder().configure().build();		
		try{
			System.out.println("start insert or update fund to DB for "+fund.getFundName());
			sessionFactory=new MetadataSources(registry).buildMetadata().buildSessionFactory();
			
			session=sessionFactory.openSession();
			/*
			 org.hibernate.HibernateException: No CurrentSessionContext configured!
			 at org.hibernate.internal.SessionFactoryImpl.getCurrentSession(SessionFactoryImpl.java:454)
			 */
			//session=sessionFactory.getCurrentSession();
			
			session.beginTransaction();
			//session.save(fund);			
			session.saveOrUpdate(fund);
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
			System.out.println("End insert or update fund to DB for "+fund.getFundName());
			
		}catch(Exception e){
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}finally{
			if(session!=null){
				session.close();
			}
			if(sessionFactory!=null){
				sessionFactory.close();
			}
		}		
		return 1;
	}

	@Override
	public int insertFund(List<Fund> ls) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFund(String fundCode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFund(String[] fundCodes) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFund(String fundCode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFund(String[] fundCodes) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int uploadFund(String xlsFileName) {
		// TODO Auto-generated method stub
		System.out.println("uploadFund(String fileName)");
		return 0;
	}

}
