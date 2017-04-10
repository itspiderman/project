package com.services;

import java.util.List;

import com.services.pojo.fund.Fund;

public interface IFundService {
	//call read dao
	public Fund queryFundByFundCode(String fundCode);
	public List<Fund> queryFundList();
	//call write dao
	public int insertFund(Fund fund);
	public int insertFund(List<Fund> fundList);
}
