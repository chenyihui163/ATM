package com.atm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.dao.WithdrawMapper;
import com.atm.entity.Withdraw;
import com.atm.service.WithdrawService;

import java.util.List;

@Service
public class WithdrawServiceImpl implements WithdrawService {

	
	
	@Autowired
	private WithdrawMapper withdrawMapper;
	@Override
	public int insertSelective(Withdraw record) {
		// TODO Auto-generated method stub
		return this.withdrawMapper.insertSelective(record);
	}

	@Override
	public Withdraw selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return this.withdrawMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Withdraw record) {
		// TODO Auto-generated method stub
		return this.withdrawMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Withdraw> queryList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.withdrawMapper.queryList(map);
	}

	@Override
	public Integer queryTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.withdrawMapper.queryTotal(map);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Withdraw record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Withdraw record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Withdraw> queryTop(Integer aid) {
		// TODO Auto-generated method stub
		return this.withdrawMapper.queryTop(aid);
	}

}
