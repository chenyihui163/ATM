package com.atm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.dao.AccountMapper;
import com.atm.entity.Account;
import com.atm.service.AccountService;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;
	
	
	public int insertSelective(Account record) {
		// TODO Auto-generated method stub
		return this.accountMapper.insertSelective(record);
	}

	
	public Account selectByPrimaryKey(Integer aid) {
		// TODO Auto-generated method stub
		return this.accountMapper.selectByPrimaryKey(aid);
	}

	
	public int updateByPrimaryKeySelective(Account record) {
		// TODO Auto-generated method stub
		return this.accountMapper.updateByPrimaryKeySelective(record);
	}

	
	public Account selectUserCard_byAccount(Integer aid) {
		// TODO Auto-generated method stub
		return this.accountMapper.selectUserCard_byAccount(aid);
	}

	
	public Account getByAccount(Integer aid) {
		// TODO Auto-generated method stub
		return this.accountMapper.getByAccount(aid);
	}

	
	public List<Account> queryList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.accountMapper.queryList(map);
	}

	
	public Integer queryTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.accountMapper.queryTotal(map);
	}
	

}
