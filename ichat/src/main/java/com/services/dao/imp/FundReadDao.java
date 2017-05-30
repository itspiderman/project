package com.services.dao.imp;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

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
		
		System.out.println("start fundReadDao. queryFundList");
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
				.setParameter(0,format.parse("2017-05-26"));
		fundList=query.list();		
		
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
}
