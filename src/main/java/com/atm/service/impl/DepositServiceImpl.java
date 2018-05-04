package com.atm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.dao.DepositMapper;
import com.atm.entity.Deposit;
import com.atm.service.DepositService;

import java.util.List;

@Service
public class DepositServiceImpl implements DepositService {

	@Autowired
	private DepositMapper depositMapper;
	
	public int insertSelective(Deposit record) {
		// TODO Auto-generated method stub
		return this.depositMapper.insertSelective(record);
	}

	
	public Deposit selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return this.depositMapper.selectByPrimaryKey(id);
	}

	
	public int updateByPrimaryKeySelective(Deposit record) {
		// TODO Auto-generated method stub
		return this.depositMapper.updateByPrimaryKeySelective(record);
	}

	
	public List<Deposit> queryList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.depositMapper.queryList(map);
	}

	
	public Integer queryTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.depositMapper.queryTotal(map);
	}


	@Override
	public List<Deposit> queryTop(Integer aid) {
		// TODO Auto-generated method stub
		return this.depositMapper.queryTop(aid);
	}

}
