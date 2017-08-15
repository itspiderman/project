package com.services.dao;

import java.util.List;

import com.services.pojo.fund.Fund;

public interface IFundWriteDao {
	//write dao : insert,update,delete
	// 1. insert
	public int insertFund(Fund fund);
	public int insertFund(List<Fund> ls);
	//2. update
	public int updateFund(String fundCode);
	public int updateFund(String[] fundCodes);
	public int uploadFund(String fileName);
	//3. delete
	public int deleteFund(String fundCode);
	public int deleteFund(String[] fundCodes);

}
