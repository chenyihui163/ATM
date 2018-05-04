package com.atm.service;

import java.util.Map;

import com.atm.entity.Withdraw;

import java.util.List;

public interface WithdrawService  {

	
	public int deleteByPrimaryKey(Integer id);

	
	public int insert(Withdraw record) ;


	public int insertSelective(Withdraw record);

	
	public Withdraw selectByPrimaryKey(Integer id) ;

	
	public int updateByPrimaryKeySelective(Withdraw record) ;

	
	public int updateByPrimaryKey(Withdraw record) ;
	
	
    public List<Withdraw> queryTop (Integer aid);


	
	public List<Withdraw> queryList(Map<String, Object> map) ;

	
	public Integer queryTotal(Map<String, Object> map);

}
