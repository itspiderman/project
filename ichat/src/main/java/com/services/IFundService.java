package com.services;

import java.util.List;

import com.services.pojo.fund.Fund;

public interface IFundService {
	public Fund queryFundByFundCode(String fundCode);
	public List<Fund> queryFundRateList();
}
