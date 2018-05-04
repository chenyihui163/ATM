package com.atm.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.atm.entity.Account;

@Service
public interface AccountService {
	
	

	
	
	public int insertSelective(Account record) ;

	
	public Account selectByPrimaryKey(Integer aid) ;

	
	public int updateByPrimaryKeySelective(Account record) ;

	
	public Account selectUserCard_byAccount(Integer aid) ;

	
	public Account getByAccount(Integer aid) ;

	
	public List<Account> queryList(Map<String, Object> map);

	
	public Integer queryTotal(Map<String, Object> map) ;

}
