package com.services.dao.imp;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import com.demo.util.HibernateSessionFactory;
import com.services.dao.IFundReadDao;
import com.services.pojo.fund.Fund;

public class FundReadDao implements IFundReadDao {
	private Fund fund;
	private Date sysDate=new Date();

	//
	String fundUrl="http://fund.eastmoney.com/001781.html";
	String fundCode="001781";
	String fundName="建信现代服务业股票";
	char fundTypeCode='1'; //股票开型
	Timestamp crtDateTime=new Timestamp(sysDate.getTime());
	//
	public Fund getFundByFundCode(String fundCode) {
		fund=new Fund();		
		fund.setFundUrl(fundUrl);
		fund.setFundCode(fundCode);
		fund.setFundName(fundName);
		fund.setFundTypecode(fundTypeCode);
		fund.setCrtDateTime(crtDateTime);
		return fund;
	}

	public void setFund(Fund fund) {
		
		this.fund = fund;
	}

	@Override
	public List<Fund> queryFundList() {

		List<Fund> fundList=null;
		Session session=HibernateSessionFactory.getSession();
		try{
		//Session session=HibernateSessionFactory.getSessionFactory().openSession();	
		
//		HQL 大小写敏感, HQL操作的是类对类，而不是表对像
//		String hql="from Fund order by fundTypecode asc, fundCode asc";
//		String hql="from Fund a where not exists (select b.fundCode from FundRateRpt b where b.fundCode=a.fundCode) order by a.fundTypecode asc, a.fundCode asc";
//		Query query=session.createQuery(hql);
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String hql="from Fund a where not exists (select b.fundCode from FundRateRpt b where b.fundCode=a.fundCode and (b.lstUpdDate>?)) order by a.fundTypecode asc, a.fundCode asc";
		Query query=session.createQuery(hql)
				.setParameter(0,format.parse("2017-08-03"));
		fundList=query.list();		
		
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			System.out.println("close session ..... ");			
			HibernateSessionFactory.closeSession();			
		}
		return fundList;
	}
	public List<Fund> queryFundList(Timestamp crtDateTime) {

		List<Fund> fundList=null;
		Session session=HibernateSessionFactory.getSession();
		try{		
//		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");		
	
		DetachedCriteria  criteria =DetachedCriteria.forClass(Fund.class); 
		

		criteria.add(Restrictions.eq("fundCode","001232"));	
		//criteria.add(Restrictions.eq("crtDateTime",crtDateTime));
		criteria.add(Restrictions.gt("crtDateTime",crtDateTime));
		
		fundList =criteria .getExecutableCriteria(session).list();
		
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			System.out.println("close session ..... ");			
			HibernateSessionFactory.closeSession();			
		}
		return fundList;
	}

	@Override
	public Fund queryByFundCode(String fundcode) {
		Fund fd=new Fund();
		//
		fd.setFundUrl(fundUrl);
		fd.setFundCode(fundCode);
		fd.setFundName(fundName);
		fd.setCrtDateTime(crtDateTime);
		//
		return fd;
	}
	public HashMap queryFund(){
		HashMap<String, String> hm=new HashMap<String, String>(0);
		Session session=HibernateSessionFactory.getSession();
		String hql="from Fund";
		//@SuppressWarnings("deprecation")
		List<Fund> list =(List<Fund>) session.createQuery(hql).list();		
		
		for(Fund fund: list){
			hm.put(fund.getFundCode(),fund.getFundName());
		}		
		return hm;		
	}

}
