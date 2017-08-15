package com.services.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.services.pojo.fund.Fund;

public interface IFundReadDao {
	//query
	public List<Fund> queryFundList();
	public List<Fund> queryFundList(Timestamp lstUpdDate);
	public Fund queryByFundCode(String fundcode);
}
