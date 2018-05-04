package com.atm.service;

import java.util.Map;



import com.atm.entity.Deposit;

import java.util.List;

public interface DepositService {
	
	
	
	public int insertSelective(Deposit record);

	
	public Deposit selectByPrimaryKey(Integer id) ;
	
	public int updateByPrimaryKeySelective(Deposit record);
	
    public List<Deposit> queryTop(Integer aid);

	
	public List<Deposit> queryList(Map<String, Object> map) ;

	
	public Integer queryTotal(Map<String, Object> map);


}
