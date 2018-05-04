package com.atm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.dao.TransferMapper;
import com.atm.entity.Transfer;
import com.atm.service.TransferService;

import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

	
	@Autowired
	private TransferMapper transferMapper;
	@Override
	public int insertSelective(Transfer record) {
		// TODO Auto-generated method stub
		return this.transferMapper.insertSelective(record);
	}

	@Override
	public Transfer selectByPrimaryKey(Integer tid) {
		// TODO Auto-generated method stub
		return this.transferMapper.selectByPrimaryKey(tid);
	}

	@Override
	public int updateByPrimaryKeySelective(Transfer record) {
		// TODO Auto-generated method stub
		return this.transferMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Transfer> queryList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.transferMapper.queryList(map);
	}

	@Override
	public Integer queryTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.transferMapper.queryTotal(map);
	}

	@Override
	public List<Transfer> queryTop(Integer senderid) {
		// TODO Auto-generated method stub
		return this.transferMapper.queryTop(senderid);
	}

}
