package com.atm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.dao.CardMapper;
import com.atm.entity.Card;
import com.atm.service.CardService;




@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardMapper cardMapper;
	public int insertSelective(Card record) {
		// TODO Auto-generated method stub
		return this.cardMapper.insertSelective(record);
	}

	
	public Card selectByPrimaryKey(Integer cardid) {
		// TODO Auto-generated method stub
		return this.cardMapper.selectByPrimaryKey(cardid);
	}

	
	public int updateByPrimaryKeySelective(Card record) {
		// TODO Auto-generated method stub
		return this.cardMapper.updateByPrimaryKeySelective(record);
	}

	
	public Card selectAccountbyCard(Integer cardid) {
		// TODO Auto-generated method stub
		return this.cardMapper.selectAccountbyCard(cardid);
	}

	


	
	public Integer queryTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.cardMapper.queryTotal(map);
	}





	public List<Card> queryList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return this.cardMapper.queryList(map);
	}


	

}
