package com.services;

import java.util.List;

import com.services.pojo.fund.Fund;

public interface IFundService {
	//public static final Fund fund=null;
	public List<Fund> queryFundRateList();
}
