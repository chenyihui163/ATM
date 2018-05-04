package com.atm.service;

import java.util.Map;



import com.atm.entity.Transfer;

import java.util.List;

public interface TransferService {
	
	
	
	
	public int insertSelective(Transfer record);

	
	public Transfer selectByPrimaryKey(Integer tid) ;

	
	public int updateByPrimaryKeySelective(Transfer record);
	
    public  List<Transfer> queryTop (Integer senderid);

	
	public List<Transfer> queryList(Map<String, Object> map) ;

	
	public Integer queryTotal(Map<String, Object> map) ;


}
