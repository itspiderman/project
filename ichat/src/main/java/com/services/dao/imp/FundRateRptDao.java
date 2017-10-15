package com.services.dao.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Iterator;

import com.services.dao.IFundRateRptDao;
import com.services.pojo.fund.FundRateRpt;

public class FundRateRptDao implements IFundRateRptDao {

	@Override
	public void insertFundRateRpt(FundRateRpt fundRateRpt) {		
		//System.out.println("insert one fundRateRpt: "+fundRateRpt.getFundCode());
		SessionFactory sessionFactory = null;
		Session session=null;
		final StandardServiceRegistry registry =new StandardServiceRegistryBuilder().configure().build();		
		try{
			System.out.println("start insert or update fundRateRpt to DB for "+fundRateRpt.getFundCode());
			sessionFactory=new MetadataSources(registry).buildMetadata().buildSessionFactory();			
			session=sessionFactory.openSession();			
			session.beginTransaction();			
			session.saveOrUpdate(fundRateRpt);
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
			System.out.println("End insert or update fund to DB for "+fundRateRpt.getFundCode());
			
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
	}

	@Override
	public void insertFundRateRpt(List<FundRateRpt> ls) {
		// TODO Auto-generated method stub
		Iterator<FundRateRpt> it=ls.iterator();
		FundRateRpt frRpt=null;
		while(it.hasNext()){
			frRpt=(FundRateRpt)it.next();
			System.out.println("FundRateRpt list, and last 2 week rate is "+frRpt.getLst1wRate());
		}
	}

	@Override
	public FundRateRpt queryFundRateRptByFundCode(String fundCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FundRateRpt> queryFundRateRpt() {
		// TODO Auto-generated method stub
		return null;
	}

}
