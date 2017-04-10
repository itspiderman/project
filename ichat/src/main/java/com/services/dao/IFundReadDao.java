package com.services.dao;

import java.util.List;

import com.services.pojo.fund.Fund;

public interface IFundReadDao {
	//query
	public List<Fund> queryFundList();
	public Fund queryByFundCode(String fundcode);
}
