package com.services.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

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
//		//demo start
//		// fund 1
//		Fund fd=new Fund();
//		fd.setFundUrl(fundUrl);
//		fd.setFundCode(fundCode);
//		fd.setFundName(fundName);
//		fd.setFundTypecode(fundTypeCode);
//		fd.setCrtDateTime(crtDateTime);
//		//fund2
//		Fund fd2=new Fund();
//		fd2.setFundUrl("http://fund.eastmoney.com/290004.html");
//		fd2.setFundCode("290004");
//		fd2.setFundName("泰信优质生活混合");
//		fd2.setFundTypecode('2');
//		fd2.setCrtDateTime(crtDateTime);
//		//demo end		
//		List<Fund> ls=new ArrayList<Fund>();
//		// connect to db to query fund records
//		ls.add(fd);
//		ls.add(fd2);
		Session session=HibernateSessionFactory.getSessionFactory().openSession();
		// HQL 大小写敏感
//		String hql="from Fund order by fundtypecode asc, fundcode asc";
		String hql="from Fund a where not exists (select b.fundCode from FundRateRpt b where b.fundCode=a.fundCode) order by a.fundTypecode asc, a.fundCode asc";
		Query query=session.createQuery(hql);
		List<Fund> fundList=query.list();

		session.close();
		HibernateSessionFactory.closeSessionFactory();
		
		
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
