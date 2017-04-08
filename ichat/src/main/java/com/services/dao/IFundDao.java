package com.services.dao;

import java.util.List;

import com.services.pojo.fund.Fund;

public interface IFundDao {
	public List<Fund> queryFund();
	public Fund queryByFundCode(String fundcode);

}
